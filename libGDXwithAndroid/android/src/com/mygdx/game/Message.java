package com.mygdx.game;

import java.util.Date;
import com.teamname.game.Screens.GameSc;

public class Message {

    private String textMessage;
    private String author;
    private long timeMessage;
    private float coordinats_x;
    private float coordinats_y;
    public Message() {
        float coordinats_x_libgdx = GameSc.player.getPosition().getX();
        float coordinats_y_libgdx = GameSc.player.getPosition().getY();
    }

    public Message(String textMessage, String author, float coordinats_x, float coordinats_y) {
        this.textMessage = textMessage;
        this.author = author;
        this.coordinats_x = coordinats_x;
        this.coordinats_y = coordinats_y;
        timeMessage = new Date().getTime();
    }


    public void setCoordinats_x(float coordinats_x) {
        this.coordinats_x = coordinats_x;
    }

    public float getCoordinats_x() {
        return coordinats_x;
    }

    public void setCoordinats_y(float coordinats_y) {
        this.coordinats_y = coordinats_y;
    }

    public float getCoordinats_y() {
        return coordinats_y;
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
