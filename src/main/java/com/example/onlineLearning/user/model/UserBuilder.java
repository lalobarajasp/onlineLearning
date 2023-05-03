package com.example.onlineLearning.user.model;

public class UserBuilder implements com.example.onlineLearning.user.contract.UserBuilder {
    private Long id; //required
    private String name; //required
    private String lastName; //required
    private String email; //required
    private int phone; //required
    private String address; //optional
    private String city; //optional
    private String country; //optional
    private int zipCode; //optional

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
    public UserBuilder phone(int phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public UserBuilder city(String city) {
        this.city = city;
        return this;
    }

    @Override
    public UserBuilder country(String country) {
        this.country = country;
        return this;
    }

    @Override
    public UserBuilder zipCode(int zipCode) {
        this.zipCode = zipCode;
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

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getZipCode() {
        return zipCode;
    }



}
