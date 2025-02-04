package com.travelagency.HotelManagment;

import com.travelagency.model.*;

import java.util.ArrayList;

public class SearchHotelRoomsByName implements SearchHotelRooms {

    @Override
    public ArrayList<HotelRoom> searchHotelRooms(String text, Model model) {
        ArrayList<HotelRoom> hotelRooms = model.getHotelRooms();
        ArrayList<HotelRoom> hotelRoomsToBeSent = new ArrayList<>();
        boolean getEverything = false;
        if (text == "")
            getEverything = true;
        for (int i = 0; i < hotelRooms.size(); i++) {
            String hotelRoomName = hotelRooms.get(i).getName();
            HotelRoom hotelRoom = hotelRooms.get(i);
            if (getEverything || (hotelRoomName.contains(text)))
                hotelRoomsToBeSent.add(hotelRoom);
        }
        return hotelRoomsToBeSent;
    }
}
