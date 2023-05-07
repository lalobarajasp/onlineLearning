package com.example.onlineLearning.user.contract;

public interface UserBuilder {
    UserBuilder id(Long id);

    UserBuilder name(String name);

    UserBuilder lastName(String lastName);

    UserBuilder email(String email);
    UserBuilder password(String password);
    UserBuilder phone(Long phone);
    UserBuilder address(String address);
    UserBuilder passwordCode(Long passwordCode);


    
}
