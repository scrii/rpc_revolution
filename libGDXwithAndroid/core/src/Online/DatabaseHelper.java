package Online;

import com.badlogic.gdx.Gdx;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


import Tools.Point2D;
import de.tomgrill.gdxfirebase.core.FirebaseLoader;
import de.tomgrill.gdxfirebase.core.GDXFirebase;
//import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
import de.tomgrill.gdxfirebase.core.database.DataSnapshot;
import de.tomgrill.gdxfirebase.core.database.DatabaseError;
import de.tomgrill.gdxfirebase.core.database.FirebaseDatabase;
import de.tomgrill.gdxfirebase.core.database.ValueEventListener;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.distributions.DatabaseDistribution;

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

    public void playerDataUpdate(String nickname, Message msg){
        GdxFIRDatabase.instance().inReference(nickname).push().setValue(msg);
    }





    public void sendCoords(String email, float x, float y){
        GDXFirebase.FirebaseDatabase().getReference(email).child("coordinats_x").setValue(x);
        GDXFirebase.FirebaseDatabase().getReference(email).child("coordinats_y").setValue(y);




        //GDXFirebase.FirebaseDatabase().getReference("email").child("coordinats_y").setValue(y+"");
        /*GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(x);
        GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(y);*/
    }

    public void setNickname(String nickname){
        this.nickname=nickname;
    }

    public void updateValues(String reference, Message msg){
        GdxFIRDatabase.instance().inReference(reference).setValue(msg);
    }
    // <!-- -->
    /*public Message readValue(){
        GdxFIRDatabase.instance().inReference()
    }*/

    //public Point2D getPosition()

    public void readValue(String reference){
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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            
        };
        //FirebaseDatabase fDB = GdxFIRDatabase.instance().inReference(reference).;
        }
        //GDXFirebase.FirebaseDatabase().getReference(reference).addValueEventListener(vListener);
        //Gdx.app.log("READED_PL_DATA",GdxFIRDatabase.instance().inReference(reference).readValue(Message.class).toString());
    }


