package com.example.onlineLearning.user.contract;

public interface UserBuilder {
    UserBuilder id(Long id);

    UserBuilder name(String name);

    UserBuilder lastName(String lastName);

    UserBuilder email(String email);
    UserBuilder phone(int phone);
    UserBuilder address(String address);
    UserBuilder city(String city);
    UserBuilder country(String country);
    UserBuilder zipCode(int zipCode);


    
}
