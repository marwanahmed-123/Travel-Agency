package com.travelagency.NotificationModule;

import java.util.ArrayList;

public class Notifications {
    private ArrayList<Notification> notifications;
    private static Notifications instance = null;

    private Notifications() {
        this.notifications = new ArrayList<>();
    }

    public static Notifications getInstance() {
        if (instance == null) {
            instance = new Notifications();
            getNotificationsFromDatabase();
        }
        return instance;
    }

    public ArrayList<Notification> getNotifications() {
        return this.notifications;
    }

    public Notification getByNotificationId(String id) {
        Notification chosenNotification = null;
        for (Notification notification : notifications) {
            if (notification.getNotificationId().equals(id)) {
                chosenNotification = notification;
            }
        }

        return chosenNotification;
    }

    public void removeByNotificationId(String id) {
        for (int i = 0; i < notifications.size(); i++) {
            if (notifications.get(i).getNotificationId().equals(id)) {
                notifications.remove(i);
                break;
            }
        }
        return;
    }

    public ArrayList<Notification> getStatusNotifications(boolean status) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() == status) {
                chosenNotifications.add(notification);
            }
        }
        return chosenNotifications;
    }

    public ArrayList<Notification> getUserSuccessfulNotifications(String userid) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() && notification.getUserid().equals(userid)) {
                chosenNotifications.add(notification);
            }
        }
        return chosenNotifications;
    }

    public ArrayList<Notification> getUserTypeSuccessfulNotifications(String type, String userid) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() && notification.getType() == type
                    && notification.getUserid().equals(userid)) {
                chosenNotifications.add(notification);
            }
        }
        return chosenNotifications;
    }

    public ArrayList<Notification> getTypeSuccessfulNotifications(String type) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() && notification.getType().equals(type)) {
                chosenNotifications.add(notification);
            }
        }
        return chosenNotifications;
    }

    public void addNotification(Notification newNotification) {
        notifications.add(newNotification);
        updateDatabase("updates database");
    }

    public static void getNotificationsFromDatabase() {
        // gets notifications from database (notifications has its own database seperate
        // from the rest of the program)
    }

    public void updateDatabase(String query) {
        // updates database (notifications has its own database seperate from the rest
        // of the program)
    }
}