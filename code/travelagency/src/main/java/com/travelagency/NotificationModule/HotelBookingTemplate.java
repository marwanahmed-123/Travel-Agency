package com.travelagency.NotificationModule;

public class HotelBookingTemplate extends TemplateText {
    public HotelBookingTemplate() {
        super("Dear {x}, a reservation for hotel {x} has been confirmed \n", "Hotel Booking");
        super.setPlaceholdersNum(2);
    }
}