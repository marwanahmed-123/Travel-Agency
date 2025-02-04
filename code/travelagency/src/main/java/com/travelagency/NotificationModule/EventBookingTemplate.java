package com.travelagency.NotificationModule;

public class EventBookingTemplate extends TemplateText {
    public EventBookingTemplate() {
        super("Dear {x}, a reservation for event {x} has been confirmed\n", "Event Booking");
        super.setPlaceholdersNum(2);
    }
}