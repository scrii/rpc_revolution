package Online;

import com.badlogic.gdx.Gdx;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


import Tools.Point2D;
import de.tomgrill.gdxfirebase.core.GDXFirebase;
//import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.functional.Consumer;

public class DatabaseHelper {


    String toLogs;
    //DatabaseReference reference = GDXFirebase.FirebaseDatabase().getReference("storetest");
    //String key = reference.push().getKey();
    //reference.child(key).setValue("some value");

    public DatabaseHelper(){
        toLogs="NONE";
    }

    public void sendToFirebase(String heading, String msg){
        GdxFIRDatabase.instance().inReference(heading).push().setValue(msg);
    }

    public void removeFromFirebase(String reference){
        GdxFIRDatabase.instance().inReference(reference).removeValue();
    }

   /* public void entryNotify(int roomNumber){
        sendToFirebase("room"+roomNumber+"_"+nickname,"Connected");
    }*/

    public void addField(String reference, String field){
        GdxFIRDatabase.instance().inReference(reference).inReference(field).setValue(field);
    }

    public void changeFieldValue(String reference,String field, String value){
        GdxFIRDatabase.instance().inReference(reference).setValue(field);
    }









    public void sendCoords(String email, float x, float y){
        GDXFirebase.FirebaseDatabase().getReference(email).child("coordinats_x").setValue(x);
        GDXFirebase.FirebaseDatabase().getReference(email).child("coordinats_y").setValue(y);
        //GDXFirebase.FirebaseDatabase().




        //GDXFirebase.FirebaseDatabase().getReference("email").child("coordinats_y").setValue(y+"");
        /*GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(x);
        GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(y);*/
    }

/*    public void setNickname(String nickname){
        this.nickname=nickname;
    }*/

    public void readValue(){
        GdxFIRDatabase.inst().inReference("scriii").readValue(Message.class).then(new Consumer<Message>() {
            @Override
            public void accept(Message message) {
                toLogs=message.
            }


        });
    }

}
