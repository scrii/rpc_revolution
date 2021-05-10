package FirebaseHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.gson.Gson;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.ArrayList;
import java.util.Arrays;

import Tools.GetterANDSetterFile;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.functional.Consumer;

public class Multiplayer {
    ArrayList<Message> players;
    DatabaseHelper databaseHelper;
    String valueOf_online;
    GetterANDSetterFile gs;
    ArrayList<String> meta_players;
    Gson gson;

    public Multiplayer(){
        meta_players=new ArrayList<>();
        databaseHelper=new DatabaseHelper();
        players=new ArrayList<>();
        gs=new GetterANDSetterFile();
        gson=new Gson();
        startListener();
    }

    public void getPlayers(){

        Gdx.app.error("Multiplayer Manager","valueOf_online: "+gs.get_Online());
    }

    public boolean isSomeoneIN(){
        return !players.isEmpty();
    }

    public void draw(SpriteBatch batch){
        for(Message m : players){
            //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.draw(Main.player1,m.x,m.y, GameSc.player.R*2,2*GameSc.player.R);
        }
    }

    private void startListener(){
        GdxFIRDatabase.instance().inReference("online").onDataChange(String.class).thenListener(new Consumer<String>() {
            @Override
            public void accept(String s) {
                tmp(s);
            }
        });
    }

    private void tmp(String s){
        valueOf_online=s;
        meta_players.clear();
        players.clear();
        meta_players.addAll(Arrays.asList(valueOf_online.split(";")));
        meta_players.remove(gs.get_Nickname());
        //Gdx.app.error("MP",meta_players.toString()+"");
        for(String ref : meta_players)createPlayers(ref);
        Gdx.app.error("MP",players.toString());
    }

    private void createPlayers(String ref){
        GdxFIRDatabase.instance().inReference(ref).onDataChange(String.class).thenListener(new Consumer<String>() {
            @Override
            public void accept(String s) {
                  tmp2(s);
            }
        });
    }

    private void tmp2(String s){
        players.add(gson.fromJson("{"+s,Message.class));
    }



}
