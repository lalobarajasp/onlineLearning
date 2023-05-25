package com.example.onlineLearning.security.config;

import com.example.onlineLearning.appUser.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/registration/**").permitAll();
                    auth.requestMatchers("/registration/user").hasRole("USER");
                    auth.requestMatchers("/registration/admin").hasRole("ADMIN");

                })
                .formLogin()
                .and()
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public AuthenticationManager auth(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        return
                authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider()).build();
    }

    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }




}

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        return     http
//                .csrf().disable()
//                .authorizeHttpRequests((authorize)-> {
//                    try {
//                        authorize
//                                .requestMatchers("/registration/**")
//                                .permitAll()
//                             //   .requestMatchers("/management/api/v1/course/**")
//                              //  .permitAll()
//                               // .requestMatchers("/user/api/v1/**")
//                                //.permitAll()
//                                .anyRequest()
//                                .authenticated().and()
//                                .formLogin();
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//                .build();
//
//    }
