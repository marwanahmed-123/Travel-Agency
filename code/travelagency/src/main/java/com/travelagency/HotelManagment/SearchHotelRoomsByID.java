package com.travelagency.HotelManagment;

import java.util.ArrayList;
import com.travelagency.model.*;

import com.travelagency.model.HotelRoom;

public class SearchHotelRoomsByID implements SearchHotelRooms {
    @Override
    public ArrayList<HotelRoom> searchHotelRooms(String text, Model model) {
        ArrayList<HotelRoom> hotelRooms = model.getHotelRooms();
        ArrayList<HotelRoom> hotelRoomsToBeSent = new ArrayList<>();
        for (int i = 0; i < hotelRooms.size(); i++) {
            String hotelRoomID = hotelRooms.get(i).getHotelRoomID();
            HotelRoom hotelRoom = hotelRooms.get(i);
            if (hotelRoomID.equals(text)) {
                hotelRoomsToBeSent.add(hotelRoom);
                break;
            }
        }
        return hotelRoomsToBeSent;
    }
}
