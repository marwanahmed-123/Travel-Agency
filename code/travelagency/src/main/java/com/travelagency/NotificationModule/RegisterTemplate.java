package com.travelagency.NotificationModule;

public class RegisterTemplate extends TemplateText {
    public RegisterTemplate() {
        super("welcome {x} to the travel agency application we hope you have a wonderful experiance \n", "Register");
        super.setPlaceholdersNum(1);
    }
}
