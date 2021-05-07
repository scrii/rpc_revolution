package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.teamname.game.GraphicsObj.Animation;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;

import Tools.Circle;
import Tools.GetterANDSetterFile;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Elbrium extends Actor {
    private int startHealth,health, score, rank;
    public boolean isOut;
    private int count, switchReg;
    public Texture damaged_txr;
    private float deltaSpeed;
    public final float logOutSec=0.5f;
    public float counter=logOutSec;
    private float player_damage;
    private boolean isDamaged;
    private float damage;
    private TextureRegion damageRegion,region;
    private Animation animation;
    private int textureCase;

    public float getDamage() {
        return damage;
    }

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
        isDamaged=true;
        //timeCheck();
        counter=logOutSec;
        img=damaged_txr;

        health-=player_damage;
        if(health>0&&health<=startHealth/5)textureCase=5;
        else if(health>startHealth/5&&health<=startHealth*2/5)textureCase=4;
        else if(health>startHealth*2/5&&health<=startHealth*3/5)textureCase=3;
        else if(health>startHealth*3/5&&health<=startHealth*4/5)textureCase=2;
        else textureCase=1;

        Speed+=deltaSpeed;
        direction.setPoint(b.direction.getX(),b.direction.getY());
        if(health<=0){
            GameSc.player.getter_setter.add_elbrium(score);
            GameSc.ore.removeIndex(count);
            Gdx.app.log("Elbrium #"+count, "i died :(");
        }

    }

    public Elbrium(Texture img, Point2D position, int rank) {
        super(img, position);
        counter=-1;
        switchReg=0;
        textureCase=1;
        player_damage=GameSc.player.damage;
        //region=new TextureRegion(Main.elbrium,);
        animation=new Animation(new TextureRegion(Main.elbriumCrash),4,2);

        switch (rank){
            case -1: health=10;score=100;R=Main.WIDTH/50;Speed=0.8f;deltaSpeed=0.001f;damage=50;break;
            case 0: health=100;score=5;R= Main.WIDTH/50;Speed=0.1f;deltaSpeed=0.01f;damage=5;break;
            case 1: health=30;score=5;R=Main.WIDTH/50;Speed=0.5f;deltaSpeed=0.01f;damage=5;break;
            case 2: health=50;score=8;R= Main.WIDTH/35;Speed=0.3f;deltaSpeed=0.0015f;damage=20;break;
            case 3: health=120;score=15;R= Main.WIDTH/25;Speed=0.015f;deltaSpeed=0.001f;damage=35;break;
    }


        startHealth=health;
        bounds = new Circle(position,R);


    setPosition();
    //timeCheck();
    }

    public void setPosition(){
        direction.setX((float) Math.cos(Math.toRadians(Math.random()*360)));
        direction.setY((float) Math.sin(Math.toRadians(Math.random()*360)));
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(thisTexture(),position.getX()-R,position.getY()-R,R*2,R*2);
        //batch.draw(region);
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

   /* public void timeCheck(){
        final Timer timer=new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                img=Main.actor;
                timer.cancel();


            }
        };
        timer.scheduleAtFixedRate(task,0,500);
    }*/

    public void changeHealth(float h){
        health+=h;
    }

    private Texture thisTexture(){
        switch (textureCase){
            case 1:return Main.ore1;
            case 2:return Main.ore2;
            case 3:return Main.ore3;
            case 4:return Main.ore4;
            case 5:return Main.ore5;
        }
        return Main.err;
    }


}
