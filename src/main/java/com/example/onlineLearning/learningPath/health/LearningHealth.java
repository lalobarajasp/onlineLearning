package com.example.onlineLearning.learningPath.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = "/")
public class LearningHealth {

    @GetMapping(path = "health/learning")
    public String healthCheck(){
        return "UP";
    }

}
