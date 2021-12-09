package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.models.User;
import com.example.kursach2tkp.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }

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

    @GetMapping("/registration")
    public String registration(){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password,
                          Model model){


        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(password);

        if(!userDetailsService.saveUser(newUser)){
            return "redirect:/auth/registration?collision_error";
        }
        return "redirect:/workers";
    }
}
