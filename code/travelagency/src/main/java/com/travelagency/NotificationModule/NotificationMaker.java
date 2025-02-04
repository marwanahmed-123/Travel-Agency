package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.User;

public abstract class NotificationMaker {
    protected TemplateText templateMaker;

    public NotificationMaker(TemplateText maker) {
        this.templateMaker = maker;
    }
    public TemplateText getTemplateMaker() {
        return templateMaker;
    }
    public void setTemplateMaker(TemplateText templateMaker) {
        this.templateMaker = templateMaker;
    }

    public void setTemplate(TemplateText maker) {
        this.templateMaker = maker;
    }

    public abstract Notification makeNotification(User user, ArrayList<String> placeholders);
}