package com.jcom.easyerp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/users")
    public String index() {
        return "index.html"; 
    }
}
