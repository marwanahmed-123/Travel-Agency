package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.Model;
import com.travelagency.model.User;
public class EmailNotificationManager extends NotificationManager {
    public EmailNotificationManager(Model userModel) {
        super(userModel);
    }
    @Override
    public void requestNotification(User user, TemplateText template, ArrayList<String> placeHolders) {
        maker = new EmailMaker(template);
        statistics = EmailNotificationStatistics.getInstance();
        Notification newNotification = maker.makeNotification(user, placeHolders);
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new EmailSender());
        queueHandler.reset();
    }
}
