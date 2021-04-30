package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;

import Tools.Circle;
import Tools.GetterANDSetterFile;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Elbrium extends Actor {
    private int health, score, rank;
    public boolean isOut;
    private int count;
    public Texture damaged_txr;
    private float deltaSpeed;
    public final float logOutSec=0.5f;
    public float counter=logOutSec;
    private float player_damage;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void damaged(Bullet b, int count){
        counter=logOutSec;
        img=damaged_txr;
        health-=player_damage;
        Speed+=deltaSpeed;
        direction.setPoint(b.direction.getX(),b.direction.getY());
        if(health<=0){
            GameSc.ore.removeIndex(count);
            GameSc.player.getter_setter.add_elbrium(score);
        }

    }

    public Elbrium(Texture img, Point2D position, int rank, Texture dameged_txr) {
        super(img, position);
        counter=-1;
        player_damage=GameSc.player.damage;
        this.damaged_txr=dameged_txr;
        Gdx.app.error("Elbrium",player_damage+"");

        switch (rank){
            case -1: health=10;score=100;R=Main.WIDTH/50;Speed=0.8f;deltaSpeed=0.001f;break;
            case 0: health=100;score=5;R= Main.WIDTH/50;Speed=0.1f;deltaSpeed=0.01f;break;
            case 1: health=30;score=5;R=Main.WIDTH/50;Speed=0.5f;deltaSpeed=0.01f;break;
            case 2: health=50;score=8;R= Main.WIDTH/35;Speed=0.3f;deltaSpeed=0.001f;break;
            case 3: health=120;score=15;R= Main.WIDTH/25;Speed=0.015f;deltaSpeed=0.0001f;break;
    }

        bounds = new Circle(position,R);


    setPosition();
    timeCheck();
    }

    public void setPosition(){
        direction.setX((float) Math.cos(Math.toRadians(Math.random()*360)));
        direction.setY((float) Math.sin(Math.toRadians(Math.random()*360)));
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX()-R,position.getY()-R,R*2,R*2);
    }

    @Override
    public void update() {
        // вылетел за карту? удаляем
        position.add(direction.getX()*Speed,direction.getY()*Speed);
        bounds.pos.setPoint(position);
        GdxFIRDatabase.instance().inReference("Elbrium_"+count).setValue(position.toString());
        isOut = (position.getX()+R<0 || position.getY()-R>Main.BACKGROUND_HEIGHT
                || position.getX()-R>Main.BACKGROUND_WIDTH || position.getY()+R<0);

    }

    public void removeElbrium(int count){
        GdxFIRDatabase.instance().inReference("Elbrium_"+count).removeValue();
        GameSc.ore.removeIndex(count);
        Gdx.app.log("ORE","ORE REMOVED");
    }

    public void timeCheck(){
        Timer timer=new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(counter==0){
                    img=Main.actor;
                    counter=-1;
                }
                else counter-=0.25f;
            }
        };
        timer.scheduleAtFixedRate(task,0,250);
    }


}
