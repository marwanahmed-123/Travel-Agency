package com.travelagency.LocalEventManagment;

import java.util.ArrayList;

import com.travelagency.model.*;

public class SearchLocalEventsByID implements SearchLocalEvents {
    @Override
    public ArrayList<LocalEvent> searchLocalEvents(String text, Model model) {
        ArrayList<LocalEvent> localEvents = model.getLocalEvents();
        ArrayList<LocalEvent> localEventsToBeSent = new ArrayList<>();
        for (int i = 0; i < localEvents.size(); i++) {
            String localEventID = localEvents.get(i).getLocalEventID();
            LocalEvent localEvent = localEvents.get(i);
            if (localEventID.equals(text)) {
                localEventsToBeSent.add(localEvent);
                break;
            }
        }
        return localEventsToBeSent;
    }
}
