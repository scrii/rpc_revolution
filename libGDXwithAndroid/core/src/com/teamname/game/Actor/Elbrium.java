package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;

import Tools.Point2D;

public class Elbrium extends Actor {
    private int health, score, rank;

    public Elbrium(Texture img, Point2D position, int rank) {
        super(img, position);

        switch (rank){
            case 1: health=100;score=5;R= Main.WIDTH/25;Speed=4;break;
            case 2: health=200;score=10;R= Main.WIDTH/15;Speed=3;break;
            case 3: health=300;score=20;R= Main.WIDTH/10;Speed=2;break;
    }


    setPosition();

    }

    public void setPosition(){
        direction.setX((float) Math.cos(Math.toRadians(Math.random()*360)));
        direction.setY((float) Math.sin(Math.toRadians(Math.random()*360)));
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX(),position.getY(),R*2,R*2);
    }

    @Override
    public void update() {
        // вылетел за карту? удаляем

        //
        //

        position.add(direction.getX(),direction.getY());
    }
}
