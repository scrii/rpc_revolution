package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Bullet extends Actor {

    public boolean isOut;
    int count;

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
        position.add(direction.getX()*Speed,direction.getY()*Speed);
        bounds.pos.setPoint(position);
        //Gdx.app.log("bullet_position", position.toString());
        isOut = (position.getX()+R<0 || position.getY()-R> Main.BACKGROUND_HEIGHT
                || position.getX()-R>Main.BACKGROUND_WIDTH || position.getY()+R<0);

    }

    public void setCount(int count) {
        this.count = count;
    }

    public void removeBullet(int count){
        //GdxFIRDatabase.instance().inReference("Elbrium_"+count).removeValue();
        GameSc.bullets.removeIndex(count);
        //Gdx.app.log("ORE","ORE REMOVED");
    }

}
