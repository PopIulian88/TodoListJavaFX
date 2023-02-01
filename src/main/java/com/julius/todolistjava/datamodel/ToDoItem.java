package com.julius.todolistjava.datamodel;

import java.time.LocalDate;

public class ToDoItem {
    private String shortDescription;
    private String description;
    private LocalDate deadline;

    public ToDoItem(String shortDescription, String description, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.description = description;
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
