package com.jcom.easyerp.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jcom.easyerp.dtos.UserDto;
import com.jcom.easyerp.entities.User;
import com.jcom.easyerp.mappers.UserMapper;
import com.jcom.easyerp.repositories.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private  UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Integer id) {
        User user =  this.userRepository.findById(id).orElse(null);
        return user;
      
    }
    public User createUser(User user) {
        BCrypt.Hasher hasher = BCrypt.withDefaults();
        String hashedPassword = hasher.hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashedPassword);
        return this.userRepository.save(user);
    }
    public User updateUser(Integer id, User user) {
        if (this.userRepository.existsById(id)) {
            return this.userRepository.save(user);
        }
        return null;
    }
}
