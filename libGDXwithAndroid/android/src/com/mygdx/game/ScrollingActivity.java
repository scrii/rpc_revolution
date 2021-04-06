package com.mygdx.game;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.text.SpannableString;

import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ScrollingActivity extends AppCompatActivity{

    public int file_change_checking_system_experience = 1;
    public int seconds;
    int experience;
    int real_xp;
    int real_money;
    int money;
    int real_sign;
    int level;
    int real_level;
    int mathematical_sequence_xp_to_level;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        //==================================
        String myData9 = "";
        File myExternalFile9 = new File("/data/data/com.mygdx.game/Sign.txt");
        try {
            FileInputStream fis9 = new FileInputStream(myExternalFile9);
            DataInputStream in9 = new DataInputStream(fis9);
            BufferedReader br9 = new BufferedReader(new InputStreamReader(in9));

            String strLine9;
            while ((strLine9 = br9.readLine()) != null) {
                myData9 = myData9 + strLine9;
                real_sign = Integer.parseInt(myData9);
            }
            br9.close();
            in9.close();
            fis9.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(real_sign != 1)startActivity(new Intent(ScrollingActivity.this,EmailPasswordActivity.class));

        CreatorFiles sd = new CreatorFiles();
        sd.create();

        //==================================
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
        //Чтение из файла money
        String myData1 = "";
        File myExternalFile1 = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            FileInputStream fis1 = new FileInputStream(myExternalFile1);
            DataInputStream in1 = new DataInputStream(fis1);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));

            String strLine1;
            while ((strLine1 = br1.readLine()) != null) {
                myData1 = myData1 + strLine1;
                real_money = Integer.parseInt(myData1);
            }
            br1.close();
            in1.close();
            fis1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Чтение из файла money

        //Чтение из файла xp
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/guardian_exp.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_xp = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Чтение из файла xp
        //Чтение из файла level
        String myData6 = "";
        File myExternalFile6 = new File("/data/data/com.mygdx.game/guardian_level.txt");
        try {
            FileInputStream fis6 = new FileInputStream(myExternalFile6);
            DataInputStream in6 = new DataInputStream(fis6);
            BufferedReader br6 = new BufferedReader(new InputStreamReader(in6));

            String strLine6;
            while ((strLine6 = br6.readLine()) != null) {
                myData6 = myData6 + strLine6;
                real_level = Integer.parseInt(myData6);
            }
            br6.close();
            in6.close();
            fis6.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Чтение из файла level

        //Создание таймера
        experience = real_xp;
        money = real_money;
        level = real_level;
        mathematical_sequence_xp_to_level = 50;
        if (file_change_checking_system_experience == 1) {
            countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    seconds--;
                    info_money.setText(money + "");
                    info_level.setText(level+"");
                }

                @Override
                public void onFinish() {
                    experience = experience + 1;
                    money = money + 1;
                    info_money.setText(money + "");
                    if (experience % 50 == 0) {
                        level = level + 1;
                        info_level.setText(level+"");
                    }

                    //Сохранение money в файл
                    File file5 = new File("/data/data/com.mygdx.game/guardian_money.txt");
                    Log.d(file5.exists() + "", "true!");
                    try {
                        if (!file5.exists()) file5.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        PrintWriter printWriter5 = new PrintWriter(file5);
                        printWriter5.write(String.valueOf(money));
                        printWriter5.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    //Сохранение money в файл
                    //Сохранение xp в файл
                    File file1 = new File("/data/data/com.mygdx.game/guardian_exp.txt");
                    Log.d(file1.exists() + "", "true!");
                    try {
                        if (!file1.exists()) file1.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        PrintWriter printWriter1 = new PrintWriter(file1);
                        printWriter1.write(String.valueOf(experience));
                        printWriter1.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    //Сохранение xp в файл

                    //Сохранение файла--------------------------------------------------------------------------
                    File file = new File("/data/data/com.mygdx.game/guardian_level.txt");
                    Log.d(file.exists() + "","true!");
                    try {
                        if(!file.exists())file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        PrintWriter printWriter = new PrintWriter(file);
                        printWriter.write(String.valueOf(level));
                        printWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    //Сохранение файла--------------------------------------------------------------------------
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
        }
        //Создание таймера

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

        MenuItem item3 = menu.getItem(2);                                              //Красный цвет Settings в menu_scrolling
        SpannableString s2 = new SpannableString("Настройки");
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
            startActivity(new Intent(this,ShopActivity.class));
            return true;
        }
        if (id == R.id.action_settings) { //здесь предствален обработчик нажатия типа setOnClickListener
            startActivity(new Intent(this,SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

