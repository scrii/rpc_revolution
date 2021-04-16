package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Tools.Point2D;

public class Bullet extends Actor {

    public Bullet(Texture img, Point2D position, float Speed, float R, Point2D direction) {
        super(img, position, Speed, R);
        this.direction=new Point2D(direction);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX()-R,position.getY()-R,R*2,R*2);
    }

    @Override
    public void update() {
        position.add(direction.getX()*Speed,position.getY()*Speed);
        bounds.pos.setPoint(position);

    }
}
