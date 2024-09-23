package com.example.taskmanagementsystem.service.impl;

import com.example.taskmanagementsystem.dto.TaskRequest;
import com.example.taskmanagementsystem.entity.Task;
import com.example.taskmanagementsystem.exceptions.EntityNotFoundException;
import com.example.taskmanagementsystem.mappers.TaskMapper;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    public boolean createTask(TaskRequest taskRequest) {
        Task task = TaskMapper.toTask(taskRequest);
        repository.save(task);
        return true;
    }

    @Override
    public TaskRequest editTask(TaskRequest taskRequest) {
        Task existingTask = repository.findById(taskRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task with id " + taskRequest.getId() + " not found"));

        TaskMapper.updateTaskFromRequest(taskRequest, existingTask);

        repository.save(existingTask);

        return TaskMapper.toTaskRequest(existingTask);
    }

    @Override
    public boolean deleteTask(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Task with id " + id + " not found");
        }

    }
}
