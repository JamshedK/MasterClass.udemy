package com.udemy.masterclass.todolist;

import com.udemy.masterclass.todolist.datamodel.TodoData;
import com.udemy.masterclass.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker deadline;

    public TodoItem processResults(){
        String title = this.title.getText().trim();
        String description = this.description.getText().trim();
        LocalDate deadlineDate = deadline.getValue();
        TodoItem newItem = new TodoItem(title, description, deadlineDate);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
    public void loadTodoItemForEditing(TodoItem item){
            title.setText(item.getTitle());
            description.setText(item.getDescription());
            deadline.setValue(item.getDeadline());
    }

    public void processEdit(TodoItem originalTodoItem){
        originalTodoItem.setTitle(this.title.getText().trim());
        originalTodoItem.setDescription(this.description.getText().trim());
        originalTodoItem.setDeadline(this.deadline.getValue());
    }


}
