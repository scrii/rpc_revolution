package com.mygdx.game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.FirebaseDatabase;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import Online.PlayerDataCreator;

public class MainActivity extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    public FirebaseListAdapter<Message> adapter;
    RelativeLayout activity_main;
    Button button;
    String nickname;
    ListView myListView;
    BubbleTextView textMessage;
    boolean xy = true; //34
    String s,ping;
    EditText input;
    String s1;
    double x = 0,y = 0;
    double protect,health,attack,speed;
    double elbrium,gold;
    int count=0,k;
    String[] words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        myListView = findViewById(R.id.listView);
        myListView.isFastScrollEnabled();
        input = findViewById(R.id.editText);
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        protect = getterANDSetterFile.get_Protection();
        health = getterANDSetterFile.get_Health();
        attack = getterANDSetterFile.get_Attack();
        speed = getterANDSetterFile.get_Speed();
        gold = getterANDSetterFile.get_Guardian_Money();
        elbrium = getterANDSetterFile.get_Ore_Elbrium();
        nickname = getterANDSetterFile.get_Nickname();
        activity_main = findViewById(R.id.activity_main);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = input.getText().toString();
                for(k=0;k<s1.length();k++)count++;
                getterANDSetterFile.set_Message(s1);
                if(count<=100 && nickname != null && !TextUtils.isEmpty(input.getText()) ||!s1.equals(""))FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), nickname));
                else if(count<=100 && !s1.equals(" ")||!s1.equals("") && !TextUtils.isEmpty(input.getText()))FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getEmail()));
                else Toast.makeText(getApplicationContext(),"Превышено ограничение символов!",Toast.LENGTH_SHORT).show();
                input.setText("");
                s1 = input.getText().toString();
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
        adapter = new FirebaseListAdapter<Message>(MainActivity.this, Message.class, R.layout.list_item, FirebaseDatabase.getInstance().getReference("Message")) {

            @Override
            protected void populateView(View v, Message model, int position) {
                TextView author;
                textMessage = v.findViewById(R.id.tvMessage);
                author = v.findViewById(R.id.tvUser);
                textMessage.setText(model.getTextMessage());
                author.setText(model.getAuthor());
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
                words = s.split(" ");
                if(!s.contains("*")&&!textMessage.getText().toString().contains("*") && words[0].equals("@"+nickname)){
                    textMessage.setTextColor(getResources().getColor(R.color.ping));
                    s = "";
                }
                else if(!s.contains("*")&&!textMessage.getText().toString().contains("*"))textMessage.setTextColor(getResources().getColor(R.color.white));
                if(s.contains("@") && !words[0].equals("@"+nickname))textMessage.setTextColor(getResources().getColor(R.color.ping2));

                if(xy){
                    myListView.smoothScrollToPosition(2000000000);
                    xy = false;
                }
            }
        };
        listMessages.setAdapter(adapter);

    }
}