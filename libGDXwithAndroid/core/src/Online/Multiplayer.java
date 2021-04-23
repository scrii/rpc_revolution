package Online;

import java.util.ArrayList;

public class Multiplayer {
    ArrayList<String> players;
    DatabaseHelper databaseHelper;

    public Multiplayer(){
        databaseHelper=new DatabaseHelper();
        players=new ArrayList<>();
    }

    public void getPlayers(){

    }
}
