package FirebaseHelper;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;


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

    private Gson gson;

    private DatabaseHelper databaseHelper;
  //  private final Gson gson;




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

    public void setGold(double gold) {
        this.gold = gold;
    }

    public void setElbrium(double elbrium) {
        this.elbrium = elbrium;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setProtect(double protect) {
        this.protect = protect;
    }

    @Override
    public String toString() {
        return "\"attack\":" + attack  + "," +
                "\"author\":\"" + author + "\"," +
                "\"color_background\":\"" + color_background + "\"," +
                "\"color_front\":\"" + color_front + "\"," +
                "\"elbrium\":" + elbrium  + "," +
                "\"gold\":" + gold  + "," +
                "\"health\":" + health  + "," +
                "\"protect\":" + protect  + "," +
                "\"speed\":" + speed  + "," +
                "\"x\":" + x  + "," +
                "\"y\":" + y  + "}";
    }

    public Message getData(String metadata){
        return gson.fromJson(metadata, Message.class);
    }

    public void logIt(String tag, String log){
        Gdx.app.log(tag, log);
    }

    public void deleteMessage(String ref){
        databaseHelper.removeFromFirebase(ref);
    }

    //{"attack":0.0,"author":"author",
    // "color_background":"back","color_front":"front","elbrium":0.0,"gold":0.0,"health":0.0,"protect":0.0,"speed":0.0,"x":0.0,"y":0.0}//{"attack":0.0,"author":"author",
    // "color_background":"back","color_front":"front","elbrium":0.0,"gold":0.0,"health":0.0,"protect":0.0,"speed":0.0,"x":0.0,"y":0.0}



    public void setAuthor(String author) {
        this.author = author;
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
