package com.sam.userlogin.service;

import com.sam.userlogin.dto.UserDto;
import com.sam.userlogin.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    void saveUser(UserDto userDto);
    User findByEmail(String email);
    List<UserDto>findAllUsers();
}
