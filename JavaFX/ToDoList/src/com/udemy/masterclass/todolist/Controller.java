package com.udemy.masterclass.todolist;

import com.udemy.masterclass.todolist.datamodel.TodoData;
import com.udemy.masterclass.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Label deadlineLabel;


    public void initialize(){
//        TodoItem item1 = new TodoItem("7 habits", "Rereading the book, taking notes about my centers",
//                 LocalDate.of(2020, 7, 9));
//        TodoItem item2 = new TodoItem("Rich dad poor dad", "Reading the book and the summary with questions",
//                LocalDate.of(2020, 7, 9));
//        TodoItem item3 = new TodoItem("Coding", "Start working on to do list app",
//                LocalDate.of(2020, 7, 9));
//        TodoItem item4 = new TodoItem("Dinner", "Cook jigar with Hamid and Charlie in the evening",
//                LocalDate.of(2020, 7, 9));
//        TodoItem item5 = new TodoItem("Ilmomuz", "Start creating the schedule for Ilmomuz",
//                LocalDate.of(2020, 7, 10));
//        todoItems = new ArrayList<>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//        TodoData.getInstance().setTodoItems(todoItems);
        // adding a change listener -> listens everytime a change is made
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    descriptionArea.setText(item.getDescription());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("eeee, MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });
        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
//        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // selects the first item automatically
        todoListView.getSelectionModel().selectFirst();
    }

    public void handleOnClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder(item.getDescription());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        descriptionArea.setText(sb.toString());
    }
}
