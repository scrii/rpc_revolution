package com.teamname.game.GraphicsObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.teamname.game.Screens.GameSc;


import java.util.ArrayList;

public class Animation {
    private ArrayList<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;
    private boolean isDone;
    private int sceneCount;
    private int scenes;

    public int getSceneCount() {
        return sceneCount;
    }

    public Animation(TextureRegion region, int frameCount, int cycleTime, int scenes){
        isDone=false;
        frames = new ArrayList<>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for(int i=0;i<frameCount;i++)
            frames.add(new TextureRegion(region,i*frameWidth,0,frameWidth,region.getRegionHeight()));
        this.frameCount=frameCount;
        maxFrameTime=cycleTime/frameCount;
        frame=0;
        this.sceneCount=1;
        this.scenes=scenes;
    }

    public void setNewTextureReg(TextureRegion region){
        isDone=false;
        frames.clear();
        int frameWidth = region.getRegionWidth() / frameCount;
        for(int i=0;i<frameCount;i++)
            frames.add(new TextureRegion(region,i*frameWidth,0,frameWidth,region.getRegionHeight()));

        frame=0;
        //Gdx.app.error("region",region.toString());
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public void update(float dt){
        currentFrameTime+=dt;
        if(currentFrameTime>maxFrameTime){
            frame++;
            currentFrameTime=0;
        }
        if(frame>=frameCount)
        {
            isDone=true;
            //setNewTextureReg(GameSc.);
            if(scenes>1)setNewTextureReg(GameSc.getCometRegion(this));
            frame=0;
            //Gdx.app.error("sceneCount",sceneCount+"");
        }
        if(scenes>1&&sceneCount<scenes)sceneCount++;
        else if(sceneCount==scenes)sceneCount=1;
        //Gdx.app.error("frame",frame+"");
        //.Gdx.app.error("frame",frame+"");
        //Gdx.app.log("frameCount",frameCount+"");
        //Gdx.app.error("currentFrameTime",currentFrameTime+"");
        //Gdx.app.log("maxFrameTime",maxFrameTime+"");
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }

    public boolean isDone(){
        return isDone;
    }


}
