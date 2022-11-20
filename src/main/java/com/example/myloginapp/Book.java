package com.example.myloginapp;

public class Book {
    private String name;
    private String sellerName;
    private String sellerNumber;
    private String state;
    private String subject;
    private Integer price;



    public Book(String name, String sellerName, String sellerNumber, String state, String subject, Integer price) {
        this.name = name;
        this.sellerName=sellerName;
        this.sellerNumber=sellerNumber;
        this.state = state;
        this.subject = subject;
        this.price = price;
    }

    public Book() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerNumber() {
        return sellerNumber;
    }

    public void setSellerNumber(String sellerNumber) {
        this.sellerNumber = sellerNumber;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
