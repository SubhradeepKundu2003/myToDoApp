package com.subhra.ToDo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateTodoDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Boolean completed;
}

