package com.udemy.masterclass.todolist.datamodel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static TodoData getInstance() {
        return instance;
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }

    public void deleteItem(TodoItem item){
        todoItems.remove(item);
    }
    /*
        This method is for updating the description of a todo list item
     */
    public void updateDescription(TodoItem item, String newDescription){
            // find the position of the item which description needs to be changed.
           int position = todoItems.indexOf(item);
           // then change that items description
            todoItems.get(position).setDescription(newDescription);
    }

    public void updateTodoItem(TodoItem item) {
        todoItems.set(todoItems.indexOf(item),item);
    }

//    public void setTodoItems(ObservableList<TodoItem> todoItems) {
//        this.todoItems = todoItems;
//    }

    public void loadTodoItems() throws IOException{
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try{
            while ((input = br.readLine()) != null){
                String [] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String description = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem item = new TodoItem(shortDescription, description, date);
                todoItems.add(item);
            }
        }finally {
            if (br != null ){
                br.close();
            }
        }
    }
    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<TodoItem> iterator = todoItems.iterator();
            while (iterator.hasNext()){
                TodoItem item = iterator.next();
                bw.write(String.format("%s\t%s\t%s\t",
                        item.getTitle(),
                        item.getDescription(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }
        } finally {
            if (bw != null){
                bw.close();
            }
        }
    }
}
