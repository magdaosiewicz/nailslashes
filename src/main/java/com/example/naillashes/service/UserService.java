package com.example.naillashes.service;

import com.example.naillashes.entity.User;
import com.example.naillashes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId){
        return userRepository.getOne(userId);
    }

}
