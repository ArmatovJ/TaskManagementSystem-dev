package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.dto.TaskRequest;
import com.example.taskmanagementsystem.entity.Task;

public interface TaskService {
    boolean createTask(TaskRequest taskRequest);
    TaskRequest editTask(TaskRequest taskRequest);
    boolean deleteTask(Long id);


}
