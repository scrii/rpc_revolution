package com.mygdx.game;

public class Message {

    private String textMessage;
    private String author;

    public Message(String textMessage, String author) {
        this.textMessage = textMessage;
        this.author = author;
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

}
