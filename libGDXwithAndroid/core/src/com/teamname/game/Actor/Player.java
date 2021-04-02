package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;

import Online.DatabaseHelper;
//import Online.DatabaseHelper;
import Online.Message;
import Tools.Joystick;
import Tools.Point2D;

public class Player extends Actor {

    private int Score;
    private float health;
    public float X;
    public float Y;
    public Point2D send_in_ONLINE;
    public boolean isMove;
    public String nickname;



    private DatabaseHelper databaseHelper;

    public Player(String nickname,Texture img, Point2D position, float Speed, float R, float health) {
        super(img, position, Speed, R);
        this.health=health;
        this.nickname=nickname;
        databaseHelper=new DatabaseHelper();
    }

    // метод оповещения о движении

    public boolean isMove() {
        return isMove;
    }

    @Override
    public void draw(SpriteBatch batch) {
        // !!! поставить значение ширины и высоты в константы
        batch.draw(img, position.getX()-R,position.getY()-R,50,50);
    }

    @Override
    public void update() {
        // не зашел ли игрок за границу
        if(position.getX()+R>= Main.WIDTH)position.setX(Main.WIDTH-R);
        if(position.getX()-R<=0)position.setX(R);
        if(position.getY()+R>=Main.HEIGHT)position.setY(Main.HEIGHT-R);
        if(position.getY()-R<=0)position.setY(R);




        X=direction.getX()*Speed;
        Y=direction.getY()*Speed;
        position.add(X,Y);
        send_in_ONLINE=position;
        databaseHelper.changeMapValues(send_in_ONLINE.getX(),send_in_ONLINE.getY());
        databaseHelper.sendCoords("email");
        //Gdx.app.log("PLAYER_MOVE",isMove+"");

        // отправка координат, условия остановки
        //if(isMove)databaseHelper.sendCoords("email",send_in_ONLINE.getX(),send_in_ONLINE.getY());


    }

    public Point2D getPosition(){
        return send_in_ONLINE;
    }
}
