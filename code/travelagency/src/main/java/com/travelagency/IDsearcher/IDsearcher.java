package com.travelagency.IDsearcher;

import java.util.ArrayList;
import com.travelagency.model.*;

public class IDsearcher {
    private Model model;

    public IDsearcher(Model model) {
        this.model = model;
    }

    public User getUserWithID(String id) {
        return model.getUserWithID(id);
    }

    public HotelRoom getHotelRoomWithID(String id) {
        return model.getHotelRoomWithID(id);
    }

    public LocalEvent getLocalEventWithID(String id) {
        return model.getLocalEventWithID(id);
    }

    public AbstractHotelRoomBooking getHotelRoomBookingWithId(String id) {
        return model.getHotelRoomBookingWithId(id);
    }

    public AbstractLocalEventBooking getLocalEventBookingWithId(String id) {
        return model.getLocalEventBookingWithId(id);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public ArrayList<User> getAllUsers() {
        return model.getUsers();
    }

    public ArrayList<AbstractHotelRoomBooking> getAllHotelRoomBookings() {
        return model.getHotelRoomBookings();
    }

    public ArrayList<AbstractLocalEventBooking> getAllLocalEventBookings() {
        return model.getLocalEventBookings();
    }

    public ArrayList<HotelRoom> getAllHotelRooms() {
        return model.getHotelRooms();
    }

    public ArrayList<LocalEvent> getAllLocalEvents() {
        return model.getLocalEvents();
    }
}
