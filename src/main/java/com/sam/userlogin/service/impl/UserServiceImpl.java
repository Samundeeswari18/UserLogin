package com.sam.userlogin.service.impl;

import com.sam.userlogin.dto.UserDto;
import com.sam.userlogin.entity.Role;
import com.sam.userlogin.entity.User;
import com.sam.userlogin.repository.RoleRepository;
import com.sam.userlogin.repository.UserRepository;
import com.sam.userlogin.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
      private UserRepository userRepository;
      private RoleRepository roleRepository;
      private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));


        //Determine the role based on registration criteria
        String roleName;
        if(userDto.isAdminRegistration()){
            roleName = "ROLE_ADMIN";
        }else{
            roleName= "ROLE_USER";
        }

        //Check if role already exists in database, otherwise create it
        Role role = roleRepository.findByName(roleName);
        if(role == null){
            role = new Role();
            role.setName((roleName));
            roleRepository.save(role);
        }

        //Assign the role to the user
        user.setRoles((Collections.singletonList(role)));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());

    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
