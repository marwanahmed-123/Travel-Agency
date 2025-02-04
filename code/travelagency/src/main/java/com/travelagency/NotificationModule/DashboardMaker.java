package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.User;

public class DashboardMaker extends NotificationMaker {
    public DashboardMaker(TemplateText maker) {
        super(maker);
    }

    public Notification makeNotification(User user, ArrayList<String> placeholders) {
        String content = templateMaker.useTemplate(placeholders);
        Notification newNotification = new DashboardNotification(content, user.getUserID(),
                templateMaker.getTemplateName());
        return newNotification;
    }
}
