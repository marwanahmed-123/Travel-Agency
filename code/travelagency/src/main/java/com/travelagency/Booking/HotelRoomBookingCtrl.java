package com.travelagency.Booking;

import java.util.ArrayList;
import com.travelagency.model.AbstractHotelRoomBooking;
import com.travelagency.model.HotelRoom;
import com.travelagency.model.HotelRoomBooking;
import com.travelagency.model.Model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.travelagency.NotificationModule.*;
import com.travelagency.model.User;

public class HotelRoomBookingCtrl {

    private Model model;
    private NotificationManager notificationManager;
    private IHotelFeesCalculator feesCalculator;
    private IrecommendEvents recommender;

    public HotelRoomBookingCtrl(Model model, NotificationManager notificationManager) {
        this.model = model;
        feesCalculator = new HotelFeesCalculator();
        recommender = new RecommendEventsSameCity();
        this.notificationManager = notificationManager;
    }

    public boolean checkAvailability(HotelRoom hotelRoom) {
        return hotelRoom.getAvailable();
    }

    public AbstractHotelRoomBooking createBooking(HotelRoom hotelRoom, LocalDate checkInDate, LocalDate checkOutDate,
            String userID) {
        if (checkAvailability(hotelRoom)) {
            User user = model.getUserWithID(userID);
            if (user == null || !user.getIsLoggedIn()) {
                return null;
            }
            int diffInDays = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
            double fees = feesCalculator.calculateFees(hotelRoom.getPrice(), diffInDays);
            hotelRoom.setAvailable(false);
            System.out.println(diffInDays);
            TemplateText template = new HotelBookingTemplate();
            ArrayList<String> placeholders = new ArrayList<>();
            placeholders.add(user.getUsername());
            placeholders.add(hotelRoom.getName());
            notificationManager = new EmailNotificationManager(model);
            notificationManager.requestNotification(user, template, placeholders);
            notificationManager = new DashboardNotificationManager(model);
            notificationManager.requestNotification(user, template, placeholders);
            template = new RecommendEventTemplate();
            placeholders = new ArrayList<>();
            notificationManager.requestNotification(user, template, placeholders);
            user.setRecommendedEvents(recommender.recommendEvents(hotelRoom.getCity(), model));
            AbstractHotelRoomBooking temp = new HotelRoomBooking(checkInDate, checkOutDate, userID,
                    hotelRoom.getHotelRoomID(), hotelRoom.getHotel(), fees);
            model.addHotelRoomBooking(temp);
            return temp;
        }
        return null;
    }

    public boolean cancelBooking(String bookingID) {
        AbstractHotelRoomBooking booking = model.getHotelRoomBookingWithId(bookingID);
        if (booking == null) {
            return true;
        }
        User user = model.getUserWithID(booking.getUserID());
        if (user == null || !user.getIsLoggedIn()) {
            return false;
        }
        return model.removeHotelRoomBooking(booking);
    }

    public void setFeesCalculator(IHotelFeesCalculator feesCalculator) {
        this.feesCalculator = feesCalculator;
    }

    public IHotelFeesCalculator getFeesCalculator() {
        return feesCalculator;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    public NotificationManager getNotificationManager() {
        return notificationManager;
    }
}
