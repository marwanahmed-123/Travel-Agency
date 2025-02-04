package com.travelagency.NotificationModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class NotificationStatistics {
    protected Map<String, Integer> templateMap;
    protected Notifications notificationsData;

    NotificationStatistics() {
        this.templateMap = new HashMap<>();
        this.notificationsData = Notifications.getInstance();
    }

    public abstract void addNotification(Notification notification);

    public int getNumberOfSuccessfull() {
        ArrayList<Notification> notifications = notificationsData.getStatusNotifications(true);
        return notifications.size();
    }

    public int getNumberOfUnSuccessfull() {
        ArrayList<Notification> notifications = notificationsData.getStatusNotifications(false);
        return notifications.size();
    }

    public String getMostUsedFromMap(Map<String, Integer> map) {
        int max = 0;
        String maxText = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String text = entry.getKey();
            int value = entry.getValue();
            if (value > max) {
                max = value;
                maxText = text;
            }
        }
        return maxText;
    }

    public abstract String getMostNotified();

    public String getMostSentTemplate() {
        String template = getMostUsedFromMap(templateMap);
        return template;
    }
}
