package com.example.taskmanagementsystem.mappers;

import com.example.taskmanagementsystem.dto.TaskRequest;
import com.example.taskmanagementsystem.entity.Task;

import java.time.LocalDateTime;

public class TaskMapper {
    public static TaskRequest toTaskRequest(Task task) {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTitle(task.getTitle());
        taskRequest.setDescription(task.getDescription());
        taskRequest.setDueTime(task.getDueTime());
        taskRequest.setCreatedAt(task.getCreatedAt());
        taskRequest.setUpdatedAt(task.getUpdatedAt());
        taskRequest.setPriority(task.getPriority());
        taskRequest.setStatus(task.getStatus());
        return taskRequest;
    }

    public static void updateTaskFromRequest(TaskRequest taskRequest, Task existingTask) {
        if (taskRequest.getTitle() != null) {
            existingTask.setTitle(taskRequest.getTitle());
        }
        if (taskRequest.getDescription() != null) {
            existingTask.setDescription(taskRequest.getDescription());
        }
        if (taskRequest.getDueTime() != null) {
            existingTask.setDueTime(taskRequest.getDueTime());
        }
        if (taskRequest.getPriority() != null) {
            existingTask.setPriority(taskRequest.getPriority());
        }
        if (taskRequest.getStatus() != null) {
            existingTask.setStatus(taskRequest.getStatus());
        }
        existingTask.setUpdatedAt(taskRequest.getUpdatedAt() != null ?
                taskRequest.getUpdatedAt() :
                LocalDateTime.now());
    }

    public static Task toTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueTime(taskRequest.getDueTime());
        task.setCreatedAt(taskRequest.getCreatedAt());
        task.setUpdatedAt(taskRequest.getUpdatedAt());
        task.setPriority(taskRequest.getPriority());
        task.setStatus(taskRequest.getStatus());
        return task;
    }
}
