package com.travelagency.LocalEventManagment;

import com.travelagency.model.*;;

public class AddNormalLocalEvent implements AddLocalEvent {
    @Override
    public boolean addLocalEvent(String address, String city, String organizer, String name, Double price,
            int numOfTickets, Model model) {
        LocalEvent event = new NormalLocalEvent(address, city, organizer, name, price, numOfTickets);
        return model.addLocalEvent(event);
    }
}
