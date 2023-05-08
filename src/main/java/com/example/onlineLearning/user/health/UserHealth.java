package com.example.onlineLearning.user.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class UserHealth {
    @GetMapping(path = "health/user")
    public String healthCheck(){
        return "UP";
    }
}
