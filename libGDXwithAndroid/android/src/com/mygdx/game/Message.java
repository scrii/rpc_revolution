package com.mygdx.game;

import java.util.Date;

public class Message {

    private String textMessage;
    private String author;
    private long messageTime;

    public Message(String textMessage, String author) {
        this.textMessage = textMessage;
        this.author = author;
        messageTime = new Date().getTime();
    }

    public Message() {
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
        //return textMessage;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

}
