package com.mygdx.game;

import android.os.Bundle;
import android.view.MenuItem;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);

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