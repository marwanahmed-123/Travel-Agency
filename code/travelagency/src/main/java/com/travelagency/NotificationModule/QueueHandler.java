package com.travelagency.NotificationModule;

import com.travelagency.model.Model;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueHandler implements Runnable {
    private Queue<NotificationPair> notificationQueue = new ArrayDeque<>();
    private static QueueHandler instance = null;
    private Model usersModel;
    private Thread currenThread = null;

    private QueueHandler(Model usersModel) {
        this.usersModel = usersModel;
    }

    public void pushNotification(Notification notification, NotificationSender sender) {
        NotificationPair pair = new NotificationPair(notification, sender);
        this.notificationQueue.add(pair);
    }

    @Override
    public void run() {
        while (!notificationQueue.isEmpty()) {
            NotificationPair pair = notificationQueue.poll();
            NotificationSender sender = pair.getSender();
            if (sender != null) {
                sender.sendNotification(pair.getNotification(), usersModel);
            } else {
                pair.getNotification().setStatus(false);
            }
        }
    }

    public static QueueHandler getInstance(Model usersModel) {
        if (instance == null)
            instance = new QueueHandler(usersModel);

        return instance;
    }

    public void reset() {
        synchronized (this) {
            if ((currenThread != null && !currenThread.isAlive()) || currenThread == null) {
                currenThread = new Thread(this);
                currenThread.start();
            }
        }
    }
}
