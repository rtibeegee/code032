package com.example.myloginapp;

public class User {

    private String name;
    private String username;
    private String password;
    private String mail;
    private String phoneNumber;
    private Double averageGrade;
    private Integer numberOfGrades;



    public User(String name, String username, String password, String mail, String phone_number) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.phoneNumber = phone_number;
        this.averageGrade = 0.0;
        this.numberOfGrades = 0;
    }

    public User() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Integer getNumberOfGrades() {
        return numberOfGrades;
    }

    public void setNumberOfGrades(Integer numberOfGrades) {
        this.numberOfGrades = numberOfGrades;
    }
}