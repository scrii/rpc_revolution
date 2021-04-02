package Online;

import com.google.firebase.database.FirebaseDatabase;
import com.teamname.game.Actor.Player;

public class Online {


    public Online(Player player){

    }


    public void imInTheRoom(){
        // вызывается при заходе в комнате,
        // оповещает других, что игрок в ней
    }


    public void getPlayersData(){
        // вызывается при заходе в комнату
        // как обработчик работает все время,
        // или при получении команды от метода
        // imInTheRoom()

    }

   /* public String getFirebaseInstance(){
        //FirebaseDatabase.getInstance().getReference().push().setValue(new Message(input.getText().toString(), nickname));
        //return FirebaseDatabase.getInstance().getReference()
    }*/

}
