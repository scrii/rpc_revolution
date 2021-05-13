package com.mygdx.game;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.os.CountDownTimer;
import android.text.SpannableString;

import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

import FirebaseHelper.Message;
import FirebaseHelper.Online;

public class ScrollingActivity extends AppCompatActivity {

    public int seconds,k=1;
    int experience;
    int real_xp;
    double real_money;
    double money,plus_health,plus_attack;
    int real_sign;
    int level;
    int real_level;
    CountDownTimer countDownTimer;
    GetterANDSetterFile getterANDSetterFile;
    FrameLayout frameLayout;
    // //
    public Message player_data;
    Online online;
    // //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        k=1;
        getterANDSetterFile = new GetterANDSetterFile(); //
        frameLayout = findViewById(R.id.gg);
        //nestedScrollView.setBackgroundResource(R.drawable.ic_launcher);

        // //
        //online(-1);
        player_data=new Message(getterANDSetterFile.getTexture(),-1,-1,(float)getterANDSetterFile.get_Attack(),
                (float)getterANDSetterFile.get_Health(),(float)getterANDSetterFile.get_Protection());
        FirebaseDatabase.getInstance().getReference("LONGDATA").push().setValue(player_data.toString());
        online=new Online();
        //online.online(0);
        // //
        real_sign = getterANDSetterFile.get_Sign();
        if(real_sign != 1)startActivity(new Intent(ScrollingActivity.this,EmailPasswordActivity.class));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        //toolBarLayout.setTitle(getterANDSetterFile.get_Nickname());
        TextView info_level = findViewById(R.id.level);
        TextView info_money = findViewById(R.id.money);
        Button room1  = findViewById(R.id.room_one_button);
        seconds = 60;
        experience = 0;
        money = 0;
        level = 0;
        real_money = getterANDSetterFile.get_Guardian_Money();
        real_xp = getterANDSetterFile.get_Guardian_Exp();
        real_level = getterANDSetterFile.get_Guardian_Level();
        experience = real_xp;
        money = real_money;
        level = real_level;
        info_money.setText(getterANDSetterFile.get_Guardian_Money() + "");
        info_level.setText(getterANDSetterFile.get_Guardian_Level()+"");
            countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    seconds--;
                    info_money.setText(getterANDSetterFile.get_Guardian_Money() + "");
                    info_level.setText(getterANDSetterFile.get_Guardian_Level()+"");
                    toolBarLayout.setTitle(getterANDSetterFile.get_Nickname());
                    if(getterANDSetterFile.get_StartChat()==1){
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        getterANDSetterFile.set_StartChat(0);
                    }
                }
                @Override
                public void onFinish() {
                    toolBarLayout.setTitle(getterANDSetterFile.get_Nickname());
                    experience = experience + 1;
                    money = money + 1;
                    info_money.setText(money + "");
                    if (experience % 50 == 0) {
                        level = level + 1;
                        info_level.setText(level+"");
                        plus_health = getterANDSetterFile.get_Health();
                        plus_health = plus_health + 4;
                        getterANDSetterFile.set_Health(plus_health);
                        plus_attack = getterANDSetterFile.get_Attack();
                        plus_attack = plus_attack + 0.5;
                        getterANDSetterFile.set_Attack(plus_attack);
                    }
                    getterANDSetterFile.set_Guardian_Money(money);
                    getterANDSetterFile.set_Guardian_Exp(experience);
                    getterANDSetterFile.set_Guardian_Level(level);
                    if (countDownTimer != null){
                        seconds = 60;
                        countDownTimer.start();
                    }
                }
            };
            if (countDownTimer!=null){
                seconds = 60;
                countDownTimer.start();
            }

        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this,AndroidLauncher.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        int positionOfMenuItem = 0;                                                           //Красный цвет Person в menu_scrolling
        MenuItem item = menu.getItem(positionOfMenuItem);
        SpannableString s = new SpannableString("Настройки");
        s.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), 0);
        item.setTitle(s);

        MenuItem item2 = menu.getItem(1);                                              //Красный цвет Shop в menu_scrolling
        SpannableString s1 = new SpannableString("Магазин");
        s1.setSpan(new ForegroundColorSpan(Color.RED), 0, s1.length(), 0);
        item2.setTitle(s1);

        MenuItem item4 = menu.getItem(2);
        SpannableString s3 = new SpannableString("О нас");
        s3.setSpan(new ForegroundColorSpan(Color.RED), 0, s3.length(), 0);
        item4.setTitle(s3);

        MenuItem item3 = menu.getItem(3);                                              //Красный цвет Выход в menu_scrolling
        SpannableString s2 = new SpannableString("Выход");
        s2.setSpan(new ForegroundColorSpan(Color.RED), 0, s2.length(), 0);
        item3.setTitle(s2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_person){
            startActivity(new Intent(this,PersonActivity.class));
            return true;
        }
        if(id == R.id.shop){
            startActivity(new Intent(ScrollingActivity.this,ShopActivity.class));
            return true;
        }
        if(id == R.id.about_us_menu){
            startActivity(new Intent(ScrollingActivity.this,About_us.class));
            return true;
        }
        if (id == R.id.exit) { //здесь предствален обработчик нажатия типа setOnClickListener
            GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
            getterANDSetterFile.set_Guardian_Money(0.0);
            getterANDSetterFile.set_Guardian_Exp(0);
            getterANDSetterFile.set_Guardian_Level(0);
            getterANDSetterFile.set_Sign(0);
            getterANDSetterFile.set_Ore_Elbrium(0.0);
            getterANDSetterFile.set_Coefficient_Attack(0);
            getterANDSetterFile.set_Coefficient_Protection(0);
            getterANDSetterFile.set_Coefficient_Speed(0);
            getterANDSetterFile.set_Health(10.0);
            getterANDSetterFile.set_Attack(3.0);
            getterANDSetterFile.set_Protection(3.0);
            getterANDSetterFile.set_Speed(3.0);
            new File("/data/data/com.mygdx.game/Maneuverability.txt").delete();
            new File("/data/data/com.mygdx.game/Message.txt").delete();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this,ScrollingActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // //
    public void online(int case_){
        FirebaseDatabase.getInstance().getReference("online").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                getterANDSetterFile.set_online(snapshot.getValue().toString());
                Log.e("ScrollingAc",getterANDSetterFile.get_Online());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    // //
}