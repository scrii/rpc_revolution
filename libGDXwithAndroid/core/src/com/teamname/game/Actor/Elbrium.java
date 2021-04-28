package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Elbrium extends Actor {
    private int health, score, rank;
    public boolean isOut;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Elbrium(Texture img, Point2D position, int rank) {
        super(img, position);

        switch (rank){
            case -1: health=10;score=100;R=Main.WIDTH/50;Speed=0.8f;break;
            case 0: health=10;score=100;R=Main.WIDTH/50;Speed=5;break;
            case 1: health=100;score=5;R= Main.WIDTH/50;Speed=0.1f;break;
            case 2: health=200;score=10;R= Main.WIDTH/35;Speed=0.08f;break;
            case 3: health=300;score=20;R= Main.WIDTH/25;Speed=0.05f;break;
    }


    setPosition();

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

        //
        //

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


}
