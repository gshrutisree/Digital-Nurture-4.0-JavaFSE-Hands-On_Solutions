// src/main/java/com/example/ex1/service/UserService.java
package com.example.ex1.service;

import com.example.ex1.model.User;
import com.example.ex1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
