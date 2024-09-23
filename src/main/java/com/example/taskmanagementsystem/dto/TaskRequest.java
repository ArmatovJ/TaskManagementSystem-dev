package com.example.taskmanagementsystem.dto;

import com.example.taskmanagementsystem.enums.Priority;
import com.example.taskmanagementsystem.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data

public class TaskRequest {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Priority priority;
    private Status status;
}
