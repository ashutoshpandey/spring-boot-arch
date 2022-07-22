package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.dto.UserCreateDTO;

public interface UserService {
    UserCreateDTO create(User user);
}
