package com.sam.userlogin.service;

import com.sam.userlogin.entity.UserUpDownLoad;
import com.sam.userlogin.repository.UserUpDownLoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserUpDownLoadService {


    @Autowired
    private UserUpDownLoadRepository userUpDownLoadRepository;


    public void createUser(UserUpDownLoad userUpDownLoad)
    {
        userUpDownLoadRepository.save(userUpDownLoad);

    }

    public Optional<UserUpDownLoad> getUserUpDownLoadById(long id){
        return userUpDownLoadRepository.findById(id);
    }

    public List<UserUpDownLoad> getAllUserUpDownLoad(){
        return userUpDownLoadRepository.findAll();
    }
}
