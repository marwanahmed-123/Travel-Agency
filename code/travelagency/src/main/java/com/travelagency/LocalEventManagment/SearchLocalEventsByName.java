package com.travelagency.LocalEventManagment;

import java.util.ArrayList;

import com.travelagency.model.*;

public class SearchLocalEventsByName implements SearchLocalEvents {
    @Override
    public ArrayList<LocalEvent> searchLocalEvents(String text, Model model) {
        ArrayList<LocalEvent> localEvents = model.getLocalEvents();
        ArrayList<LocalEvent> localEventsToBeSent = new ArrayList<>();
        boolean getEverything = false;
        if (text == "")
            getEverything = true;
        for (int i = 0; i < localEvents.size(); i++) {
            String localEventName = localEvents.get(i).getName();
            LocalEvent localEvent = localEvents.get(i);
            if (getEverything || (localEventName.contains(text)))
                localEventsToBeSent.add(localEvent);
        }
        return localEventsToBeSent;
    }
}
