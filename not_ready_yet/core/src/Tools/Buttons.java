package Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Buttons {
    Texture unPressed;
    Texture pressed;

    float width;
    float height;

    float startX;
    float startY;

    float endX;
    float endY;

    float clickX;
    float clickY;

    public Buttons(Texture unPressed, Texture pressed, float width, float height, float startX, float startY) {
        this.unPressed = unPressed;
        this.pressed = pressed;
        this.width = width;
        this.height = height;
        this.startX=startX;
        this.startY=startY;
        endX=startX+width;
        endY=startY+height;
    }

    public boolean isButtonTouch(){
        // нужно инвертировать координаты по OY
        // Main.HEIGHT-startY
        // (сделано)
        return Gdx.input.isTouched()&&clickX>startX&&clickX<endX&&clickY>startY&&clickY<endY;
    }


    public void draw(SpriteBatch batch, float clickX, float clickY) {
        this.clickX=clickX;
        this.clickY=clickY;
        if(isButtonTouch()&&Gdx.input.isTouched()){batch.draw(pressed,startX,startY,width,height);}
        else batch.draw(unPressed,startX,startY,width,height);
    }

}
