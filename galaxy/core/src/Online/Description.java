package Online;

import com.badlogic.gdx.Gdx;
import com.teamname.game.Actor.Player;

import de.tomgrill.gdxfirebase.core.GDXFirebase;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Description {
    public DatabaseHelper databaseHelper;
    public String nickname;

    public Description(Player player){
        nickname = player.nickname;
        databaseHelper=new DatabaseHelper();
    }

    public void getPosition(){

    }

    public void playerInitialization(){
        //entryNotify();
        //addField();
        GdxFIRDatabase.instance().inReference("players").push().setValue(nickname);
        databaseHelper.addField("players","field");
        GdxFIRDatabase.instance().setValue("Reference tipo");
        GdxFIRDatabase.instance().inReference("Reference tipo").push().setValue("Field navernoe");
    }

    public void test(){
        /*GdxFIRDatabase.instance().inReference("TEST_scri").setValue("32131 23");
        GdxFIRDatabase.instance().inReference("TEST_scri").setValue("32131 23");
        GdxFIRDatabase.instance().inReference("TEST_scri").push().inReference("chego").setValue("nichego");
        GdxFIRDatabase.instance().inReference("TEST_scri").push().setValue(new Message("author","-11","22"));*/
        GdxFIRApp.inst().configure();
        GDXFirebase.FirebaseDatabase().goOnline();
        /*if (!FirebaseApp.getApps(this).isEmpty())
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);*/
        GdxFIRApp.instance()

        GDXFirebase.FirebaseDatabase().setPersistenceEnabled(true);
        GDXFirebase.FirebaseDatabase().getReference("TEST_scri").push().setValue("0o");

        GdxFIRDatabase.instance().inReference("AAAAA").readValue()
        /*ListView listMessages = findViewById(R.id.listView);
adapter = new FirebaseListAdapter<Message>(MainActivity.this, Message.class, R.layout.list_item, FirebaseDatabase.getInstance().getReference(nickname)) {

@Override
protected void populateView(View v, Message model, int position) {
TextView author;
textMessage = v.findViewById(R.id.tvMessage);
,,,,
listMessages.setAdapter(adapter);

}*/

    }

}
