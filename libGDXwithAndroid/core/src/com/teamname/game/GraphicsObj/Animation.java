package com.teamname.game.GraphicsObj;

import com.badlogic.gdx.graphics.g2d.TextureRegion;


import java.util.ArrayList;

public class Animation {
    private ArrayList<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion region, int frameCount, int cycleTime){
        frames = new ArrayList<>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for(int i=0;i<frameCount;i++)
            frames.add(new TextureRegion(region,i*frameWidth,0,frameWidth,region.getRegionHeight()));
        this.frameCount=frameCount;
        maxFrameTime=cycleTime/frameCount;
        frame=0;
    }

    public void update(float dt){
        currentFrameTime+=dt;
        if(currentFrameTime>maxFrameTime){
            frame++;
            currentFrameTime=0;
        }
        if(frame>=frameCount)
            frame=0;
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }



}
