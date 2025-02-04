package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.Model;
import com.travelagency.model.User;
public class DashboardNotificationManager extends NotificationManager {
    public DashboardNotificationManager(Model userModel) {
        super(userModel);
    }
    @Override
    public void requestNotification(User user, TemplateText template, ArrayList<String> placeHolders) {
        maker = new DashboardMaker(template);
        statistics = DashboardNotificationStatistics.getInstance();
        Notification newNotification = maker.makeNotification(user, placeHolders);
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new DashboardSender());
        queueHandler.reset();
    }
}
