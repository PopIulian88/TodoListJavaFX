package com.julius.todolistjava.datamodel;

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

public class ToDoData {
    private static ToDoData instance = new ToDoData();
    private static String fileName = "ToDoListItem.txt";

    private ObservableList<ToDoItem> toDoItems;
    private DateTimeFormatter formatter;

    private ToDoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static ToDoData getInstance() {
        return instance;
    }

    public ObservableList<ToDoItem> getToDoItems() {
        return toDoItems;
    }
    public void addTodoItem(ToDoItem item){
        toDoItems.add(item);
    }

    public void loadTodoItems() throws IOException {
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path);

        String input;
        try {
            while((input = br.readLine()) != null){
                String[] itemPices = input.split("\t");

                String shortDescription = itemPices[0];
                String description = itemPices[1];
                String dateString = itemPices[2];
                LocalDate date = LocalDate.parse(dateString, formatter);

                ToDoItem toDoItem = new ToDoItem(shortDescription, description, date);

                toDoItems.add(toDoItem);
            }

        }finally {
            if(br != null){
                br.close();
            }
        }
    }

    public void saveToDoItem() throws IOException{
        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<ToDoItem> iterator = toDoItems.iterator();

            while (iterator.hasNext()){
                ToDoItem item = iterator.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDescription(),
                        item.getDeadline().format(formatter)
                ));
                bw.newLine();
            }
        }finally {
            if(bw != null){
                bw.close();
            }
        }
    }

    public void deleteTodoItem(ToDoItem item){
        toDoItems.remove(item);
    }
}
