package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO find(Integer id);

    UserResponseDTO remove(Integer id);

    UserResponseDTO create(UserRequestDTO dto);

    UserResponseDTO update(Integer id, UserRequestDTO dto);
}