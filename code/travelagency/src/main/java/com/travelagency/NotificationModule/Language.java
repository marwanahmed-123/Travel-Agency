package com.travelagency.NotificationModule;

public class Language {
    private String languageName;
    private String text;

    public Language(String languageName, String text) {
        this.languageName = languageName;
        this.text = text;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getText() {
        return text;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setText(String text) {
        this.text = text;
    }
}
