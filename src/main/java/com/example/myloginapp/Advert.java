package com.example.myloginapp;

public class Advert {


    private String subject;
    private String username;
    private Integer price;
    private String id;
    private Boolean online;
    private Boolean inPerson;
    private String phoneNumber;
    private String name;
    private String mail;
    private Integer likes;

    public Advert(){

    }

    public Advert(String subject, String username, Integer price, Boolean online, Boolean inPerson, String phoneNumber, String name, String mail) {
        this.subject = subject;
        this.username = username;
        this.price = price;
        this.online = online;
        this.inPerson = inPerson;
        this.id="";
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.mail = mail;
        this.likes = 0;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getInPerson() {
        return inPerson;
    }

    public void setInPerson(Boolean inPerson) {
        this.inPerson = inPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}