package com.example.onlineLearning.payment.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class PaymentHealth {
    @GetMapping(path = "health/payment")
    public String healthCheck(){
        return "UP";
    }


}
