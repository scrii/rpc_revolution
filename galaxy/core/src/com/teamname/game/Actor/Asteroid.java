package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Tools.Point2D;

public class Asteroid extends Actor {

    public Point2D position;
    public Point2D send_in_ONLINE;


    public Asteroid(Texture img, Point2D position, float Speed, float R) {
        super(img, position, Speed, R);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.getX(),position.getY());
    }

    @Override
    public void update() {
        // условие встречи с границами
        //if(position.getX()<)
    }
}
