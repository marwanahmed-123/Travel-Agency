package com.travelagency.NotificationModule;
public class NotificationPair {
    private Notification notification;
    private NotificationSender sender;
    
    public NotificationPair(Notification notification, NotificationSender sender) {
        this.notification = notification;
        this.sender = sender;
    }
    
    public Notification getNotification() {
        return notification;
    }
    
    public NotificationSender getSender() {
        return sender;
    }
}