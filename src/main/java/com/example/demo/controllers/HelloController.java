package com.example.demo.controllers;

import javax.validation.Valid;

import com.example.demo.dto.UserCreateDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.utility.Constant;
import com.example.demo.service.UserService;
import com.example.demo.exception.BadRequestException;

@RestController
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String getHello(@RequestParam(required = false) String name){
        if(name != null)
            return "Hello: " + name;
        else
            throw new BadRequestException(Constant.EXCEPTION_MESSAGE_MISSING_ATTRIBUTE, "You need to provide name in path");
    }

    @PostMapping("/create")
    public UserCreateDTO create(@RequestBody @Valid User user){
        return userService.create(user);
    }
}
