package FirebaseHelper;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

import Tools.GetterANDSetterFile;

public class Multiplayer {
    ArrayList<String> meta_players;
    DatabaseHelper databaseHelper;
    String valueOf_online;
    GetterANDSetterFile gs;

    public Multiplayer(){
        databaseHelper=new DatabaseHelper();
        meta_players=new ArrayList<>();
        gs=new GetterANDSetterFile();
    }

    public void getPlayers(){

        Gdx.app.error("Multiplayer Manager","valueOf_online: "+gs.get_Online());
    }
}
