package Online;

import com.google.gson.Gson;

public class FirebaseReader {
    DatabaseHelper databaseHelper;
    Gson gson;
    public FirebaseReader(){
        databaseHelper=new DatabaseHelper();
        gson = new Gson();
    }

    public Message getMessage(String ref){
        return gson.fromJson("{"+databaseHelper.readString(ref), Message.class);
    }
}
