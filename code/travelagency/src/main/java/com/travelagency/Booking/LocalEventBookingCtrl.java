package com.travelagency.Booking;

import java.util.ArrayList;

import com.travelagency.NotificationModule.DashboardNotificationManager;
import com.travelagency.NotificationModule.EmailNotificationManager;
import com.travelagency.NotificationModule.EventBookingTemplate;
import com.travelagency.NotificationModule.NotificationManager;
import com.travelagency.NotificationModule.TemplateText;
import com.travelagency.model.AbstractLocalEventBooking;
import com.travelagency.model.LocalEvent;
import com.travelagency.model.LocalEventBooking;
import com.travelagency.model.Model;
import com.travelagency.model.User;

public class LocalEventBookingCtrl {

    protected Model model;
    private NotificationManager notificationManager;

    public LocalEventBookingCtrl(Model model, NotificationManager notificationManager) {
        this.model = model;
        this.notificationManager = notificationManager;
    }

    public boolean checkAvailability(LocalEvent localEvent) {
        if (localEvent.getNumOfTickets() > 0)
            return true;
        return false;
    }

    public LocalEventBooking createBooking(String userID, LocalEvent localEvent) {
        if (checkAvailability(localEvent)) {
            User user = model.getUserWithID(userID);
            if (user == null || !user.getIsLoggedIn())
                return null;
            Integer numOfTickets = localEvent.getNumOfTickets();
            localEvent.setNumOfTickets(numOfTickets - 1);
            double fees = localEvent.getPrice();
            TemplateText template = new EventBookingTemplate();
            ArrayList<String> placeholders = new ArrayList<>();
            placeholders.add(user.getUsername());
            placeholders.add(localEvent.getName());
            notificationManager = new EmailNotificationManager(model);
            notificationManager.requestNotification(user, template, placeholders);
            notificationManager = new DashboardNotificationManager(model);
            notificationManager.requestNotification(user, template, placeholders);
            LocalEventBooking temp = new LocalEventBooking(userID, localEvent.getLocalEventID(), fees);
            model.addLocalEventBooking(temp);
            return temp;
        }
        return null;
    }

    public boolean removeBooking(String bookingID) {
        AbstractLocalEventBooking booking = model.getLocalEventBookingWithId(bookingID);
        if (booking == null)
            return true;
        User user = model.getUserWithID(booking.getUserID());
        if (user == null || !user.getIsLoggedIn())
            return false;
        return model.removeLocalEventBooking(booking);
    }

}
