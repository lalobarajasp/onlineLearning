package com.example.onlineLearning.user.controller;

import com.example.onlineLearning.user.model.User;
import com.example.onlineLearning.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    private ResponseEntity<User> guardar(User user){
        User temporal = userService.create(user);
        try{
            return ResponseEntity.created(new URI("/api/persona"+temporal.getId())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
