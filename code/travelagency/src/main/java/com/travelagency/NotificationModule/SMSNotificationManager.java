package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.Model;
import com.travelagency.model.User;
public class SMSNotificationManager extends NotificationManager {
    public SMSNotificationManager( Model userModel) {
        super(userModel);
    }
    @Override
    public void requestNotification(User user, TemplateText template, ArrayList<String> placeHolders) {
        maker = new SMSMaker(template);
        statistics = SMSNotificationStatistics.getInstance();
        Notification newNotification = maker.makeNotification(user, placeHolders);
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new SMSSender());
        queueHandler.reset();
    }
}
