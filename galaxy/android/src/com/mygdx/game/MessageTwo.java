package com.mygdx.game;

public class MessageTwo {
    // float место double из-за проблем с конструктором
    float x;
    float y;
    String nickname;
    String message;
    int gold;
    int elbrium;
    int speed;
    int attack;
    byte health;
    byte protect;
    String back_color;
    String front_color;

    public MessageTwo(float x, float y, String nickname, String message, int gold, int elbrium, int speed, int attack, byte health, byte protect, String back_color, String front_color) {
        this.x = x;
        this.y = y;
        this.nickname = nickname;
        this.message = message;
        this.gold = gold;
        this.elbrium = elbrium;
        this.speed = speed;
        this.attack = attack;
        this.health = health;
        this.protect = protect;
        this.back_color = back_color;
        this.front_color = front_color;
    }

    public MessageTwo(float x, float y, String nick, String msg, int gold, int elbrium, int speed, int attack, int health, int protect, String back_color, String front_color) {
    }

    public String getTextMessage() {
        return message;
    }
}
