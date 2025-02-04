package com.travelagency.LocalEventManagment;

import com.travelagency.model.*;;

public interface AddLocalEvent {
    public boolean addLocalEvent(String address, String city, String organizer, String name, Double price,
            int numOfTickets, Model model);
}
