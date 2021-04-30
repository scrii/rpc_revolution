package com.teamname.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.google.gson.Gson;
import com.teamname.game.Actor.Bullet;
import com.teamname.game.Actor.Elbrium;
import com.teamname.game.Actor.Player;
import com.teamname.game.Main;
//import com.


import FirebaseHelper.DatabaseHelper;
//import Online.Getter;
import FirebaseHelper.Message;
import Tools.BulletGenerator;
import Tools.Buttons;
import Tools.GetterANDSetterFile;
import Tools.Joystick;
import Tools.Point2D;
import Tools.Spawner;

public class GameSc implements Screen {


    Joystick joy,joy2;
    public static Player player;
    Sprite sprite=new Sprite(Main.background);
    public static OrthographicCamera camera;
    static Point2D realTimeCoords=new Point2D(0,0);

    public static Array<Bullet> bullets;
    public static Array<Elbrium> ore;
    private Spawner spawner;
    private Gson gson;

    Buttons testButton;
    BulletGenerator bullgen;
    String test;
    Message tst;

    //PlayerDataCreator playerData;



    private int joyX=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private int joyY=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private int joySize = Main.HEIGHT/3;
    //private int X_realTimeCoords=Main.WIDTH;
    //private int Y_realTimeCoords=Main.HEIGHT;


    private static final int entityRad = Main.HEIGHT/20;
    private static final int entityX=Main.WIDTH/2;
    private static final int entityY=Main.WIDTH/3;

    public static final float player_x=Main.WIDTH/2-100;
    public static final float player_y=Main.HEIGHT/2-50;
    String online_players;
    GetterANDSetterFile getter_setter;

/*    private static final float leftSide = ;
    private static final float rightSide;
    private static final float upSide;
    private static final float downSide = ;*/
    // ресурсы подгружаются с класса Main



    Main main;
    public DatabaseHelper databaseHelper;

    /*public GameSc(PlatformStuff stuff) {
        this.stuff = stuff;
    }*/

    public GameSc(Main main){
        this.main=main;
        spawner=new Spawner();
        gson=new Gson();
        loadActors();
        databaseHelper=new DatabaseHelper();
        getter_setter=new GetterANDSetterFile();
        //databaseHelper.setNickname(player.nickname);
        //databaseHelper.entryNotify();
        camera=new OrthographicCamera(Main.WIDTH,Main.HEIGHT);
        testButton=new Buttons(Main.un_testButtonTX,Main.p_testButtonTX,
                300, 300, 500, 500);
        databaseHelper.readString(0);
       // databaseHelper.acceptString("online");
 // //      if(databaseHelper.readString()==null || databaseHelper.readString().length() == 0)databaseHelper.sendToFirebase("online",getter_setter.get_Nickname());
     //   else databaseHelper.sendToFirebase("online",databaseHelper.readString()+";"+getter_setter.get_Nickname());
        //return str == null || str.length() == 0;

        //camera=new OrthographicCamera(Main.WIDTH*3f,Main.HEIGHT*3f);
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
        backRender(Main.batch);


        // сплюсовать радиусы для отображения игрока ровно в центре
        // руда - batch
        Main.batch.end();

        Main.frontBatch.begin();
        Main.frontBatch.setColor(1,1,1,1);
        frontRender(Main.frontBatch);

        testButton.draw(Main.frontBatch,Gdx.input.getX(),Main.HEIGHT-Gdx.input.getY());
        if(testButton.isButtonTouch(Gdx.input.getX(),Main.HEIGHT-Gdx.input.getY())){
            //databaseHelper.acceptString(getter_setter.get_Nickname());
           // databaseHelper.entryNotify();
           //databaseHelper.acceptString("scri");

            databaseHelper.collectPlayer(getter_setter.get_Nickname());

            //tst.logIt("final_s", tst.toString());

            /*GdxFIRDatabase.instance().inReference("gson_test").readValue(String.class)
                    .then(new Consumer<String>() {
                              @Override
                              public void accept(String s) {
                                  Gdx.app.log("gson",s);
                                  test=s;
                                  Gdx.app.log("gson1", gson.fromJson("{"+test, Test.class).x+"");
                              }
                          });*/



        }


        Main.frontBatch.end();

        Main.playerBatch.begin();
        Main.playerBatch.setColor(0,0,1,1);
        Main.playerBatch.draw(Main.actor,player_x,player_y,100,100);
        playerRender(Main.playerBatch);

        Main.playerBatch.end();



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
        //databaseHelper.entryNotify();
    }

    public void GameUpdate(){
        player.setDirection(joy.getDir());

        player.update();
        bullgen.update(joy2);
        for(int i=0;i<bullets.size;i++){bullets.get(i).update();bullets.get(i).setCount(i);if(bullets.get(i).isOut){bullets.get(i).removeBullet(i);}}
        for(int i=0;i<ore.size;i++){ore.get(i).update();ore.get(i).setCount(i);if(ore.get(i).isOut){ore.get(i).removeElbrium(i);}}



        // send in online
    }

    public void frontRender(SpriteBatch frontBatch){

        joy.draw(frontBatch);
        joy2.draw(frontBatch);

    }

    public void playerRender(SpriteBatch playerRender){

        player.draw(playerRender);

    }

    public void backRender(SpriteBatch batch){

        for(int i=0;i<bullets.size;i++)bullets.get(i).draw(batch);
        for(int i=0;i<ore.size;i++)ore.get(i).draw(batch);

    }

    public void loadActors(){

        //FileHandle file = Gdx.files.absolute("nickname.txt");
        //String name = file.readString();
        // //
        // // //


        player =new Player("SCRI" ,Main.actor,new Point2D(entityX,entityY),5,entityRad,20);
        //getter.setPlayer(player);
        joy=new Joystick(Main.circle,Main.stickImg,new Point2D(joyX,joyY),joySize);


        ore=new Array<Elbrium>();
        bullgen=new BulletGenerator();

        joy2=new Joystick(Main.circle,Main.stickImg,new Point2D(Main.WIDTH-joyX,joyY),joySize);
        bullets=new Array<Bullet>();
        spawner.start();

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
