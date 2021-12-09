package com.example.kursach2tkp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginSuccsessfull(){
        return "auth/login";
    }

    @PostMapping("/login?error")
    public String loginError(){
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(){
        return "auth/register";
    }
}
