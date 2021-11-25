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

    @GetMapping("/workers")
    public String GetWorker(@RequestParam(value = "first_name", required = false) String first_name,
                           @RequestParam(value = "second_name", required = false) String second_name,
                           @RequestParam(value = "patronym", required = false) String patronym,
                           @RequestParam(value = "birthday", required = false) String birthday,
                           @RequestParam(value = "post", required = false) String post,
                           @RequestParam(value = "started_working", required = false) String started_working,
                           Model model){

        return "home/Workers";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){
        return "home/GoodbyeWorld";
    }
}
