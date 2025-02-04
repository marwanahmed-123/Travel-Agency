package com.travelagency.model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class AbstractHotelRoomBooking {

    protected String bookingID;
    protected LocalDate checkInDate;
    protected LocalDate checkOutDate;
    protected String userID;
    protected String hotelRoomID;
    protected String hotel;
    protected double fees;

    public AbstractHotelRoomBooking(LocalDate checkInDate, LocalDate checkOutDate, String userID,
            String hotelRoomID, String hotel, double fees) {
        String uuid = UUID.randomUUID().toString();
        this.bookingID = uuid.substring(0, 10);
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.userID = userID;
        this.hotelRoomID = hotelRoomID;
        this.hotel = hotel;
        this.fees = fees;
    }

    public String getBookingID() {
        return bookingID;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getHotel() {
        return hotel;
    }

    public String getHotelRoomID() {
        return hotelRoomID;
    }

    public String getUserID() {
        return userID;
    }

    public double getFees() {
        return fees;
    }
}
