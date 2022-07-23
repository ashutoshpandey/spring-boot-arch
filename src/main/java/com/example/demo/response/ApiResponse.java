package com.example.demo.response;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ApiResponse {
    private Object data;
    private String message;
    private Boolean success;
}
