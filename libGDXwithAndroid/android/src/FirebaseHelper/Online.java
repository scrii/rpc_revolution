package FirebaseHelper;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mygdx.game.GetterANDSetterFile;
import com.teamname.game.Actor.Player;

public class Online {
    GetterANDSetterFile getter_setter;

    public Online(){
        getter_setter=new GetterANDSetterFile();
    }


    public void online(int case_){
        // 0 - удалить игрока из поля online

        switch (case_){
            case -1:break;
            case 0: FirebaseDatabase.getInstance().getReference("online").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.getValue()!=null)tmp_online(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });break;
        }
    }

    private void tmp_online(String s){
        if(s.contains(getter_setter.get_Nickname()))
            FirebaseDatabase.getInstance().getReference("online").setValue(s.replace(getter_setter.get_Nickname()+";",""));
    }


}
