package com.udemy.masterclass.todolist;
import com.udemy.masterclass.todolist.datamodel.TodoData;
import com.udemy.masterclass.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Label deadlineLabel;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private ToggleButton filterToggleButton;
    @FXML
    private FilteredList<TodoItem> filteredList;

    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;


    public void initialize() {
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        MenuItem editMenuItem = new MenuItem("Edit");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });
        editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
                showEditDialogPane(selectedItem);
            }
        });
        listContextMenu.getItems().addAll(deleteMenuItem, editMenuItem);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    descriptionArea.setText(item.getDescription());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy"); // "d M yy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return true;
            }
        };
        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return item.getDeadline().equals(LocalDate.now());
            }
        };

        // to filter items
        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), wantAllItems);
        // to sort the items based on date
        SortedList<TodoItem> sortedList = new SortedList<>(filteredList,
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2) {
                       return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });
        todoListView.setItems(sortedList);
        // use below instead of commented line for observable ArrayList
//        todoListView.setItems(TodoData.getInstance().getTodoItems());
//        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>(){
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty){
                            setText(null);
                        }
                        else {
                            setText(item.getTitle());
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))){
                                setStyle("-fx-text-fill: red");
                            }
                            else if (item.getDeadline().equals(LocalDate.now().plusDays(1))){
                                setStyle("-fx-text-fill: blue");
                            }
                            else{
                                setStyle("-fx-text-fill: black");
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(
                        (obs, wasEmpty,isNowEmpty)->{
                            if (isNowEmpty){
                                cell.setContextMenu(null);
                            }
                            else{
                                cell.setContextMenu(listContextMenu);
                            }
                });
                return cell;
            }
        });
    }

    @FXML
    public void showAddItemDialogPane() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get()  == ButtonType.OK){
            DialogController controller = fxmlLoader.getController(); // DialogController is the class we created
            TodoItem item = controller.processResults();
            todoListView.getSelectionModel().select(item);
        }
    }
    @FXML
    public void showEditDialogPane(TodoItem selectedItem){
        Dialog<ButtonType> dialog = new Dialog<>();
        // setting up the owner of the dialogue
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        // load the data of the selected item to the dialogPane so it can be edited
        DialogController controller = fxmlLoader.getController();
        controller.loadTodoItemForEditing(selectedItem);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            controller.processEdit(selectedItem);
            TodoData.getInstance().updateTodoItem(selectedItem);
            todoListView.getSelectionModel().clearSelection();
            todoListView.getSelectionModel().select(selectedItem);
        }
    }
    @FXML
    public void handleDeleteKeyPressed(KeyEvent keyEvent){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            if (keyEvent.getCode().equals(KeyCode.BACK_SPACE) || keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(selectedItem);
            }
        }
    }
    @FXML
    public void deleteItem(TodoItem item){
        //pre-created dialogue in JavaFX
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Item");
        alert.setHeaderText("Delete " + item.getTitle());
        alert.setContentText("Come on man. You know what to do");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() &&  result.get()  == ButtonType.OK){
            System.out.println("Ok button is pressed");
            TodoData.getInstance().deleteItem(item);
        }
    }
    @FXML
    public void handleOnMouseExited(MouseEvent mouseEvent){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        String newDescription = descriptionArea.getText();
        TodoData.getInstance().updateDescription(selectedItem, newDescription);
    }
    @FXML
    public void handleOnToggleButtonClicked(){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (filterToggleButton.isSelected()){
            filteredList.setPredicate(wantTodaysItems);
            if (filteredList.isEmpty()){
                descriptionArea.clear();
                deadlineLabel.setText("");
            }
            else if(filteredList.contains(selectedItem)){
                todoListView.getSelectionModel().select(selectedItem);
            }
            else{
                todoListView.getSelectionModel().selectFirst();
            }
        }
        else{
            filteredList.setPredicate(wantAllItems);
            if (selectedItem == null){
                todoListView.getSelectionModel().selectFirst();
            }
            else{
                todoListView.getSelectionModel().select(selectedItem);
            }
        }
    }
//        if (filterToggleButton.isSelected()){
//            filteredList.setPredicate(new Predicate<TodoItem>() {
//                @Override
//                public boolean test(TodoItem item) {
//                    return (item.getDeadline().equals(LocalDate.now()));
//                }
//            });
//        } else{
//            filteredList.setPredicate(new Predicate<TodoItem>() {
//                @Override
//                public boolean test(TodoItem item) {
//                    return true;
//                }
//            });
//        }
//    }
}
