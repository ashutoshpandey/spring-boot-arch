package com.example.demo.controllers;

import com.example.demo.response.ApiResponse;
import org.slf4j.Logger;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import com.example.demo.dto.UserRequestDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/")
    public ApiResponse create(@RequestBody @Valid UserRequestDTO dto){
        logger.info("Creating user");
        UserResponseDTO responseDto = userService.create(dto);
        return new ApiResponse(responseDto, "User created", true);
    }

    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Integer id, @RequestBody @Valid UserRequestDTO dto){
        logger.info("Updating user: " + id);
        UserResponseDTO responseDto = userService.update(id, dto);
        return new ApiResponse(responseDto, "User updated", true);
    }

    @GetMapping("/{id}")
    public ApiResponse find(@PathVariable Integer id){
        logger.info("Finding user: " + id);
        UserResponseDTO responseDto = userService.find(id);
        return new ApiResponse(responseDto, "User found", true);
    }

    @DeleteMapping("/{id}")
    public ApiResponse remove(@PathVariable Integer id){
        logger.info("Removing user: " + id);
        UserResponseDTO responseDto = userService.remove(id);
        return new ApiResponse(responseDto, "User removed", true);
    }
}
