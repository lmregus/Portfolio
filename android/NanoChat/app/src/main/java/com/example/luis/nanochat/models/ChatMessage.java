package com.example.luis.nanochat.models;

/**
 * Created by luis on 1/5/16.
 */
public class ChatMessage {
    private String name;
    private String text;
    private String userName;

    public ChatMessage() {

    }

    public ChatMessage(String name, String text, String userName) {
        this.name = name;
        this.text = text;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.name = email;
    }

}
