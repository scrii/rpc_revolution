package Online;

import com.google.firebase.encoders.*;
import com.teamname.game.Actor.Player;
import com.teamname.game.Screens.GameSc;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.auth.GdxFirebaseUser;

public class Getter {
    Player player;
    // Point2D position;
    public Getter(){
        //GdxFIRDatabase.instance().inReference("getter was created").push().setValue("player created");
    }

    public void firebaseInitialization(){
        //GdxFIRApp.inst().configure();
    }




    public void sendCOORDStoFirebase(String coords){

        GdxFIRDatabase.instance().inReference("coords_"+GameSc.player.nickname).push().setValue(coords);
        GdxFIRDatabase.instance().inReference("coords_"+GameSc.player.nickname).removeValue();
        //GdxFIRDatabase.instance().inReference().push()
        //FirebaseDatabase.getInstance().getReference().push().setValue(new Message(input.getText().toString(), nickname));
    }

    public void sendToFirebase(Message msg){

        GdxFIRDatabase.instance().inReference("Game").push().setValue(msg);
        GdxFIRDatabase.instance().inReference("Game").removeValue();
        //GdxFIRDatabase.instance().inReference().push()
        //FirebaseDatabase.getInstance().getReference().push().setValue(new Message(input.getText().toString(), nickname));
    }

    public void setPlayer(Player player){
        this.player=player;
    }

    public Point2D getPlayerPosition() {
        return player.send_in_ONLINE;
    }
}
