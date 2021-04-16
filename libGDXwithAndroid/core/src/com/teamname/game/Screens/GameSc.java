package com.teamname.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.teamname.game.Actor.Bullet;
import com.teamname.game.Actor.Elbrium;
import com.teamname.game.Actor.Player;
import com.teamname.game.Main;
//import com.


import Online.DatabaseHelper;
//import Online.Getter;
import Online.Message;
import Online.PlayerDataCreator;
import Tools.BulletGenerator;
import Tools.Joystick;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class GameSc implements Screen {


    Joystick joy,joy2;
    public static Player player;
    Sprite sprite=new Sprite(Main.background);
    OrthographicCamera camera;
    static Point2D realTimeCoords=new Point2D(0,0);

    public static Array<Bullet> bullets;
    public static Array<Elbrium> ore;

    BulletGenerator bullgen;

    //PlayerDataCreator playerData;



    private int joyX=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private int joyY=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private int joySize = Main.HEIGHT/3;
    //private int X_realTimeCoords=Main.WIDTH;
    //private int Y_realTimeCoords=Main.HEIGHT;


    private static final int entityRad = Main.HEIGHT/20;
    private static final int entityX=Main.WIDTH/2;
    private static final int entityY=Main.WIDTH/3;
    // ресурсы подгружаются с класса Main



    Main main;
    public DatabaseHelper databaseHelper;

    /*public GameSc(PlatformStuff stuff) {
        this.stuff = stuff;
    }*/

    public GameSc(Main main){
        this.main=main;
        loadActors();
        databaseHelper=new DatabaseHelper();
        //databaseHelper.setNickname(player.nickname);
        databaseHelper.entryNotify();
        camera=new OrthographicCamera(Main.WIDTH,Main.HEIGHT);
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
                //pointer - номер нажатия (0,1,...)
                screenY=Main.HEIGHT-screenY;
                setPos(screenX,screenY);
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY=Main.HEIGHT-screenY;
                multitouch((int)screenX,(int)screenY,false,pointer);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY=Main.HEIGHT-screenY;
                setPos(screenX,screenY);
                multitouch((int)screenX,(int)screenY,true,pointer);
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

        /*loadActors();*/
    }

    @Override
    public void render(float delta) {
        GameUpdate();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Main.batch.setProjectionMatrix(camera.combined);
        camera.update();
        Main.batch.begin();
        Main.batch.draw(Main.background,0,0);
        GameRender(Main.batch);
        // сплюсовать радиусы для отображения игрока ровно в центре
        camera.position.set(player.send_in_ONLINE.getX()-player.R,player.send_in_ONLINE.getY()-player.R,0);
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
        //getter.deleteCOORDS();
        sprite.getTexture().dispose();
        databaseHelper.entryNotify();
    }

    public void GameUpdate(){
        player.setDirection(joy.getDir());
        player.update();
        bullgen.update(joy2);
        for(int i=0;i<bullets.size;i++)bullets.get(i).update();
        for(int i=0;i<ore.size;i++)ore.get(i).update();
    }

    public void GameRender(SpriteBatch batch){
        player.draw(batch);
        joy.draw(batch);
        joy2.draw(batch);
        for(int i=0;i<bullets.size;i++)bullets.get(i).draw(batch);
        for(int i=0;i<ore.size;i++)ore.get(i).draw(batch);

    }

    public void loadActors(){

        //FileHandle file = Gdx.files.absolute("nickname.txt");
        //String name = file.readString();




        player =new Player("SCRI" ,Main.actor,new Point2D(entityX,entityY),40,entityRad,20);
        //getter.setPlayer(player);
        joy=new Joystick(Main.circle,Main.stickImg,new Point2D(joyX,joyY),joySize);

        bullets=new Array<Bullet>();
        ore=new Array<Elbrium>();
        bullgen=new BulletGenerator();

        joy2=new Joystick(Main.circle,Main.stickImg,new Point2D(Main.WIDTH-joyX,joyY),joySize);

        ore.add(new Elbrium(Main.circle,new Point2D(Main.WIDTH/2, Main.HEIGHT/3),1));
    }

    public void multitouch(float x,float y,boolean isDownTouch, int pointer){
        //isDownTouch true при нажатии
        for(int i=0;i<5;i++){
            joy.update(x,y,isDownTouch,pointer);
            joy2.update(x,y,isDownTouch,pointer);
        }
    }

    //public static int getJoyX() {return joyX;}

    //public static int getJoyY() {return joyY;}

    public static void setPos(float x, float y){
        realTimeCoords.setPoint(x,y);
    }
    public static Point2D getPos(){
        return realTimeCoords;
    }

}
