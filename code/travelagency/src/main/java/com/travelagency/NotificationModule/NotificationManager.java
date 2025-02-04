package com.travelagency.NotificationModule;
import java.util.ArrayList;

import com.travelagency.model.Model;
import com.travelagency.model.User;

public abstract class NotificationManager {
    protected QueueHandler queueHandler;
    protected NotificationMaker maker;
    protected NotificationStatistics statistics;
    protected NotificationSender sender;
    protected Notifications notificationsData;
    public NotificationManager(Model userModel) {
        this.queueHandler = QueueHandler.getInstance(userModel);
        this.notificationsData = Notifications.getInstance();
    }
    public abstract void requestNotification(User user, TemplateText template, ArrayList<String> placeHolders);
    public void requestBulkNotification(ArrayList<User> users, TemplateText template, ArrayList<String> placeHolders){
        for (User user : users) {
            requestNotification(user, template, placeHolders);
        }
    }
    public Notifications getNotificationsData() {
        return notificationsData;
    }
}
