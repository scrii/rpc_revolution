package Online;

import com.google.gson.Gson;
import com.teamname.game.Screens.MenuSc;


public class Message {
    public String author;
    public float x;
    public float y;
    public double gold;
    public double elbrium;
    public double speed;
    public double attack;
    public double health;
    public double protect;
    public String color_background;
    public String color_front;

    private DatabaseHelper databaseHelper;
    private final Gson gson;




    public Message(String author, float x, float y, double gold, double elbrium, double speed, double attack, double health, double protect, String color_background, String color_front) {
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
        gson=new Gson();
    }

    @Override
    public String toString() {
        return "Message{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //public Message(String data){author=data;}



    public void setAuthor(String author) {
        this.author = author;
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

    public double getSpeed() {
        return speed;
    }

    public void setColor_front(String color_front) {
        this.color_front = color_front;
    }


}
