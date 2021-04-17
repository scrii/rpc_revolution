package Online;

import com.teamname.game.Screens.MenuSc;


public class Message {
    public String author;
    public double x;
    public double y;
    public float gold;
    public float elbrium;
    public int speed;
    public int attack;
    public int health;
    public int protect;
    public String color_background;
    public String color_front;



    public Message(String author, double x, double y, float gold, float elbrium, int speed, int attack, int health, int protect, String color_background, String color_front) {
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



    public Message(String data){author=data;}



    public void setAuthor(String author) {
        this.author = author;
    }



    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setGold(float gold) {
        this.gold = gold;
    }

    public void setElbrium(float elbrium) {
        this.elbrium = elbrium;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setProtect(int protect) {
        this.protect = protect;
    }

    public void setColor_background(String color_background) {
        this.color_background = color_background;
    }

    public void setColor_front(String color_front) {
        this.color_front = color_front;
    }
}
