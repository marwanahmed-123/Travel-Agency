package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.User;

public class SMSMaker extends NotificationMaker {// needs modification
    public SMSMaker(TemplateText maker) {
        super(maker);
    }

    public Notification makeNotification(User user, ArrayList<String> placeholders) {
        boolean isValid = templateMaker.isValid(placeholders);
        if (!isValid) {
            throw new IllegalArgumentException("Invalid placeholders for SMS template.");
        }
        String content = templateMaker.useTemplate(placeholders);
        Notification newNotification = new SMS(content, "created", user.getUserID(), user.getPhoneNumber(),
                templateMaker.getTemplateName());
        newNotification.setStatus(isValid);
        return newNotification;
    }
}
