package com.mygdx.game;

public class Message {

    private String textMessage;
    private String author;
    private long timeMessage;
    private double x;
    private double y;
    private float gold;
    private float elbrium;
    private int speed;
    private int attack;
    private int health;
    private int protect;
    private String color_background;
    private String color_front;


    public Message(String textMessage, String author, double x, double y, float gold, float elbrium, int speed, int attack, int health, int protect, String color_background, String color_front) {
        this.textMessage = textMessage;
        this.author = author;
        this.x = x;
        this.y = y;
        this.gold = gold;
        this.elbrium = elbrium;
        this.speed = speed;
        this.attack = attack;
        this.health = health;
        this.protect = protect;
        this.color_background = color_background;
        this.color_front = color_front;
    }

    //    public Message(String textMessage, String author) {
//        this.textMessage = textMessage;
//        this.author = author;
//        //timeMessage = new Date().getTime();
//    }
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

    public long getTimeMessage() {
        return timeMessage;
    }

    public void setTimeMessage(long timeMessage) {
        this.timeMessage = timeMessage;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public float getGold() {
        return gold;
    }

    public void setGold(float gold) {
        this.gold = gold;
    }

    public float getElbrium() {
        return elbrium;
    }

    public void setElbrium(float elbrium) {
        this.elbrium = elbrium;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getProtect() {
        return protect;
    }

    public void setProtect(int protect) {
        this.protect = protect;
    }

    public String getColor_background() {
        return color_background;
    }

    public void setColor_background(String color_background) {
        this.color_background = color_background;
    }

    public String getColor_front() {
        return color_front;
    }

    public void setColor_front(String color_front) {
        this.color_front = color_front;
    }
}
