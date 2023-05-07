package com.example.onlineLearning.user.model;

public class User {
    private Long id; //required
    private String name; //required
    private String lastName; //required
    private String email; //required
    private String password; //required
    private Long phone; //required
    private String address; //optional
    private Long passwordCode; //optional

    public User(UserBuilder userBuilder){
       this.id = userBuilder.getId();
        this.name = userBuilder.getName();
        this.lastName = userBuilder.getLastName();
        this.email = userBuilder.getEmail();
        this.password = userBuilder.getPassword();
        this.phone = userBuilder.getPhone();
        this.address = userBuilder.getAddress();
        this.passwordCode = userBuilder.getPasswordCode();
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
        return email;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", passwordCode=" + passwordCode +
                '}';
    }
}
