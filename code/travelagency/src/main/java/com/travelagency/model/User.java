package com.travelagency.model;

import java.util.ArrayList;
import java.util.UUID;

public abstract class User {
    protected String username;
    protected String password;
    protected String userID;
    protected String Mail;
    protected String phoneNumber;
    protected boolean isLoggedIn;
    protected ArrayList<LocalEvent> recommendedEvents;

    public User(String username, String password, String Mail, String phoneNumber, boolean isLoggedIn) {
        String uuid = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.userID = uuid.substring(0, 10);
        this.Mail = Mail;
        this.phoneNumber = phoneNumber;
        this.isLoggedIn = isLoggedIn;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getMail() {
        return Mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserID() {
        return userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public ArrayList<LocalEvent> getRecommendedEvents() {
        return recommendedEvents;
    }

    public void setRecommendedEvents(ArrayList<LocalEvent> recommendedEvents) {
        this.recommendedEvents = recommendedEvents;
    }
}
