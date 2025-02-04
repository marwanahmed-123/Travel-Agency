package com.travelagency.Dashboard;

import com.travelagency.model.*;
import com.travelagency.NotificationModule.*;
import java.util.ArrayList;

public class DashboardAbstract {
  protected Model model;
  protected String userid;
  protected Notifications notificationGetter;
  protected User user;
  protected ArrayList<LocalEvent> recommendedEvents;

  public DashboardAbstract(Model model, String userid) {
    this.model = model;
    this.userid = userid;
    this.notificationGetter = Notifications.getInstance();
    this.user = getUserById(userid);
  }

  private User getUserById(String userid) {
    return model.getUserWithID(userid);
  }

  public ArrayList<Notification> getNotifications() {
    if (user == null || user.getIsLoggedIn() == false) {
      return null;
    }
    return notificationGetter.getUserSuccessfulNotifications(userid);
  }

  public ArrayList<Notification> displayFilteredNotifications(String keyword) {
    if (user == null || user.getIsLoggedIn() == false) {
      return null;
    }
    return notificationGetter.getUserTypeSuccessfulNotifications(keyword, userid);
  }

  public ArrayList<AbstractHotelRoomBooking> displayHotelRoomBooking() {
    if (user == null || user.getIsLoggedIn() == false) {
      return null;
    }
    ArrayList<AbstractHotelRoomBooking> bookings = model.getHotelRoomBookings();
    ArrayList<AbstractHotelRoomBooking> bookingsToBeSent = new ArrayList<>();
    for (int i = 0; i < bookings.size(); i++) {
      String id = bookings.get(i).getUserID();
      AbstractHotelRoomBooking booking = bookings.get(i);
      if (userid.equals(id)) {
        bookingsToBeSent.add(booking);
      }
    }
    return bookingsToBeSent;
  }

  public ArrayList<AbstractLocalEventBooking> displayLocalEventBooking() {
    if (user == null || user.getIsLoggedIn() == false) {
      return null;
    }
    ArrayList<AbstractLocalEventBooking> bookings = model.getLocalEventBookings();
    ArrayList<AbstractLocalEventBooking> bookingsToBeSent = new ArrayList<>();
    for (int i = 0; i < bookings.size(); i++) {
      String id = bookings.get(i).getUserID();
      AbstractLocalEventBooking booking = bookings.get(i);
      if (userid.equals(id)) {
        bookingsToBeSent.add(booking);
      }
    }
    return bookingsToBeSent;
  }

  public ArrayList<LocalEvent> getRecommendedEvents() {
    if (user == null || !user.getIsLoggedIn()) {
      return null;
    }
    return user.getRecommendedEvents();
  }
}