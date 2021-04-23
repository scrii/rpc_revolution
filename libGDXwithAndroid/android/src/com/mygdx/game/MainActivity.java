package com.mygdx.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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


import Online.DatabaseHelper;
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
    int spaces;
    private static final int NOTIFY_ID = 101;
    TextView word;
    int sec=1;
    CountDownTimer countDownTimer;

    private static String CHANNEL_ID = "Elbrium channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        myListView = findViewById(R.id.listView);
        myListView.isFastScrollEnabled();
        input = findViewById(R.id.editText);
        word = findViewById(R.id.number_of_words_entered);
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
                spaces = s1.length() - s1.replace(" ", "").length();
                if(nickname != null && !s1.equals("") && !s1.contains("\n\n\n\n") && s1.length()!=spaces){
                    if(s1.length()<=550)FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), nickname));
                    else Toast.makeText(getApplicationContext(),"Сообщение слишком большое!",Toast.LENGTH_SHORT).show();
                }
                //else if(!s1.equals("") && !s1.contains("\n\n\n\n\n") && s1.length()!=spaces)FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getEmail()));
                else Toast.makeText(getApplicationContext(),"Сообщение не может быть пустым",Toast.LENGTH_SHORT).show();
                getterANDSetterFile.set_Message(s1);
                input.setText("");
                s1 = input.getText().toString();
                xy = true;
            }
        });
        countDownTimer = new CountDownTimer(sec*10,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sec--;
                count = input.getText().toString().length();
                word.setText(count+"");
            }

            @Override
            public void onFinish() {
                count = input.getText().toString().length();
                word.setText(count+"");
                if (countDownTimer != null){
                    sec = 1;
                    countDownTimer.start();
                }
            }
        };
        if (countDownTimer!=null){
            sec = 1;
            countDownTimer.start();
        }
        displayChat();
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
                    Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                    PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                            0, notificationIntent,
                            PendingIntent.FLAG_CANCEL_CURRENT);

                    NotificationCompat.Builder builder =
                            new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                    .setSmallIcon(R.drawable.ic_launcher_background)
                                    .setContentTitle("Напоминание")
                                    .setContentText("Вас упоминули!")
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                    .setContentIntent(contentIntent);

                    NotificationManagerCompat notificationManager =
                            NotificationManagerCompat.from(MainActivity.this);
                    notificationManager.notify(NOTIFY_ID, builder.build());

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