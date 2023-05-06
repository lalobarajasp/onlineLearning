package com.example.onlineLearning.user.model;

public class User {
    private Long id; //required
    private String name; //required
    private String lastName; //required
    private String email; //required
    private Long phone; //required
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

    public Long getPhone() {
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

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
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
