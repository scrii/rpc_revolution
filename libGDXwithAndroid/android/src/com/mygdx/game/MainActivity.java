package com.mygdx.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.github.library.bubbleview.BubbleTextView;
import com.google.firebase.database.FirebaseDatabase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

public class MainActivity extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    public FirebaseListAdapter<Message> adapter;
    RelativeLayout activity_main;
    ImageButton button;
    String nickname; //
    ListView myListView;
    BubbleTextView textMessage;
    boolean xy = true; //34
    String s,comment,text_notify;
    EditText input;
    String s1;
    double protect,health,attack,speed;
    double elbrium,gold;
    int count=0,k1,k2,g1,g2,n=-1,p=0;
    String[] words,mas;
    int spaces,int_mas=0;
    TextView word;
    int sec=1,z=1;
    CountDownTimer countDownTimer;
    GetterANDSetterFile getterANDSetterFile;

    public String time_string="";
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";



    @Override
    protected void onDestroy() {
        Log.d("MAINACTIVITY","KILLED");
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        myListView = findViewById(R.id.listView);
        myListView.isFastScrollEnabled();
        input = findViewById(R.id.editText);
        word = findViewById(R.id.number_of_words_entered);
        getterANDSetterFile = new GetterANDSetterFile();
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
                    if(s1.length()<=550){
                        FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), nickname));
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Сообщение слишком большое!",Toast.LENGTH_SHORT).show();
                    }
                }
                else Toast.makeText(getApplicationContext(),"Сообщение не может быть пустым",Toast.LENGTH_SHORT).show();
                getterANDSetterFile.set_Message(s1);
                input.setText("");
                s1 = input.getText().toString();
                xy = true;
            }
        });
        final Toast toast = Toast.makeText(getApplicationContext(),"Вы превысили ограничение!",Toast.LENGTH_SHORT);
        countDownTimer = new CountDownTimer(sec*10,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sec--;
                count = input.getText().toString().length();
                word.setText(count+"");
                if(count>550){
                    word.setTextColor(Color.RED);
                    n=1;
                    toast.show();
                }
                else {
                    n=0;
                    toast.cancel();
                    word.setTextColor(getResources().getColor(R.color.grey_500));
                }
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
                comment = textMessage.getText().toString();
                if(s.contains("*") && textMessage.getText().toString().contains("*")) {
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '*' && s.contains("*")) {
                            kolvo_symbols++;
                            if (kolvo_symbols == 2 && s.contains("*")) {
                                k1 = comment.indexOf("*");
                                k2 = comment.lastIndexOf("*");
                                SpannableStringBuilder builder = new SpannableStringBuilder();
                                SpannableString colorSpannable= new SpannableString(s);
                                colorSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.comment)),k1,k2+1,0);
                                builder.append(colorSpannable);
                                textMessage.setText(builder, TextView.BufferType.SPANNABLE);
                                kolvo_symbols = 0;
                                s = "";
                            }
                            else textMessage.setTextColor(getResources().getColor(R.color.white));
                        }
                    }
                }
                else textMessage.setTextColor(getResources().getColor(R.color.white));
                words = s.split(" ");
                if(!s.contains("*")&&!textMessage.getText().toString().contains("*") && s.contains("@"+nickname)){
                    g1 = s.indexOf("@");
                    g2 = nickname.length()+g1;
                    SpannableStringBuilder builder1 = new SpannableStringBuilder();
                    SpannableString colorSpannable1= new SpannableString(s);
                    colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ping)),g1,g2+1,0);
                    builder1.append(colorSpannable1);
                    textMessage.setText(builder1, TextView.BufferType.SPANNABLE);

                    //Уведомления
                    Date currentDate = new Date();
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                    String timeText = timeFormat.format(currentDate);
                    if(timeText.contains(timeFormat.format(model.getMessageTime()+1000)+"") || timeText.contains(timeFormat.format(model.getMessageTime()+2000)+""))p=1;
                    else p=0;
                    Log.d("Time_m1",timeText);
                    Log.d("Time_m2",model.getMessageTime()+"");
                    if(p==1){
                        notificationManager = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                        NotificationCompat.Builder notificationBuilder =
                                new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID)
                                        .setAutoCancel(false)
                                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                                        .setWhen(System.currentTimeMillis())
                                        .setContentIntent(pendingIntent)
                                        .setContentTitle("Последнее упоминание")
                                        .setContentText(author.getText().toString() + ": " + textMessage.getText().toString())
                                        .setPriority(PRIORITY_HIGH);
                        createChannelIfNeeded(notificationManager);
                        notificationManager.notify(NOTIFY_ID,notificationBuilder.build());
                    }
                    //Уведомления
                    s = "";
                }
                else if(!s.contains("*")&&!textMessage.getText().toString().contains("*"))textMessage.setTextColor(getResources().getColor(R.color.white));
                if(s.contains("@") && !s.contains("@"+nickname))textMessage.setTextColor(getResources().getColor(R.color.ping2));
                if(xy){
                    myListView.smoothScrollToPosition(2000000000);
                    xy = false;
                }
            }
        };
        listMessages.setAdapter(adapter);

    }
    public static void createChannelIfNeeded(NotificationManager manager){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,CHANNEL_ID,NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}