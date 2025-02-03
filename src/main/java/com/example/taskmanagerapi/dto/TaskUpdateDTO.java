package com.example.taskmanagerapi.dto;

import com.example.taskmanagerapi.model.Status;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskUpdateDTO {
    private String title;
    private String description;
    private Status status;

}
