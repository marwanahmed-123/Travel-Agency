package com.travelagency.HotelManagment;

import com.travelagency.model.*;

import java.util.ArrayList;

public interface SearchHotelRooms {
  public ArrayList<HotelRoom> searchHotelRooms(String text, Model model);

}
