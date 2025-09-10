package com.jcom.easyerp.controllers;

import com.jcom.easyerp.dtos.UserDto;
import com.jcom.easyerp.entities.User;
import com.jcom.easyerp.mappers.UserMapper;
import com.jcom.easyerp.services.UserService;
import com.jcom.easyerp.shared.HttpException;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("")
    public List<UserDto> getAllUsers() {
        List<User> users =  this.userService.getAllUsers();
        return users.stream().map(userMapper::toDto).toList();
    }
    @PostMapping("")
    public UserDto createUser(@RequestBody UserDto user) {
        User payload = userMapper.toEntity(user);
        User createdUser = this.userService.createUser(payload);
        return userMapper.toDto(createdUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") String id) {
        User user =  this.userService.getUserByUid(id);
        if(user == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
