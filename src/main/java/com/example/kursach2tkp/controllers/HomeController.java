package com.example.kursach2tkp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String sayHello(){
        return "home/HelloWorld";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){
        return "home/GoodbyeWorld";
    }
}
