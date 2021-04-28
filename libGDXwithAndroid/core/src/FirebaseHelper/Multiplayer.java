package FirebaseHelper;

import java.util.ArrayList;

public class Multiplayer {
    ArrayList<String> players;
    FirebaseHelper.DatabaseHelper databaseHelper;

    public Multiplayer(){
        databaseHelper=new DatabaseHelper();
        players=new ArrayList<>();
    }

    public void getPlayers(){

    }
}
