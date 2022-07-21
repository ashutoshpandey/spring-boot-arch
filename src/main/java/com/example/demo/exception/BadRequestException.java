package com.example.demo.exception;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class BadRequestException extends RuntimeException{
    private String detail;
    private String message;
}

