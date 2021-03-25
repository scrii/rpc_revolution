package Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.anotherworld.Main;

public class Scroller implements InputProcessor {
    OrthographicCamera camera;
    float startY;
    float delta;
    float defaultY;
    float defaultX;


    /*  Main.batch.setProjectionMatrix(camera.combined);
        camera.update();
        camera.position.set(player.send.getX()+player.R,player.send.getY()+player.R,0);*/

    public Scroller(OrthographicCamera camera,float defaultX,float defaultY) {
        this.camera = camera;
        this.defaultX=defaultX;
        camera.position.set(defaultX,defaultY,0);
    }



    public void motion(){
        Main.batch.setProjectionMatrix(camera.combined);
        camera.update();
        camera.position.set(0,delta,0);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        startY=screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        defaultY=camera.position.y;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        camera.position.set(defaultX,defaultY+Gdx.input.getY()-screenY,0);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
