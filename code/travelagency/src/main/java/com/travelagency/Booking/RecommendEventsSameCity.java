package com.travelagency.Booking;

import java.util.ArrayList;

import com.travelagency.model.LocalEvent;
import com.travelagency.model.Model;

public class RecommendEventsSameCity implements IrecommendEvents {
    @Override
    public ArrayList<LocalEvent> recommendEvents(String city, Model model) {
        ArrayList<LocalEvent> eventsToBeRecommended = new ArrayList<>();
        ArrayList<LocalEvent> events = model.getLocalEvents();
        for (int i = 0; i < events.size(); i++) {
            String eventCity = events.get(i).getCity();
            LocalEvent event = events.get(i);
            if (eventCity.equals(city)) {
                eventsToBeRecommended.add(event);
            }
        }
        return eventsToBeRecommended;
    }
}
