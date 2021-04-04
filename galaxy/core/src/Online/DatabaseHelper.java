package Online;

import com.badlogic.gdx.Gdx;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


import de.tomgrill.gdxfirebase.core.GDXFirebase;
//import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class DatabaseHelper {

    String nickname;
    //DatabaseReference reference = GDXFirebase.FirebaseDatabase().getReference("storetest");
    //String key = reference.push().getKey();
    //reference.child(key).setValue("some value");

    public DatabaseHelper(){
    }

    public void sendToFirebase(String heading, String msg){
        GdxFIRDatabase.instance().inReference(heading).push().setValue(msg);
    }

    public void removeFromFirebase(String reference){
        GdxFIRDatabase.instance().inReference(reference).removeValue();
    }

    public void entryNotify(int roomNumber){
        sendToFirebase("room"+roomNumber+"_"+nickname,"Connected");
    }

    public void addField(String reference, String field){
        GdxFIRDatabase.instance().inReference(reference).push().setValue(field);
    }

    public void changeFieldValue(String reference,String field, String value){
        GdxFIRDatabase.instance().inReference(reference).inReference(field).setValue(value);
    }

    public void playerInitialization(){
        //entryNotify();
        //addField();
        GdxFIRDatabase.instance().inReference("players").push().setValue(nickname);
        GdxFIRDatabase.instance().inReference("players").inReference(nickname).push().setValue("prikol");
    }





    public void sendCoords(String email, float x, float y){
        GDXFirebase.FirebaseDatabase().getReference(email).child("coordinats_x").setValue(x);
        GDXFirebase.FirebaseDatabase().getReference(email).child("coordinats_y").setValue(y);
        //GDXFirebase.FirebaseDatabase().




        //GDXFirebase.FirebaseDatabase().getReference("email").child("coordinats_y").setValue(y+"");
        /*GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(x);
        GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(y);*/
    }

    public void setNickname(String nickname){
        this.nickname=nickname;
    }

}
