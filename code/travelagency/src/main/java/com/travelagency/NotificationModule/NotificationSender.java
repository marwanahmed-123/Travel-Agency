package com.travelagency.NotificationModule;

import com.travelagency.model.Model;

public interface NotificationSender {
    public abstract void sendNotification(Notification notification, Model usersModel);
}
