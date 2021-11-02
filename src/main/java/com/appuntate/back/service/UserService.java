package com.appuntate.back.service;

import com.appuntate.back.model.User;
import com.appuntate.back.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User getUserByCodUser(long codUser) {
        return userRepository.getById(codUser);
    }
}
