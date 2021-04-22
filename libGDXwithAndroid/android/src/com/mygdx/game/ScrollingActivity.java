package com.mygdx.game;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.text.SpannableString;

import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class ScrollingActivity extends AppCompatActivity {

    public int seconds;
    int experience;
    int real_xp;
    double real_money;
    double money,plus_health,plus_attack;
    int real_sign;
    int level;
    int real_level;
    CountDownTimer countDownTimer;
    GetterANDSetterFile getterANDSetterFile;
    // //
    public Online.Message player_data;
    // //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        getterANDSetterFile = new GetterANDSetterFile();

        // //
        player_data=new Online.Message(getterANDSetterFile.get_Nickname(),-1,-1,
                getterANDSetterFile.get_Guardian_Money(),getterANDSetterFile.get_Ore_Elbrium(),
                getterANDSetterFile.get_Speed(),getterANDSetterFile.get_Attack(),getterANDSetterFile.get_Health(),
                getterANDSetterFile.get_Protection(),"back","front");
        FirebaseDatabase.getInstance().getReference(getterANDSetterFile.get_Nickname()).setValue(player_data.toString());
        // //

        //getterANDSetterFile.set_Guardian_Money(1000000.0);
        real_sign = getterANDSetterFile.get_Sign();
        if(real_sign != 1)startActivity(new Intent(ScrollingActivity.this,EmailPasswordActivity.class));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
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
                }

                @Override
                public void onFinish() {
                    experience = experience + 1;
                    money = money + 1;
                    info_money.setText(money + "");
                    if (experience % 50 == 0) {
                        level = level + 1;
                        info_level.setText(level+"");
                        plus_health = getterANDSetterFile.get_Health();
                        plus_health = plus_health + 5;
                        getterANDSetterFile.set_Health(plus_health);
                        plus_attack = getterANDSetterFile.get_Attack();
                        plus_attack = plus_attack + 5;
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
                startActivity(new Intent(ScrollingActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        int positionOfMenuItem = 0;                                                           //Красный цвет Person в menu_scrolling
        MenuItem item = menu.getItem(positionOfMenuItem);
        SpannableString s = new SpannableString("Пользователь");
        s.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), 0);
        item.setTitle(s);

        MenuItem item2 = menu.getItem(1);                                              //Красный цвет Shop в menu_scrolling
        SpannableString s1 = new SpannableString("Магазин");
        s1.setSpan(new ForegroundColorSpan(Color.RED), 0, s1.length(), 0);
        item2.setTitle(s1);

        MenuItem item3 = menu.getItem(2);                                              //Красный цвет Выход в menu_scrolling
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
        if (id == R.id.exit) { //здесь предствален обработчик нажатия типа setOnClickListener
            new File("/data/data/com.mygdx.game/Sign.txt").delete();
            new File("/data/data/com.mygdx.game/The_core_of_the_second_life.txt").delete();
            new File("/data/data/com.mygdx.game/Jump_into_hyperspace.txt").delete();
            new File("/data/data/com.mygdx.game/Health.txt").delete();
            new File("/data/data/com.mygdx.game/Protection.txt").delete();
            new File("/data/data/com.mygdx.game/Attack.txt").delete();
            new File("/data/data/com.mygdx.game/Speed.txt").delete();
            new File("/data/data/com.mygdx.game/Maneuverability.txt").delete();
            new File("/data/data/com.mygdx.game/Ore_Elbrium.txt").delete();
            new File("/data/data/com.mygdx.game/Message.txt").delete();
            new File("/data/data/com.mygdx.game/guardian_money.txt").delete();
            new File("/data/data/com.mygdx.game/guardian_level.txt").delete();
            new File("/data/data/com.mygdx.game/guardian_exp.txt").delete();
            new File("/data/data/com.mygdx.game/CoefficientAttack.txt").delete();
            new File("/data/data/com.mygdx.game/CoefficientProtection.txt").delete();
            new File("/data/data/com.mygdx.game/CoefficientSpeed.txt").delete();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this,ScrollingActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}