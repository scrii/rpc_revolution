package com.anotherworld.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anotherworld.Main;

import Tools.Point2D;

public class Player extends Actor {



    private int Score;
    private float health;
    private Point2D player_position;
    private Point2D player_direction;


    public Player(Texture img, Point2D position, float Speed, float R, float health) {
        super(img, position, Speed, R);
        this.health=health;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.getX()-R,position.getY()-R);
    }

    public Point2D getPlayer_position() {
        return player_position;
    }

    @Override
    public void update() {
        // не зашел ли игрок за границу
        if(position.getX()+R>= Main.WIDTH)position.setX(Main.WIDTH-R);
        if(position.getX()-R<=0)position.setX(R);
        if(position.getY()+R>=Main.HEIGHT)position.setY(Main.HEIGHT-R);
        if(position.getY()-R<=0)position.setY(R);


        position.add(direction.getX()*Speed,direction.getY()*Speed);
        player_position=position;

    }
}
