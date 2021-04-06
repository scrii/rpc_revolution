package com.mygdx.game;

import java.util.Date;
import com.teamname.game.Screens.GameSc;

public class Message {

    private String textMessage;
    private String author;
    private long timeMessage;



    public Message(String textMessage, String author) {
        this.textMessage = textMessage;
        this.author = author;
        timeMessage = new Date().getTime();
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


    public String getAutor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    public long getTimeMessage() {
        return timeMessage;
    }

    public void setTimeMessage(long timeMessage) {
        this.timeMessage = timeMessage;
    }
}
