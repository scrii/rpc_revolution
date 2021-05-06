package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;

import FirebaseHelper.DatabaseHelper;
//import Online.DatabaseHelper;
import FirebaseHelper.Message;
import FirebaseHelper.PlayerDataCollect;
import FirebaseHelper.PlayerDataCreator;
import Tools.GetterANDSetterFile;
import Tools.Point2D;

public class Player extends Actor {

    private int Score;
    private float health;
    private float realSpeed=0;
    public float X;
    public float Y;

    public float getRealSpeed() {
        return realSpeed;
    }

    public Point2D send_in_ONLINE;
    public boolean isMove;
    public PlayerDataCreator playerData;
    public PlayerDataCollect playerCollectData;
    private Message player_data;
    public GetterANDSetterFile getter_setter;
    private Timer timer;
    private static final int logOutSec=60;
    private int counter=logOutSec;
    public float damage;
    private boolean leftC, rightC, upC, downC;



    private DatabaseHelper databaseHelper;

    public Player(Texture img, Point2D position, float Speed, float R, float health) {
        super(img, position, Speed, R);
        this.health=health;

        databaseHelper=new DatabaseHelper();
        playerData=new PlayerDataCreator();
        playerCollectData=new PlayerDataCollect();
        getter_setter=new GetterANDSetterFile();

        this.health+=getter_setter.get_Health();

        damage= (float) (getter_setter.get_Attack());
        player_data=new Message(getter_setter.getTexture(),GameSc.player_x,GameSc.player_y,
                getter_setter.get_Attack(),getter_setter.get_Health(),
                getter_setter.get_Protection());
        databaseHelper.sendToFirebase(getter_setter.get_Nickname(), player_data.toString());
        timeCheck();
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
        X=direction.getX()*realSpeed;
        Y=direction.getY()*realSpeed;
        position.add(X,Y);
        send_in_ONLINE=position;
        bounds.pos.setPoint(position);
        cameraCheck();
        playerCheck();
        if(isMove){
            counter=logOutSec;
            player_data.x=send_in_ONLINE.getX();
            player_data.y=send_in_ONLINE.getY();
            databaseHelper.sendToFirebase(getter_setter.get_Nickname(),player_data.toString());
        }

    }

    public float getHealth() {
        return health;
    }

    public void timeCheck(){
        timer=new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(counter==0){
                    Gdx.app.log("PLayer", "afk for "+logOutSec+" seconds");
                    databaseHelper.logOut();
                    timer.cancel();
                }
                else counter--;
            }
        };
        timer.scheduleAtFixedRate(task,0,1000);
    }

    public Point2D getPosition(){
        return send_in_ONLINE;
    }

    public void motion(){
        GameSc.camera.position.set(send_in_ONLINE.getX()-R,send_in_ONLINE.getY()-R,0);
    }

    public void motion(float final_float, int case_){
        switch (case_){
            case 0: GameSc.camera.position.set(final_float-R,send_in_ONLINE.getY()-R,0);break;
            case 1: GameSc.camera.position.set(send_in_ONLINE.getX()-R,final_float-R,0);break;
        }
    }

    public void motion(float final_x, float final_y){
        GameSc.camera.position.set(final_x-R,final_y-R,0);
    }

    private void cameraCheck(){
        leftC=send_in_ONLINE.getX()-R<=Main.WIDTH/2;
        rightC=send_in_ONLINE.getX()+R>=Main.BACKGROUND_WIDTH-Main.WIDTH/2;
        upC=send_in_ONLINE.getY()+R>=Main.BACKGROUND_HEIGHT-Main.HEIGHT/2;
        downC=send_in_ONLINE.getY()-R<=Main.HEIGHT/2;

        if(leftC){motion(Main.WIDTH/2+R, 0);GameSc.batchDraw=false;}
        if(upC){motion(Main.BACKGROUND_HEIGHT-Main.HEIGHT/2+R,1);GameSc.batchDraw=false;}
        if(downC){motion(Main.HEIGHT/2+R,1);GameSc.batchDraw=false;}
        if(rightC){motion(Main.BACKGROUND_WIDTH- Main.WIDTH/2+R,0);GameSc.batchDraw=false;}

        if(leftC&&upC){motion(Main.WIDTH/2+R,Main.BACKGROUND_HEIGHT-Main.HEIGHT/2-R);GameSc.batchDraw=false;}
        if(leftC&&downC){motion(Main.WIDTH/2+R,Main.HEIGHT/2+R);GameSc.batchDraw=false;}
        if(rightC&&upC){motion(Main.BACKGROUND_WIDTH- Main.WIDTH/2-R,Main.BACKGROUND_HEIGHT-Main.HEIGHT/2-R);GameSc.batchDraw=false;}
        if(rightC&&downC){motion(Main.BACKGROUND_WIDTH- Main.WIDTH/2-R,Main.HEIGHT/2+R);GameSc.batchDraw=false;}

        if(!leftC&&!upC&&!rightC&&!downC){motion();GameSc.batchDraw=true;}
    }

    public void playerCheck(){
        // не зашел ли игрок за границу
        if(position.getX()+R>= Main.BACKGROUND_WIDTH){send_in_ONLINE.setX(Main.BACKGROUND_WIDTH-R);setRealSpeed(0);}
        if(position.getX()-3*R<=0){send_in_ONLINE.setX(3*R);setRealSpeed(0);}
        if(position.getY()+2*R>=Main.BACKGROUND_HEIGHT){send_in_ONLINE.setY(Main.BACKGROUND_HEIGHT-2*R);setRealSpeed(0);}
        if(position.getY()-2*R<=0){send_in_ONLINE.setY(2*R);setRealSpeed(0);}

    }

    public void setRealSpeed(float realSpeed) {
        this.realSpeed = realSpeed;
    }

    public void changeSpeed(float val){
        realSpeed+=val;
        //Gdx.app.error("REALspeed",realSpeed+"");
    }

    public void changeHealth(float h){
        health+=h;
    }

}
