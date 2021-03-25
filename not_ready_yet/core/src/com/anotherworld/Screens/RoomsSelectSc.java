package com.anotherworld.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.anotherworld.Main;

import Tools.Scroller;

public class RoomsSelectSc implements Screen {
    Main main;
    OrthographicCamera camera;
    Texture background;
    Scroller scroller;
    float startY;


    private float cameraPosY=500;
    private float cameraPosX=Main.WIDTH/2;

    public RoomsSelectSc(Main main) {
        this.main = main;
        camera=new OrthographicCamera(Main.WIDTH,Main.HEIGHT);
        background=new Texture("backscroll.jpg");
        scroller=new Scroller(camera,cameraPosX,cameraPosY);
        camera.position.set(cameraPosX,cameraPosY,0);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
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
                cameraPosY=camera.position.y;
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                camera.position.set(cameraPosX,screenY,0);
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
        });
    }

    @Override
    public void render(float delta) {
        Main.batch.begin();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Main.batch.setProjectionMatrix(camera.combined);
        camera.update();
        Main.batch.draw(background,0,0);

        camera.position.set(0,delta,0);

        Main.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }



}
