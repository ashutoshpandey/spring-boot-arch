package com.example.demo.service.impl;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.utility.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.service.UserService;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO create(UserRequestDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);

        user.setUserUUID(UUID.randomUUID().toString());

        userRepository.save(user);

        UserResponseDTO responseDto = new UserResponseDTO();
        BeanUtils.copyProperties(user, responseDto);
        return responseDto;
    }

    @Override
    public UserResponseDTO update(Integer id, UserRequestDTO dto) {
        Optional<User> userObject = userRepository.findById(id);
        if(userObject.isPresent()){
            User user = userObject.get();

            BeanUtils.copyProperties(dto, user);
            userRepository.save(user);

            UserResponseDTO responseDto = new UserResponseDTO();
            BeanUtils.copyProperties(user, responseDto);
            return responseDto;
        }else {
            throw new RecordNotFoundException(Constant.Message.INVALID_ID, "User not found for Id: " + id);
        }
    }

    @Override
    public UserResponseDTO find(Integer id) {
        Optional<User> userObject = userRepository.findById(id);
        if(userObject.isPresent()){
            UserResponseDTO responseDto = new UserResponseDTO();
            BeanUtils.copyProperties(userObject.get(), responseDto);
            return responseDto;
        }else {
            throw new RecordNotFoundException(Constant.Message.INVALID_ID, "User not found for Id: " + id);
        }
    }

    @Override
    public UserResponseDTO remove(Integer id) {
        Optional<User> userObject = userRepository.findById(id);
        if(userObject.isPresent()){
            userRepository.delete(userObject.get());

            UserResponseDTO responseDto = new UserResponseDTO();
            BeanUtils.copyProperties(userObject.get(), responseDto);
            return responseDto;
        }else {
            throw new RecordNotFoundException(Constant.Message.INVALID_ID, "User not found for Id: " + id);
        }
    }
}
