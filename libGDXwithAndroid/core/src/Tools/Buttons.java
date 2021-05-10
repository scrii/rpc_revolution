package Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.GraphicsObj.GraphicsObj;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

public class Buttons {
    Texture unPressed;
    Texture pressed;
    Texture texture;
    private int pointer=-1;

    public boolean isTouch() {
        return isTouch;
    }

    private boolean isTouch=false;

    float width;
    float height;

    float startX;
    float startY;
    float endX;
    float endY;

    public Buttons(Texture unPressed, Texture pressed, float width, float height, float startX, float startY) {
        this.unPressed = unPressed;
        this.pressed = pressed;
        texture=unPressed;
        this.width = width;
        this.height = height;
        this.startX=startX;
        this.startY=startY;
        endX=startX+width;
        endY=startY+height;
    }

    public boolean isButtonTouch(float clickX, float clickY){
        // нужно инвертировать координаты
        // Main.HEIGHT-startY
        return clickX>startX&&clickX<endX&&clickY>startY&&clickY<endY;
    }


    public void draw(SpriteBatch batch) {
        batch.draw(texture,startX,startY,width,height);
    }

    public void action(float x, float y, boolean isDownTouch, int pointer){
        if(isDownTouch&&isButtonTouch(x,y)&&this.pointer==-1)this.pointer=pointer;
        if(isDownTouch&&this.pointer==pointer&& GameSc.joy.getPointer()==-1&&GameSc.joy2.getPointer()==-1){isTouch=true;texture=pressed;}
        if(!isDownTouch&&this.pointer==pointer)unPressed();
    }

    public void unPressed(){
        isTouch=false;
        setTexture(unPressed);
        pointer=-1;
    }

    public void setTexture(Texture texture){
        this.texture=texture;
    }

}