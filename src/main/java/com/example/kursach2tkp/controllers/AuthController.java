package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.models.User;
import com.example.kursach2tkp.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

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

    @GetMapping("/login_processing")
    public void auth(@RequestParam(value = "login") String login,
                       @RequestParam(value = "password") String password){
        System.out.println(password);
    }

    @GetMapping("/registration")
    public String registration(){
        return "auth/registration";
    }


    @PostMapping("/registration")
    public String addUser(@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "email") String email,
                          Model model){


        User newUser = new User();
        newUser.setLogin(login.toLowerCase(Locale.ROOT));
        newUser.setPassword(password);
        newUser.setEmail(email.toLowerCase(Locale.ROOT));

        if(!userDetailsService.saveUser(newUser)){
            return "redirect:/auth/registration?collision_error";
        }
        return "redirect:/workers";
    }
}
