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
    String s;
    EditText input;
    String s1, color_front = "red", color_background = "blue";
    double x = 0,y = 0;
    int protect,health,attack,speed;
    float elbrium,gold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        myListView = findViewById(R.id.listView);
        myListView.isFastScrollEnabled();
        input = findViewById(R.id.editText);
        //=====================================================================
        String myData1 = "";
        File myExternalFile1 = new File("/data/data/com.mygdx.game/Protection.txt");
        try {
            FileInputStream fis1 = new FileInputStream(myExternalFile1);
            DataInputStream in1 = new DataInputStream(fis1);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
            String strLine1;
            while ((strLine1 = br1.readLine()) != null) {
                myData1 = myData1 + strLine1;
                protect = Integer.parseInt(myData1);
            }
            br1.close();in1.close();fis1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=====================================================================
        String myData2 = "";
        File myExternalFile2 = new File("/data/data/com.mygdx.game/Health.txt");
        try {
            FileInputStream fis2 = new FileInputStream(myExternalFile2);
            DataInputStream in2 = new DataInputStream(fis2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            String strLine2;
            while ((strLine2 = br2.readLine()) != null) {
                myData2 = myData2 + strLine2;
                health = Integer.parseInt(myData2);
            }
            br2.close();in2.close();fis2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=====================================================================
        String myData3 = "";
        File myExternalFile3 = new File("/data/data/com.mygdx.game/Attack.txt");
        try {
            FileInputStream fis3 = new FileInputStream(myExternalFile3);
            DataInputStream in3 = new DataInputStream(fis3);
            BufferedReader br3 = new BufferedReader(new InputStreamReader(in3));
            String strLine3;
            while ((strLine3 = br3.readLine()) != null) {
                myData3 = myData3 + strLine3;
                attack = Integer.parseInt(myData3);
            }
            br3.close();in3.close();fis3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=====================================================================
        String myData4 = "";
        File myExternalFile4 = new File("/data/data/com.mygdx.game/Speed.txt");
        try {
            FileInputStream fis4 = new FileInputStream(myExternalFile4);
            DataInputStream in4 = new DataInputStream(fis4);
            BufferedReader br4 = new BufferedReader(new InputStreamReader(in4));
            String strLine4;
            while ((strLine4 = br4.readLine()) != null) {
                myData4 = myData4 + strLine4;
                speed = Integer.parseInt(myData4);
            }
            br4.close();in4.close();fis4.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=======================================================================
        String myData5 = "";
        File myExternalFile5 = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            FileInputStream fis5 = new FileInputStream(myExternalFile5);
            DataInputStream in5 = new DataInputStream(fis5);
            BufferedReader br5 = new BufferedReader(new InputStreamReader(in5));
            String strLine5;
            while ((strLine5 = br5.readLine()) != null) {
                myData5 = myData5 + strLine5;
                gold = Integer.parseInt(myData5);
            }
            br5.close();in5.close();fis5.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=======================================================================
        String myData6 = "";
        File myExternalFile6 = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        try {
            FileInputStream fis6 = new FileInputStream(myExternalFile6);
            DataInputStream in6 = new DataInputStream(fis6);
            BufferedReader br6 = new BufferedReader(new InputStreamReader(in6));
            String strLine6;
            while ((strLine6 = br6.readLine()) != null) {
                myData6 = myData6 + strLine6;
                elbrium = Integer.parseInt(myData6);
            }
            br6.close();in6.close();fis6.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=======================================================================
        String myData36 = "";
        File myExternalFile36 = new File("/data/data/com.mygdx.game/nickname.txt");
        try {
            FileInputStream fis36 = new FileInputStream(myExternalFile36);
            DataInputStream in36 = new DataInputStream(fis36);
            BufferedReader br36 = new BufferedReader(new InputStreamReader(in36));

            String strLine36;
            while ((strLine36 = br36.readLine()) != null) {
                myData36 = myData36 + strLine36;
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
        File file10 = new File("/data/data/com.mygdx.game/Message.txt");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = input.getText().toString();
                try {
                    PrintWriter printWriter10 = new PrintWriter(file10);
                    printWriter10.write(String.valueOf(s1));
                    printWriter10.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if(nickname != null && !TextUtils.isEmpty(input.getText()) ||!s1.equals(""))FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), nickname));
                else if(!s1.equals(" ")||!s1.equals("") && !TextUtils.isEmpty(input.getText()))FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getEmail()));
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