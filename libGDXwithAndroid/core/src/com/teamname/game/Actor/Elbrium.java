package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Tools.Point2D;

public class Elbrium extends Actor {
    @Override
    public void setDirection(Point2D dir) {
        super.setDirection(dir);
    }

    public Elbrium(Texture img, Point2D position, float Speed, float R) {
        super(img, position, Speed, R);
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void update() {

    }
}
