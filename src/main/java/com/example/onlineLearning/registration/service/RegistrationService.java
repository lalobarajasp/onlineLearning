package com.example.onlineLearning.registration.service;

import com.example.onlineLearning.appUser.model.AppUser;
import com.example.onlineLearning.appUser.model.AppUserRole;
import com.example.onlineLearning.appUser.model.ChangePassword;
import com.example.onlineLearning.appUser.repository.AppUserRepository;
import com.example.onlineLearning.appUser.service.AppUserService;
import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.registration.model.RegistrationRequest;
import com.example.onlineLearning.registration.token.ConfirmationToken;
import com.example.onlineLearning.registration.token.ConfirmationTokenService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private EmailValidator emailValidator;
    private ConfirmationTokenService confirmationTokenService;
    private AppUserRepository appUserRepository;



    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.singUpUser(new AppUser(
                registrationRequest.getName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                registrationRequest.getPasswordCode(),
                AppUserRole.USER
        ));

    }


    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }

    //Retrieve All Registers
    public List<AppUser> getAllRegisters() {
        return appUserRepository.findAll();

    }

    //Retrieve Only a Register
    public AppUser getOnlyRegister(Long id) {
        return appUserRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("The register with id: " + id + " doesn't exist.")
        );
    }

    //Edit Profile
    public AppUser updateAppUser(Long id, String name, String lastName, String email, Long passwordCode){
        AppUser register = null;
        if(appUserRepository.existsById(id)){
            register = appUserRepository.findById(id).get();
            if (name != null) register.setName(name);
            if (lastName != null) register.setLastName(lastName);
            if (email != null) register.setEmail(email);
            if (passwordCode != null) register.setPasswordCode(passwordCode);
            appUserRepository.save(register);

        }else {
            System.out.println("Update | The register with the id: " + id + " doesn't exist.");
        }
        return register;
    }

    //ChangePassword when you remember it
    public AppUser updatePassword(Long id, String password, String newPassword) {
        AppUser register = null;
        if (appUserRepository.existsById(id)) {
            register = appUserRepository.findById(id).get();
            if ((password != null) && (newPassword != null)) {
                if (password.equals(register.getPassword())) {
                    register.setPassword(newPassword);
                    appUserRepository.save(register);
                }
            }
            appUserRepository.save(register);

        } else {
            System.out.println("Update | The user with the id: " + id + " doesn't exist.");
        }
        return register;
    }

    public AppUser forgotPassword(Long id, Long passwordCode, String newPassword){
        AppUser register = null;
        if(appUserRepository.existsById(id)){
            register = appUserRepository.findById(id).get();
            if (passwordCode != null) {
                if (passwordCode.equals(register.getPasswordCode())) {
                    register.setPassword(newPassword);
                    appUserRepository.save(register);
                }
            }
            appUserRepository.save(register);

        }else {
            System.out.println("Update | The register with the id: " + id + " doesn't exist.");
        }
        return register;
    }










}
