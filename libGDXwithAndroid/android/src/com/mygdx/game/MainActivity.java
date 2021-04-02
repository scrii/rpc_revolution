package com.mygdx.game;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.github.library.bubbleview.BubbleTextView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.Constants;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import Tools.Point2D;

public class MainActivity extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    public FirebaseListAdapter<Message> adapter;
    RelativeLayout activity_main;
    Button button;
    String nickname;
    ListView myListView;
    BubbleTextView textMessage;
    boolean xy = true; //34
    String s;
    boolean delete_me = true;
    float x = 1,y = 1;
    EditText input;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        myListView = findViewById(R.id.listView);
        myListView.isFastScrollEnabled();
        input = findViewById(R.id.editText);
        //=====================================================================
        String myData36 = "";
        File myExternalFile36 = new File("/data/data/com.mygdx.game/nickname.txt");
        try {
            FileInputStream fis36 = new FileInputStream(myExternalFile36);
            DataInputStream in36 = new DataInputStream(fis36);
            BufferedReader br36 = new BufferedReader(new InputStreamReader(in36));

            String strLine36;
            while ((strLine36 = br36.readLine()) != null) {
                myData36 = myData36 + strLine36;
                Log.d("File? ",myData36);
                nickname = myData36;
            }
            br36.close();
            in36.close();
            fis36.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=====================================================================
        activity_main = findViewById(R.id.activity_main);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = input.getText().toString(); //
                Log.d("String",s1);
                if(nickname != null && !s1.equals(" ")||!s1.equals(""))FirebaseDatabase.getInstance().getReference(nickname).push().setValue(new Message(input.getText().toString(), nickname,x,y)); //изменено
                else if(!s1.equals(" ")||!s1.equals(""))FirebaseDatabase.getInstance().getReference(FirebaseAuth.getInstance().getCurrentUser().getEmail()).push().setValue(new Message(input.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getEmail(),x,y));
                input.setText("");
                //if(nickname != null && !s1.equals(" ")||!s1.equals(""))FirebaseDatabase.getInstance().getReference(nickname).push().setValue(new Message(input.getText().toString(), nickname,x,y)); //изменено
                //                else if(!s1.equals(" ")||!s1.equals(""))FirebaseDatabase.getInstance().getReference(FirebaseAuth.getInstance().getCurrentUser().getEmail()).push().setValue(new Message(input.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getEmail(),x,y));
                s1 = input.getText().toString();
                Log.d("String",s1);
                xy = true;
            }
        });
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .build(), SIGN_IN_REQUEST_CODE);
        } else {
            displayChat();
        }
        try {

//            String key = FirebaseDatabase.getInstance().getReference(nickname).getKey();
//            Log.d("TAG",key);
//            FirebaseDatabase.getInstance().getReference(nickname).child("coordinats_x").setValue(10);

//            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference(nickname);
//            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//            rootRef.child("coordinats_x").setValue(353);

        }catch (Exception e){
            e.printStackTrace();
        }


        final Intent playActivity = new Intent(this, AndroidLauncher.class);

        Button play = findViewById(R.id.start);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(playActivity);
            }
        });
    }


    private void displayChat() {

        ListView listMessages = findViewById(R.id.listView);
        adapter = new FirebaseListAdapter<Message>(MainActivity.this, Message.class, R.layout.list_item, FirebaseDatabase.getInstance().getReference(nickname)) {

            @Override
            protected void populateView(View v, Message model, int position) {
                TextView author;
                textMessage = v.findViewById(R.id.tvMessage);
                author = v.findViewById(R.id.tvUser);
                textMessage.setText(model.getTextMessage());
                author.setText(model.getAutor());
                if(nickname == author.getText().toString()){
                    author.setTextColor(getResources().getColor(R.color.user));
                    myListView.smoothScrollToPosition(2000000000);
                }
                else author.setTextColor(getResources().getColor(R.color.user2));
                int kolvo_symbols = 0;
                s = textMessage.getText().toString();
                if(s.contains("*") && textMessage.getText().toString().contains("*")) {
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '*' && s.contains("*")) {
                            kolvo_symbols++;
                            if (kolvo_symbols == 2 && s.contains("*")) {
                                textMessage.setTextColor(getResources().getColor(R.color.comment));
                                kolvo_symbols = 0;
                                s = "";
                            }
                            else textMessage.setTextColor(getResources().getColor(R.color.white));
                        }
                    }
                }
                else textMessage.setTextColor(getResources().getColor(R.color.white));
                //timeMessage.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getTimeMessage()));
                if(xy){
                    myListView.smoothScrollToPosition(2000000000);
                    xy = false;
                }
            }
        };
        listMessages.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                Snackbar.make(activity_main, "Вход выполнен", Snackbar.LENGTH_SHORT).show();
                displayChat();
            } else {
                Snackbar.make(activity_main, "Вход не выполнен", Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }
    }


}