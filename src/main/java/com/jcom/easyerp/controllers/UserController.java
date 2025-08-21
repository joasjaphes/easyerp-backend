package com.jcom.easyerp.controllers;

import com.jcom.easyerp.entities.User;
import com.jcom.easyerp.services.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
