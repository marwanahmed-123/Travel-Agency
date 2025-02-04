package com.travelagency.NotificationModule;

import java.util.HashMap;
import java.util.Map;

public class SMSNotificationStatistics extends NotificationStatistics {
    private Map<String, Integer> numberMap;
    private static SMSNotificationStatistics instance = null;

    private SMSNotificationStatistics() {
        numberMap = new HashMap<>();
    }
    @Override
    public void addNotification(Notification notification) {
        templateMap.put(notification.getTemplateName(),
                templateMap.getOrDefault(notification.getTemplateName(), 0) + 1);
        if (notification instanceof SMS) {
            SMS sms = (SMS) notification;
            numberMap.put(sms.getNumber(), numberMap.getOrDefault(sms.getNumber(), 0) + 1);
        }
        notificationsData.addNotification(notification);
    }

    @Override
    public String getMostNotified() {
        String sms = getMostUsedFromMap(numberMap);
        if(sms.length() == 0 || sms == null)sms = "None";
        return sms;
    }

    public static SMSNotificationStatistics getInstance() {
        if (instance == null)
            instance = new SMSNotificationStatistics();

        return instance;
    }
}
