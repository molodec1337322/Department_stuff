package com.example.kursach2tkp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           Model model){
        model.addAttribute("message", "Hello, " + name);

        return "home/HelloWorld";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){
        return "home/GoodbyeWorld";
    }
}
