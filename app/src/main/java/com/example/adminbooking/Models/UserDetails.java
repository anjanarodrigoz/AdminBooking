package com.example.adminbooking.Models;

public class UserDetails {

    String userName,name,email,mobileNumber,password;

    public UserDetails() {

    }

    public UserDetails(String userId, String name, String email, String mobileNumber, String password) {
        this.userName = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public UserDetails(String userId, String name, String mobileNumber) {
        this.userName = userId;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
