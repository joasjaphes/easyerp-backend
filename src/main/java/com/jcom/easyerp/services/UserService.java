package com.jcom.easyerp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jcom.easyerp.entities.User;
import com.jcom.easyerp.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private  UserRepository userRepository;

    // Add methods to interact with the UserRepository here.
    // For example, you can add methods to find users by username, email, etc.
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
