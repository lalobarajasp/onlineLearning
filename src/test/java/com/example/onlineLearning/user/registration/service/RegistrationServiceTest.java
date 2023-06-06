package com.example.onlineLearning.user.registration.service;

import com.example.onlineLearning.user.appUser.model.AppUser;
import com.example.onlineLearning.user.appUser.model.AppUserRole;
import com.example.onlineLearning.user.appUser.repository.AppUserRepository;
import com.example.onlineLearning.user.registration.model.RegistrationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

class RegistrationServiceTest {
    //Links which are connected
    @Mock
    private AppUserRepository appUserRepository;

    //Service that we are testing
    @InjectMocks
    private RegistrationService registrationService;

    private AppUser appUser;

    @BeforeEach
    void setUp() {
        //Start Mockito
        MockitoAnnotations.initMocks(this);


        appUser = new AppUser("Eduardo", "Barajas", "edubarajas98@gmail.com",
                "pa44word", 12345L,  AppUserRole.USER);
        appUser.setId(1L);

    }

    @Test
    void getAllRegisters() {
        //Start mocking this service
        //when we call appUserRepository the method is gonna return a list
        when(appUserRepository.findAll()).thenReturn(Arrays.asList(appUser));
        assertNotNull(registrationService.getAllRegisters());
    }

    @Test
    void getOnlyRegister() {
        when(appUserRepository.findById(appUser.getId())).thenReturn(Optional.ofNullable(appUser));
        assertNotNull(registrationService.getOnlyRegister(appUser.getId()));
    }

    @Test
    void updateAppUser(){

        when(appUserRepository.findById(appUser.getId())).thenReturn(Optional.ofNullable(appUser));
        String newEmail = "newEmail@example.com";
        registrationService.updateAppUser(appUser.getId(), appUser.getName(), appUser.getLastName(), newEmail,
                 appUser.getPasswordCode());

        assertEquals(registrationService.updateAppUser(appUser.getId(), appUser.getName(), appUser.getLastName(), newEmail,
                appUser.getPasswordCode()), registrationService.updateAppUser(appUser.getId(), appUser.getName(), appUser.getLastName(), appUser.getEmail(),
                appUser.getPasswordCode()));
    }

//    @Test
//    void deleteAppUser(){
//        when(appUserRepository.findById(appUser.getId())).thenReturn(Optional.ofNullable(appUser));
//        registrationService.deleteAppUser(appUser.getId());
//        assertEquals(true,appUser.getDeletedAccount());
//
//    }



}