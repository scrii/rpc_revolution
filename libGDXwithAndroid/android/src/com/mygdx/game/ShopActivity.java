package com.mygdx.game;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;


public class ShopActivity extends AppCompatActivity {
    int ore_elbrium;
    int price_ore_elbrium = 3;
    int protection; //защита
    int price_protection = 30;
    int health; //жизнь
    int price_health = 3;
    int speed; //скорость
    int price_speed = 30;
    int attack; //урон
    int price_attack = 10;
    int maneuverability; //манёвренность
    int price_maneuverability = 10;
    Button maneuverability_plus_one,attack_plus_one,protect_plus_one,speed_plus_one,null_number_btn;
    TextView info_health,real_health,info_damage,real_damage,info_protect,real_protect,info_speed,real_speed,info_maneuverability,real_maneuverability,info_attack,real_attack,info_protection,real_protection,info_speed_plus_one,real_speed_pus_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);
        maneuverability_plus_one = findViewById(R.id.maneuverability_plus_one);
        attack_plus_one = findViewById(R.id.attack_plus_one);
        protect_plus_one = findViewById(R.id.protect_plus_one);
        speed_plus_one = findViewById(R.id.speed_plus_one);
        null_number_btn = findViewById(R.id.null_number_btn);
        info_health = findViewById(R.id.info_health);
        real_health = findViewById(R.id.real_health);
        info_damage = findViewById(R.id.info_damage);
        real_damage = findViewById(R.id.real_damage);
        info_protect = findViewById(R.id.info_protect);
        real_protect = findViewById(R.id.real_protect);
        info_speed = findViewById(R.id.info_speed);
        real_speed = findViewById(R.id.real_speed);
        info_maneuverability = findViewById(R.id.info_maneuverability);
        real_maneuverability = findViewById(R.id.real_maneuverability);
        info_attack = findViewById(R.id.info_attack);
        real_attack = findViewById(R.id.real_attack);
        info_protection = findViewById(R.id.info_protection);
        real_protection = findViewById(R.id.real_protection);
        info_speed_plus_one = findViewById(R.id.info_speed_plus_one);
        real_speed_pus_one = findViewById(R.id.real_speed_pus_one);
        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.shop, new SettingsFragment())
                    .commit();
        }
        else Toast.makeText(getApplicationContext(),"Error 1: ShopActivity",Toast.LENGTH_LONG).show();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        else Toast.makeText(getApplicationContext(),"Error 2: ShopActivity",Toast.LENGTH_LONG).show();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            //setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||




}