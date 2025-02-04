package com.travelagency.HotelManagment;

import java.util.ArrayList;

import com.travelagency.NotificationModule.EmailNotificationManager;
import com.travelagency.NotificationModule.NotificationManager;
import com.travelagency.NotificationModule.TemplateText;
import com.travelagency.model.*;

public class HotelManagment extends AbstractHotelManagment {
    public HotelManagment(Model model, SearchHotelRooms search, AddHotelRoom add) {
        super(model, search, add);
    }

    @Override
    public boolean removeHotelRoom(String id) {
        HotelRoom room = model.getHotelRoomWithID(id);
        if (room == null)
            return false;
        NotificationManager manager = new EmailNotificationManager(model);
        TemplateText template = new TemplateText(
                "hotel room {x} was removed from the travel agency application check {x} about your bookings with this hotel room",
                "hotel room removal");
        ArrayList<User> users = filterUsersByHotelRoomID(id);
        ArrayList<String> placeHolders = new ArrayList<>();
        template.setPlaceholdersNum(2);
        placeHolders.add(room.getName());
        placeHolders.add(room.getHotel());
        manager.requestBulkNotification(users, template, placeHolders);
        return model.removeHotelRoom(room);
    }
}
