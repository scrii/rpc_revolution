package Online;

import com.badlogic.gdx.Gdx;

import java.awt.event.MouseWheelEvent;

import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRAuth;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.GdxFIRStorage;
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

    public void getPosition(String ref){

        Promise<Message> listener = GdxFIRDatabase.inst()
                .inReference(ref)
                .onDataChange(Message.class)
                .after(GdxFIRAuth.inst().signInAnonymously())
                .then(new Consumer<Message>() {

                          @Override
                          public void accept(Message message) {
                              Gdx.app.log("COORDS", message.x + " " + message.y);
                          }
                      });
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
