package com.travelagency.NotificationModule;

import java.util.Map;
import java.util.HashMap;

public class DashboardNotificationStatistics extends NotificationStatistics {
    private Map<String, Integer> dashboardTemplates;
    private static DashboardNotificationStatistics instance = null;

    private DashboardNotificationStatistics() {
        dashboardTemplates = new HashMap<>();
    }
    @Override
    public void addNotification(Notification notification) {
        templateMap.put(notification.getTemplateName(),
                templateMap.getOrDefault(notification.getTemplateName(), 0) + 1);
        if (notification instanceof DashboardNotification) {
            DashboardNotification dash = (DashboardNotification) notification;
            dashboardTemplates.put(dash.getTemplateName(),
                    dashboardTemplates.getOrDefault(dash.getTemplateName(), 0) + 1);
        }
        notificationsData.addNotification(notification);
    }

    @Override
    public String getMostNotified() {
        String dash = getMostUsedFromMap(dashboardTemplates);
        if(dash.length() == 0 || dash == null)dash = "None";
        return dash;
    }

    public static DashboardNotificationStatistics getInstance() {
        if (instance == null)
            instance = new DashboardNotificationStatistics();

        return instance;
    }
}