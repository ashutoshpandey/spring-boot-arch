package com.example.demo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.utility.Constant;
import com.example.demo.dto.UserCreateDTO;
import com.example.demo.service.UserService;
import com.example.demo.exception.BadRequestException;

import java.util.Locale;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public String getHello(@RequestParam(required = false) String name){
        if(name != null)
            return "Hello: " + name;
        else {
            logger.error("Name not provided for saying hello");
            throw new BadRequestException(Constant.EXCEPTION_MESSAGE_MISSING_ATTRIBUTE, "You need to provide name in path");
        }
    }

    @GetMapping("/hello-language")
    public String getHelloLanguage(
        @RequestParam(required = false) String name,
        @RequestHeader(name="Accept-Language", required = false) Locale locale
    ){
        if(name != null) {
            // picks from messages.properties, pass Accept-Language = en/fr in header
            return messageSource.getMessage("hello.message", null, "Hello", locale) + " " + name;
        }else {
            logger.error("Name not provided for saying hello");
            throw new BadRequestException(Constant.EXCEPTION_MESSAGE_MISSING_ATTRIBUTE, "You need to provide name in path");
        }
    }

    @GetMapping("/hello-language-updated")
    public String getHelloLanguageUpdated(
            @RequestParam(required = false) String name
    ){
        if(name != null) {
            // picks from messages.properties, pass Accept-Language = en/fr in header
            // No need to specify locale from header
            return messageSource.getMessage("hello.message", null, "Hello", LocaleContextHolder.getLocale()) + " " + name;
        }else {
            logger.error("Name not provided for saying hello");
            throw new BadRequestException(Constant.EXCEPTION_MESSAGE_MISSING_ATTRIBUTE, "You need to provide name in path");
        }
    }

    @PostMapping("/create")
    public UserCreateDTO create(@RequestBody @Valid User user){
        logger.info("Creating user");
        return userService.create(user);
    }
}
