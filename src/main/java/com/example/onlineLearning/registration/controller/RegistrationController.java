package com.example.onlineLearning.registration.controller;

import com.example.onlineLearning.registration.model.RegistrationRequest;
import com.example.onlineLearning.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping(path = "/user")
    public String register(@RequestBody RegistrationRequest registrationRequest){
        return registrationService.register(registrationRequest);
    }
    @GetMapping(path = "/confirm")
    public String confirm (@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

}
