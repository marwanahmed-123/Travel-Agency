package com.travelagency.NotificationModule;

import java.util.HashMap;
import java.util.Map;

public class EmailNotificationStatistics extends NotificationStatistics {
    private Map<String, Integer> emailMap;
    private static EmailNotificationStatistics instance = null;

    private EmailNotificationStatistics() {
        emailMap = new HashMap<>();
    }
    @Override
    public void addNotification(Notification notification) {
        templateMap.put(notification.getTemplateName(),
                templateMap.getOrDefault(notification.getTemplateName(), 0) + 1);
        if (notification instanceof Email) {
            Email mail = (Email) notification;
            emailMap.put(mail.getEmail(), emailMap.getOrDefault(mail.getEmail(), 0) + 1);
        }
        notificationsData.addNotification(notification);
    }

    @Override
    public String getMostNotified() {
        String email = getMostUsedFromMap(emailMap);
        if(email.length() == 0 || email == null)email = "None";
        return email;
    }

    public static EmailNotificationStatistics getInstance() {
        if (instance == null)
            instance = new EmailNotificationStatistics();

        return instance;
    }
}
