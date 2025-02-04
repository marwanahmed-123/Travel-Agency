package com.travelagency.model;

import java.util.UUID;

public abstract class AbstractLocalEventBooking {
    protected String bookingID;
    protected String userID;
    protected String localEventID;
    protected double fees;

    protected AbstractLocalEventBooking(String userID, String localEventID, double fees) {
        String uuid = UUID.randomUUID().toString();
        this.bookingID = uuid.substring(0, 10);
        this.userID = userID;
        this.localEventID = localEventID;
        this.fees = fees;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public String getLocalEventID() {
        return localEventID;
    }

    public double getFees() {
        return fees;
    }

}
