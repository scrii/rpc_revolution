package FirebaseHelper;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Multiplayer {
    ArrayList<String> meta_players;
    DatabaseHelper databaseHelper;
    String valueOf_online;

    public Multiplayer(){
        databaseHelper=new DatabaseHelper();
        meta_players=new ArrayList<>();
    }

    public void getPlayers(){
        databaseHelper.getP();
        valueOf_online=databaseHelper.getValueOf_online();
        Gdx.app.error("Multiplayer Manager","valueOf_online: "+valueOf_online);
    }
}
