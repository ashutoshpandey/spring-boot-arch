package com.example.demo.controllers;

import com.example.demo.exception.BadRequestException;
import com.example.demo.utility.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello(@RequestParam(required = false) String name){
        if(name != null)
            return "Hello: " + name;
        else
            throw new BadRequestException(Constant.EXCEPTION_MESSAGE_MISSING_ATTRIBUTE, "You need to provide name in path");
    }
}
