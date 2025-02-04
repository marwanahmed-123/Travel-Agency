package com.travelagency.NotificationModule;

import java.util.UUID;

public abstract class Notification {
    private String content;
    private boolean status = true;
    private boolean isSent = false;
    private String userid;
    private String templateName;
    private String type;
    private String notificationId;
    public Notification(String type, String content, String userid, String templateName) {
        String uuid = UUID.randomUUID().toString();
        this.content = content;
        this.userid = userid;
        this.templateName = templateName;
        this.notificationId = uuid.substring(0, 10);
    }
    public String getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTemplateName() {
        return templateName;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public String getContent() {
        return content;
    }
    public boolean getStatus() {
        return status;
    }
    public boolean getOverallStatus() {
        return status&&isSent;
    }
    public String getUserid() {
        return userid;
    }
    public void setIsSent(boolean isSent) {
        this.isSent = isSent;
    }
    public boolean getIsSent() {
        return this.isSent;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
}
