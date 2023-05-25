package com.example.onlineLearning.registration.controller;

import com.example.onlineLearning.appUser.model.AppUser;
import com.example.onlineLearning.appUser.model.ChangePassword;
import com.example.onlineLearning.registration.model.RegistrationRequest;
import com.example.onlineLearning.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    //Create a Register
    @PostMapping(path = "/user")
    public String register(@RequestBody RegistrationRequest registrationRequest){
        return registrationService.register(registrationRequest);
    }

    //User confirmed
    @GetMapping(path = "/confirm")
    public String confirm (@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

    //Reatrive all registers
    @GetMapping(path = "/user/all")
    private ResponseEntity<List<AppUser>> getAllRegistersController(){
        return  ResponseEntity.ok(registrationService.getAllRegisters());
    }

    //Retrieve only register
    @GetMapping(path = "/user/{id}")
    private AppUser getOnlyRegisterController(@PathVariable("id") Long id){
        return registrationService.getOnlyRegister(id);
    }

    //Edit profile
    @PutMapping(path = "/user/{id}")
    public AppUser updateAppUserController(@PathVariable("id") Long id,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String lastName,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) Long passwordCode){
        return registrationService.updateAppUser(id, name,lastName,email,passwordCode);
    }
    @PutMapping(path = "/user/changepassword/{id}")
    public AppUser updatePasswordController(@PathVariable("id") Long id,
                                            @RequestBody ChangePassword changePassword
                                            ){
        return registrationService.updatePassword(id, changePassword.getPassword(),changePassword.getNewPassword());
    }

    @PutMapping(path = "/user/forgotpassword/{id}")
    public AppUser forgotPasswordController(@PathVariable("id") Long id,
                                            @RequestParam(required = false) Long passwordCode,
                                            @RequestParam(required = false) String newPassword){
        return registrationService.forgotPassword(id, passwordCode, newPassword);
    }



}
