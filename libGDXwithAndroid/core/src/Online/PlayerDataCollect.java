package Online;

import com.badlogic.gdx.Gdx;

import java.awt.event.MouseWheelEvent;

import Tools.Point2D;
import de.tomgrill.gdxfirebase.core.database.DataSnapshot;
import de.tomgrill.gdxfirebase.core.database.DatabaseError;
import de.tomgrill.gdxfirebase.core.database.ValueEventListener;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRAuth;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.GdxFIRStorage;
import pl.mk5.gdx.fireapp.annotations.MapConversion;
import pl.mk5.gdx.fireapp.functional.Consumer;
import pl.mk5.gdx.fireapp.promises.ListenerPromise;
import pl.mk5.gdx.fireapp.promises.Promise;

public class PlayerDataCollect {
    // опрашивать сервер о количестве игроков, возможно, стоит закинуть их под общее поле
    DatabaseHelper databaseHelper;
    String pos;

    public PlayerDataCollect() {
        databaseHelper = new DatabaseHelper();pos="none";
    }

    public void getPosition(final String ref) {

        GdxFIRDatabase.inst().inReference(ref).readValue(Message.class).then(new Consumer<Message>() {
            @Override
            public void accept(Message message) {

            }
        });

    }
                        //logPosition(pos);

                        /*  public void readValue(String reference){
        Message temp;
        DatabaseDistribution mDB = GdxFIRDatabase.instance().inReference(reference);
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Message fromFirebase = ds.getValue(Message.class);
                    assert fromFirebase != null;

                    Gdx.app.log("COORDS!",fromFirebase.x+" "+fromFirebase.y);
                }
            }*/







    public void logPosition(String pos){
        Gdx.app.log("FIREBASE",pos);
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
