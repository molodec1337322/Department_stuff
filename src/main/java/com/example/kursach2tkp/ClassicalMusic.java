package com.example.kursach2tkp;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    public void myInit(){
        System.out.println("initialized");
    }

    public void myDestroy(){
        System.out.println("destroyed");
    }

    @Override
    public String getSong() {
        return "Rapsody";
    }
}
