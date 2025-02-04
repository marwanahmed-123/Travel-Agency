package com.travelagency.HotelManagment;

import com.travelagency.model.*;

public class AddStandardRoom implements AddHotelRoom {
    @Override
    public boolean addHotelRoom(String Hotel, String City, String Address, boolean Available, String name,
            Double price, Model model) {
        HotelRoom hotelRoom = new StandardRoom(Hotel, City, Address, Available, name, price);
        return model.addHotelRoom(hotelRoom);
    }
}
