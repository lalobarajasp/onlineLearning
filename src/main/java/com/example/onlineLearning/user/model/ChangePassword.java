package com.example.onlineLearning.user.model;

public class ChangePassword extends UserBuilder {
    private String pasword;
    private String newPassword;

    public ChangePassword(String pasword, String newPassword) {
        super();
        this.pasword = pasword;
        this.newPassword = newPassword;
    }

    public ChangePassword() {
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ChangePassword{" +
                "pasword='" + pasword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
