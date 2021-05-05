package FirebaseHelper;

import com.badlogic.gdx.Gdx;

//<!!!---> import de.tomgrill.gdxfirebase.core.GDXFirebase;

public class PlayerDataCollect {

    //количестве игроков, возможно, стоит закинуть их под общее поле
    FirebaseHelper.DatabaseHelper databaseHelper;
    String pos;

    public PlayerDataCollect() {
        databaseHelper = new DatabaseHelper();pos="none";
    }

    public void getPosition(String ref){

        //<!!!---> Gdx.app.log("aaaa", GDXFirebase.FirebaseDatabase("final-server-bf945-default-rtdb").getReference("scri").getKey());
    //Promise<Message> m = GdxFIRDatabase.inst().inReference(ref).readValue(Message.class);
       /* Gdx
        GdxFIRDatabase.inst().inReference("").
        GdxFIRDatabase.inst().inReference(ref).readValue(Message.class).
            @Override
            public void accept(Message s) {
                Gdx.app.log("aaa",s.x+"");
            }
        });*/
        //Gdx.app.log("promise",m.toString());
        /*.then(new Consumer<Message>() {
            @Override
            public void accept(Message message) {
                Gdx.app.log("firebase_log",message.x+" "+message.y);
            }
        });*/
       /* GdxFIRDatabase.inst().inReference(ref).readValue(Message.class).then(new Consumer<Message>() {
            @Override
            public void accept(Message message) {
                Gdx.app.log("firebase_log",message.x+" "+message.y);
            }
        });*/
        /*
        * GdxFIRDatabase.inst()
            .inReference("/employee-fred")
            .readValue(Employee.class)
            .then(new Consumer<Employee>() {
                @Override
                public void accept(Employee s) {

                }
            });*/
    }

    /*class DatabaseListenExample {

    @Override
    void action() {
        ListenerPromise<String> listener = GdxFIRDatabase.inst()
                .inReference("/some-ref")
                .onDataChange(String.class)
                .after(GdxFIRAuth.inst().signInAnonymously())
                .thenListener(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        Gdx.app.log("App", "new value: " + s);
                    }
                });
        // ....
        // you can cancel it later
        listener.cancel();
    }

}*/


/*
    public Message getPlayerData(String reference) {
        //return databaseHelper.
    }*/

  /*  public Message getPlayerData() {

    }*/
  /*  public String getPosition(String reference){

        GdxFIRDatabase.inst().inReference(reference).readValue(Message.class).then(new Consumer<Message>() {
            @Override
            public void accept(Message message) {
                pos=String.valueOf(message.x);
            }
        });
        return pos;
    }*/
}

/*@Override
    void action() {
        GdxFIRDatabase.inst()
            .inReference("/employee-fred")
            .readValue(Employee.class)
            .then(new Consumer<Employee>() {
                @Override
                public void accept(Employee s) {
*/
