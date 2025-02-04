package com.travelagency.NotificationModule;

public class ResetPasswordTemplate extends TemplateText {
    public ResetPasswordTemplate() {
        super("Dear {x}, this is regarding your password reset request\n", "Reset Password");
        super.setPlaceholdersNum(1);
    }
}