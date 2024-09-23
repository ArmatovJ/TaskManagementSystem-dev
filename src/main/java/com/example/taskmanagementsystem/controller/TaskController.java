package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.dto.JwtAuthenticationResponse;
import com.example.taskmanagementsystem.dto.SignInRequest;
import com.example.taskmanagementsystem.dto.SignUpRequest;
import com.example.taskmanagementsystem.dto.TaskRequest;
import com.example.taskmanagementsystem.exceptions.EntityNotFoundException;
import com.example.taskmanagementsystem.service.impl.AuthenticationServiceImpl;
import com.example.taskmanagementsystem.service.impl.TaskServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task")
@Slf4j
public class TaskController {
    private final TaskServiceImpl service;

    @PostMapping(value = "/create-task")
    public ResponseEntity<String> createTask(@RequestBody @Valid TaskRequest request) {
        log.info("[#createTask] is calling");
        service.createTask(request);
        return ResponseEntity.ok("Task created");
    }

    @PostMapping(value = "/edit-task")
    public ResponseEntity<TaskRequest> editTask(@RequestParam Long id, @RequestBody TaskRequest taskRequest) {
        taskRequest.setId(id);
        TaskRequest updatedTask = service.editTask(taskRequest);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            service.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
