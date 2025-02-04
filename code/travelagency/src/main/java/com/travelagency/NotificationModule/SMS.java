package com.travelagency.NotificationModule;

public class SMS extends Notification {
    private String number;

    public SMS(String content, String status, String userid, String number, String templateName) {
        super( "sms",content, userid, templateName);
        this.number = number;
        this.setType("sms");
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
