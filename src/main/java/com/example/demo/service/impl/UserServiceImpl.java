package com.example.demo.service.impl;

import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.dto.UserCreateDTO;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    public UserCreateDTO create(User user){
        user.setUserUUID(UUID.randomUUID().toString());

        UserCreateDTO dto = new UserCreateDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
