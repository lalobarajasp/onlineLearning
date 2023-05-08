package com.example.onlineLearning.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserBuilder implements com.example.onlineLearning.user.contract.UserBuilder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //required
    private String name; //required
    private String lastName; //required
    private String email; //required
    private String password; //required
    private Long phone; //required
    private String address; //optional
    private Long passwordCode; //optional

    @Override
    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }
    @Override
    public UserBuilder phone(Long phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public UserBuilder passwordCode(Long passwordCode) {
        this.passwordCode = passwordCode;
        return this;
    }

    public User build(){

        return new User(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public Long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Long getPasswordCode() {
        return passwordCode;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPasswordCode(Long passwordCode) {
        this.passwordCode = passwordCode;
    }
}
