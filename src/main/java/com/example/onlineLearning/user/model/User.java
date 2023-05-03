package com.example.onlineLearning.user.model;

public class User {
    private Long id; //required
    private String name; //required
    private String lastName; //required
    private String email; //required
    private int phone; //required
    private String address; //optional
    private String city; //optional
    private String country; //optional
    private int zipCode; //optional

    public User(UserBuilder userBuilder){
        this.id = userBuilder.getId();
        this.name = userBuilder.getName();
        this.lastName = userBuilder.getLastName();
        this.email = userBuilder.getEmail();
        this.phone = userBuilder.getPhone();
        this.address = userBuilder.getAddress();
        this.city = userBuilder.getCity();
        this.country = userBuilder.getCountry();
        this.zipCode = userBuilder.getZipCode();
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
