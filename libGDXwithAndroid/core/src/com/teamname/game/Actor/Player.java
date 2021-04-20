package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import Online.DatabaseHelper;
//import Online.DatabaseHelper;
import Online.Message;
import Online.PlayerDataCollect;
import Online.PlayerDataCreator;
import Tools.Joystick;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.GdxFIRStorage;

public class Player extends Actor {

    private int Score;
    private float health;
    public float X;
    public float Y;
    public Point2D send_in_ONLINE;
    public boolean isMove;
    public String nickname;
    public PlayerDataCreator playerData;
    public PlayerDataCollect playerCollectData;



    private DatabaseHelper databaseHelper;

    public Player(String nickname,Texture img, Point2D position, float Speed, float R, float health) {
        super(img, position, Speed, R);
        this.health=health;
        this.nickname=nickname;
        databaseHelper=new DatabaseHelper();
        playerData=new PlayerDataCreator();
        playerCollectData=new PlayerDataCollect();

    }

    // метод оповещения о движении

    public boolean isMove() {
        return isMove;
    }

    @Override
    public void draw(SpriteBatch batch) {
        // !!! поставить значение ширины и высоты в константы
        //batch.draw(img, position.getX()-R,position.getY()-R,50,50);

        GameSc.camera.position.set(send_in_ONLINE.getX()-R,send_in_ONLINE.getY()-R,0);
    }

    @Override
    public void update() {
        // не зашел ли игрок за границу
        /*if(position.getX()+R>= Main.WIDTH)position.setX(Main.WIDTH-R);
        if(position.getX()-R<=0)position.setX(R);
        if(position.getY()+R>=Main.HEIGHT)position.setY(Main.HEIGHT-R);
        if(position.getY()-R<=0)position.setY(R);*/




        X=direction.getX()*Speed;
        Y=direction.getY()*Speed;
        position.add(X,Y);
        send_in_ONLINE=position;
       // send_in_ONLINE.add(-100,-100);

        // общая ширина - половина экрана

        // 8 условий - 4 для камеры - 4 для игрока

        if(send_in_ONLINE.getX()+R>=Main.BACKGROUND_WIDTH-Main.WIDTH/2)send_in_ONLINE.setX(Main.BACKGROUND_WIDTH-Main.WIDTH/2-R);
        if(send_in_ONLINE.getX()-R<=Main.WIDTH/2)send_in_ONLINE.setX(Main.WIDTH/2+R);
        if(send_in_ONLINE.getX()+R>=Main.BACKGROUND_HEIGHT-Main.HEIGHT)send_in_ONLINE.setY(Main.BACKGROUND_HEIGHT-Main.HEIGHT-R);
        if(send_in_ONLINE.getX()-R<=Main.HEIGHT/2)send_in_ONLINE.setY(Main.HEIGHT/2+R);

        //databaseHelper.sendCoords("email",send_in_ONLINE.getX(),send_in_ONLINE.getY());

        //playerData.setCoords(send_in_ONLINE);

        //databaseHelper.playerDataUpdate(nickname, playerData.getMessage());


       // test push = GdxFIRDatabase.instance().inReference("test").push().setValue(new Message("metadata"));

        if(isMove){playerData.update(send_in_ONLINE);
            //playerCollectData.getPosition("scri");



        }

        //Gdx.app.log("PLAYER_MOVE",isMove+"");

        // отправка координат, условия остановки
        //if(isMove)databaseHelper.sendCoords("email",send_in_ONLINE.getX(),send_in_ONLINE.getY());


    }

    public Point2D getPosition(){
        return send_in_ONLINE;
    }
}
