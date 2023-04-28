package com.example.onlineLearning.user.model;

import com.example.onlineLearning.user.contract.Builder;

public class UserBuilder implements Builder, com.example.onlineLearning.user.contract.User {
    private String name;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private int zipCode;
    private int phone;
    private String email;


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public User build(){
        return new User(name,lastName,address,city,country,zipCode,phone,email);
    }

    @Override
    public void signUp() {

    }

    @Override
    public void logIn() {

    }

    @Override
    public void editProfile() {

    }

    @Override
    public void forgotPassword() {

    }


}
