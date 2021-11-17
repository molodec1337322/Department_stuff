package com.example.kursach2tkp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String sayHello(){
        return "HelloWorld";
    }
}
