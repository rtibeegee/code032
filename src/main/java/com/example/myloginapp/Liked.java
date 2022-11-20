package com.example.myloginapp;

public class Liked {

    private String username;
    private Advert a;

    public Liked() {}

    public Liked(String username, Advert a) {
        this.username = username;
        this.a = a;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Advert getA() {
        return a;
    }

    public void setA(Advert a) {
        this.a = a;
    }
}
