package com.julius.todolistjava;

import com.julius.todolistjava.datamodel.ToDoData;
import com.julius.todolistjava.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogControler {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private DatePicker deadlinePiker;

    public ToDoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String description = descriptionArea.getText().trim();
        LocalDate deadlineValue = deadlinePiker.getValue();
        ToDoItem newItem = new ToDoItem(shortDescription, description, deadlineValue);
        ToDoData.getInstance().addTodoItem(newItem);
        return  newItem;
    }
}
