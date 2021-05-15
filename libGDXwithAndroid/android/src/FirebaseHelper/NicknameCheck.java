package FirebaseHelper;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class NicknameCheck {

    private boolean flag=false;
    private String tmp="";

    public NicknameCheck(){}

//    public boolean check(String s){
//
//        FirebaseDatabase.getInstance().getReference("Nicknames").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//                if(snapshot.getValue()!=null&&snapshot.getValue().toString().contains(s))flag=true;
//            }
//
//            @Override
//            public void onCancelled(@NonNull @NotNull DatabaseError error) {
//
//            }
//        });
//
//        return flag;
//    }
//
//    public String getVal(){
//        FirebaseDatabase.getInstance().getReference("Nicknames").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//                if(snapshot.getValue()!=null)tmp=snapshot.getValue().toString();
//            }
//
//            @Override
//            public void onCancelled(@NonNull @NotNull DatabaseError error) {
//
//            }
//        });
//
//        return tmp;
//
//    }
//
//    public void upload(String s){
//        String tmp = getVal();
//        if(!tmp.contains(s))FirebaseDatabase.getInstance().getReference("Nicknames").push().setValue(tmp+" "+s);
//    }

}
