package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.entity.User;

public interface UserService {
    User create (User user);
    User getCurrentUser();
    User getAdmin();
    User getByUsername(String username);
}
