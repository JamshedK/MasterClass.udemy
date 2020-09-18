package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox isToClearChecked;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e){
        if (e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        }
        else if (e.getSource().equals(byeButton)){
            System.out.println("Bye, " + nameField.getText());
        }

       Runnable task = new Runnable() {
           @Override
           public void run() {
               // just to test what happens when thread is too busy
               try{
                   String s = Platform.isFxApplicationThread() ? "UI thread" : "Background thread";
                   System.out.println("I am going to sleep in " + s);
                   Thread.sleep(10000);
                   Platform.runLater(new Runnable() {
                       @Override
                       public void run() {
                           String s = Platform.isFxApplicationThread() ? "UI thread" : "Background thread";
                           System.out.println("I am updating the label in " + s);
                           ourLabel.setText("We did something!!");
                       }
                   });
               }
               catch (InterruptedException event){
                   // not necessary at the moment
               }

           }
       };
        new Thread(task).start();

        if (isToClearChecked.isSelected()){
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    public void handleMousePressed(){
        nameField.clear();
    }

    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean isEmpty = text.isEmpty() || text.trim().isEmpty(); // trim is for white spaces
        helloButton.setDisable(isEmpty);
        byeButton.setDisable(isEmpty);
    }
}
