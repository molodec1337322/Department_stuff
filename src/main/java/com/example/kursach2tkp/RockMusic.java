package com.example.kursach2tkp;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music{

    @Override
    public String getSong() {
        return "Highway to hell";
    }
}
