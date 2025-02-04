package com.travelagency.model;

public class StandardUser extends User {
    public StandardUser(String username, String password, String Mail, String phoneNumber,
            boolean isLoggedIn) {
        super(username, password, Mail, phoneNumber, isLoggedIn);
    }
}
