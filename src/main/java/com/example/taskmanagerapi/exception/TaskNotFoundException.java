package com.example.taskmanagerapi.exception;

public class TaskNotFoundException extends  RuntimeException {

    public TaskNotFoundException(String message) {
        super(message);
    }

}
