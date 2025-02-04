package com.travelagency.LocalEventManagment;

import java.util.ArrayList;

import com.travelagency.NotificationModule.EmailNotificationManager;
import com.travelagency.NotificationModule.NotificationManager;
import com.travelagency.NotificationModule.TemplateText;
import com.travelagency.model.*;

public class LocalEventManagment extends AbstractLocalEventManagment {
    public LocalEventManagment(Model model, SearchLocalEvents search, AddLocalEvent add) {
        super(model, search, add);
    }

    @Override
    public boolean removeLocalEvent(String id) {
        LocalEvent event = model.getLocalEventWithID(id);
        if (event == null)
            return false;
        NotificationManager manager = new EmailNotificationManager(model);
        TemplateText template = new TemplateText(
                "Local Event {x} was removed from the travel agency application check {x} about your bookings with this hotel room",
                "Local Event removal");
        ArrayList<User> users = filterUsersByLocalEventID(id);
        ArrayList<String> placeHolders = new ArrayList<>();
        template.setPlaceholdersNum(2);
        placeHolders.add(event.getName());
        placeHolders.add(event.getOrganizer());
        manager.requestBulkNotification(users, template, placeHolders);
        return model.removeLocalEvent(event);
    }
}
