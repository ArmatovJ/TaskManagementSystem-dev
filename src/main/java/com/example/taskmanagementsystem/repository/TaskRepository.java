package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional <Task> findByName(String name);
}