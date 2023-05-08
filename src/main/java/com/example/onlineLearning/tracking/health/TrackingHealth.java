package com.example.onlineLearning.tracking.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class TrackingHealth {
    @GetMapping(path = "health/tracking")
    public String healthCheck(){
        return "UP";
    }
}
