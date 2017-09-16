package com.twu.biblioteca.model.entity;

public class User {

    private String name;
    private String email;
    private String phoneNum;
    private String libraryNum;
    private String password;

    public User() {
    }

    public User(String name, String email, String phoneNum, String libraryNum, String password) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.libraryNum = libraryNum;
        this.password = password;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(String libraryNum) {
        this.libraryNum = libraryNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
