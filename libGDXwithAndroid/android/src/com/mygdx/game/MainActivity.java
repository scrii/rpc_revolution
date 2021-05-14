package com.mygdx.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.preference.PreferenceFragmentCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    public FirebaseListAdapter<Message> adapter;
    RelativeLayout activity_main;
    ImageButton button;
    String nickname;
    ListView myListView;
    BubbleTextView textMessage;
    boolean xy = true;
    String s,comment,lucky="";
    EditText input;
    String s1;
    double protect,health,attack,speed;
    double elbrium,gold;
    int count=0,k1,k2,g1,g2,n=-1,luck=0,z1,z2,r1,r2,d1,d2,m1,m2,x1=-1,x2=-1,y1=-1,y2=-1;
    String[] words;
    int spaces;
    private static final int NOTIFY_ID = 101;
    TextView word;
    int sec=1;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;
    // //
    GetterANDSetterFile getterANDSetterFile;
    //Online online;
    // //
    private static String CHANNEL_ID = "Elbrium channel";
    // //
    @Override
    protected void onPause() {
        //updateOnline();
        if(getterANDSetterFile.get_SoundMusic()==1)mediaPlayer.pause();
        Log.e("MAINACTIVITY", "PAUSED");
        super.onPause();
    }
    @Override
    protected void onStart(){
        if(getterANDSetterFile.get_SoundMusic()==1)mediaPlayer.start();
        super.onStart();
    }
    // //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.chatsound);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(getterANDSetterFile.get_SoundMusic()==1)mediaPlayer.start();
            }
        });
        myListView = findViewById(R.id.listView);
        myListView.isFastScrollEnabled();
        input = findViewById(R.id.editText);
        word = findViewById(R.id.number_of_words_entered);
        getterANDSetterFile = new GetterANDSetterFile(); //
        //online(0);
        // //
        //online=new Online();
        //online.online(0);
        //online(1);
        // //
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
                luck = (int) (Math.random()*1000);
                Log.d("random_int",luck+"");
                Log.d("random_string",lucky+"");
                if(luck%2==0)lucky = " [Успешно]";
                else lucky = " [Неуспешно]";
                if(nickname != null && !s1.equals("") && !s1.contains("\n\n\n\n") && s1.length()!=spaces && !s1.contains("#try")){
                    if(s1.length()<=550){
                        FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), nickname));
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Сообщение слишком большое!",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(s1.contains("#try"))FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString()+lucky, nickname));
                //else if(!s1.equals("") && !s1.contains("\n\n\n\n\n") && s1.length()!=spaces)FirebaseDatabase.getInstance().getReference("Message").push().setValue(new Message(input.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getEmail()));
                else Toast.makeText(getApplicationContext(),"Сообщение не может быть пустым",Toast.LENGTH_SHORT).show();
                lucky = "";
                luck=0;
                getterANDSetterFile.set_Message(s1);
                Intent playActivity = new Intent(MainActivity.this, AndroidLauncher.class);
                if(s1.contains("#join"))startActivity(playActivity);
                if(s1.contains("#leave"))startActivity(new Intent(MainActivity.this,ScrollingActivity.class));
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
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }
    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            //setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(2131558400 == R.menu.actionbar){
            startActivity(new Intent(MainActivity.this,TableLeader.class));
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                if(s.contains("*") && textMessage.getText().toString().contains("*") && !s.contains("#")) {
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
                if(!s.contains("*")&&!textMessage.getText().toString().contains("*") && s.contains("@"+nickname) || s.contains("@all")){
                    g1 = s.indexOf("@");
                    g2 = nickname.length()+g1;
                    SpannableStringBuilder builder1 = new SpannableStringBuilder();
                    SpannableString colorSpannable1= new SpannableString(s);
                    colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ping)),g1,g2+1,0);
                    builder1.append(colorSpannable1);
                    textMessage.setText(builder1, TextView.BufferType.SPANNABLE);
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
                if(s.contains("@") && !s.contains("@"+nickname))textMessage.setTextColor(getResources().getColor(R.color.ping2));
                if((s.contains("#join") || s.contains("#leave")))textMessage.setTextColor(getResources().getColor(R.color.command1));
                if(s.contains("[Успешно]") && s.contains("#try")){
                    d1 = s.indexOf("#");
                    d2 = s.lastIndexOf("y");
                    z1 = s.indexOf("[");
                    z2 = s.lastIndexOf("]");
                    SpannableStringBuilder builder1 = new SpannableStringBuilder();
                    SpannableString colorSpannable1= new SpannableString(s);
                    colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.True)),z1,z2+1,0);
                    colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.Try)),d1,d2+1,0);
                    if(s.contains("*")){
                        x1 = comment.indexOf("*");
                        x2 = comment.lastIndexOf("*");
                        colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.comment)),x1,x2+1,0);
                    }
                    builder1.append(colorSpannable1);
                    textMessage.setText(builder1, TextView.BufferType.SPANNABLE);
                }
                if(s.contains("[Неуспешно]") && s.contains("#try")){
                    m1 = s.indexOf("#");
                    m2 = s.lastIndexOf("y");
                    r1 = s.indexOf("[");
                    r2 = s.lastIndexOf("]");
                    SpannableStringBuilder builder1 = new SpannableStringBuilder();
                    SpannableString colorSpannable1= new SpannableString(s);
                    colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.False)),r1,r2+1,0);
                    colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.Try)),m1,m2+1,0);
                    if(s.contains("*")){
                        y1 = comment.indexOf("*");
                        y2 = comment.lastIndexOf("*");
                        colorSpannable1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.comment)),y1,y2+1,0);
                    }
                    builder1.append(colorSpannable1);
                    textMessage.setText(builder1, TextView.BufferType.SPANNABLE);
                }
                if(xy){
                    myListView.smoothScrollToPosition(2000000000);
                    xy = false;
                }
            }
        };
        listMessages.setAdapter(adapter);
    }
    // //
    public void updateOnline(String s, int case_){
        switch (case_){
            case 0:FirebaseDatabase.getInstance().getReference("online").onDisconnect().setValue(s.replace(getterANDSetterFile.get_Nickname() + ";", ""));break;
            case 1:FirebaseDatabase.getInstance().getReference("online").setValue(s.replace(getterANDSetterFile.get_Nickname() + ";", ""));break;
            default: break;
        }
    }
    public void online(int case_){
        FirebaseDatabase.getInstance().getReference("online").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                getterANDSetterFile.set_online(snapshot.getValue().toString());
                updateOnline(snapshot.getValue().toString(),case_);
                Log.e("MainAc",getterANDSetterFile.get_Online());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    // //
}