package com.example.demo.dto;

import lombok.Data;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class UserRequestDTO {
    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("user_uuid")
    private String userUUID;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;
}