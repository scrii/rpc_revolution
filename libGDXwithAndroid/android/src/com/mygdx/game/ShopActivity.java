package com.mygdx.game;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;


public class ShopActivity extends AppCompatActivity {
    int ore_elbrium;
    int price_ore_elbrium = 3,new_price_ore_elbrium;
    int protection,new_price_protection; //защита
    int price_protection = 30;
    int health; //жизнь
    int price_health = 3;
    int speed,new_price_speed; //скорость
    int price_speed = 30;
    int attack,new_price_attack; //урон
    int price_attack = 10;
    int maneuverability,new_price_maneuverability; //манёвренность
    int price_maneuverability = 10;
    int inverse_health,inverse_attack,inverse_protection,inverse_speed;
    Button maneuverability_plus_one,attack_plus_one,protect_plus_one,speed_plus_one,null_number_btn;
    TextView real_money,real_ore,info_health,real_health,info_damage,real_damage,info_protect,real_protect,info_speed,real_speed,info_maneuverability,real_maneuverability,info_attack,real_attack,info_protection,real_protection,info_speed_plus_one,real_speed_pus_one;
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
        real_ore = findViewById(R.id.real_ore);
        real_money = findViewById(R.id.real_money);

        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();

        real_ore.setText(getterANDSetterFile.get_Ore_Elbrium()+"");
        real_health.setText(getterANDSetterFile.get_Health()+"");
        real_damage.setText(getterANDSetterFile.get_Attack()+"");
        real_protect.setText(getterANDSetterFile.get_Protection()+"");
        real_speed.setText(getterANDSetterFile.get_Speed()+"");
        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");

        maneuverability_plus_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getterANDSetterFile.get_Protection()>=1){
                    new_price_maneuverability = getterANDSetterFile.get_Speed() + price_maneuverability * (getterANDSetterFile.get_Speed() - 10);
                    if(getterANDSetterFile.get_Guardian_Money() - new_price_maneuverability >= 0){
                        real_maneuverability.setText(new_price_maneuverability+"");
                        getterANDSetterFile.set_Speed(getterANDSetterFile.get_Speed()+2);
                        getterANDSetterFile.set_Protection(getterANDSetterFile.get_Protection()-1);
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-new_price_maneuverability);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(),"Ваша защита слишком мала!",Toast.LENGTH_LONG).show();
            }
        });

        attack_plus_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getterANDSetterFile.get_Speed()>=1){
                    new_price_attack = getterANDSetterFile.get_Attack() + price_attack * (getterANDSetterFile.get_Attack() - 10);
                    if(getterANDSetterFile.get_Guardian_Money() - new_price_attack >= 0){
                        real_attack.setText(new_price_attack+"");
                        getterANDSetterFile.set_Attack(getterANDSetterFile.get_Attack()+1);
                        getterANDSetterFile.set_Speed(getterANDSetterFile.get_Speed()-1);
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-new_price_attack);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(),"Ваша скорость слишком мала",Toast.LENGTH_LONG).show();
            }
        });

        protect_plus_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_price_ore_elbrium = price_ore_elbrium * getterANDSetterFile.get_Guardian_Level();
                if(getterANDSetterFile.get_Guardian_Level() < 15){
                    new_price_protection = getterANDSetterFile.get_Protection() + price_protection * (getterANDSetterFile.get_Protection() - 30);
                    if (getterANDSetterFile.get_Guardian_Money() - new_price_protection >= 0){
                        real_protection.setText(new_price_protection+"");
                        getterANDSetterFile.set_Protection(getterANDSetterFile.get_Protection()+1);
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - new_price_protection);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_LONG).show();
                }
                else if (getterANDSetterFile.get_Ore_Elbrium() >= new_price_ore_elbrium){
                    new_price_protection = getterANDSetterFile.get_Protection() + price_protection * (getterANDSetterFile.get_Protection() - 10);
                    if (getterANDSetterFile.get_Guardian_Money() - new_price_protection >= 0){
                        real_protection.setText(new_price_protection+"");
                        getterANDSetterFile.set_Protection(getterANDSetterFile.get_Protection()+1);
                        getterANDSetterFile.set_Ore_Elbrium(getterANDSetterFile.get_Ore_Elbrium() - new_price_ore_elbrium);
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - new_price_protection);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                        real_ore.setText(getterANDSetterFile.get_Ore_Elbrium()+"");
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(),"Недостаточно руды Elbrium. Требуется: "+new_price_ore_elbrium,Toast.LENGTH_LONG).show();
            }
        });

        speed_plus_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getterANDSetterFile.get_Guardian_Level() < 15){
                    new_price_speed = getterANDSetterFile.get_Speed() + price_speed * (getterANDSetterFile.get_Speed() - 30);
                    if (getterANDSetterFile.get_Guardian_Money() >= new_price_speed){
                        real_speed.setText(new_price_speed+"");
                        getterANDSetterFile.set_Speed(getterANDSetterFile.get_Speed()+1);
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - new_price_speed);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_LONG).show();
                }
                else if (getterANDSetterFile.get_Ore_Elbrium() >= new_price_speed){
                    new_price_speed = getterANDSetterFile.get_Speed() + price_speed * (getterANDSetterFile.get_Speed() - 30);
                    if (getterANDSetterFile.get_Guardian_Money() >= new_price_speed){
                        real_speed.setText(new_price_speed+"");
                        getterANDSetterFile.set_Speed(getterANDSetterFile.get_Speed()+1);
                        getterANDSetterFile.set_Ore_Elbrium(getterANDSetterFile.get_Ore_Elbrium() - new_price_speed);
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - new_price_speed);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                        real_ore.setText(getterANDSetterFile.get_Ore_Elbrium()+"");
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(),"Недостаточно руды Elbrium. Требуется: "+new_price_ore_elbrium,Toast.LENGTH_LONG).show();
            }
        });

        null_number_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getterANDSetterFile.get_Speed()!=10 && getterANDSetterFile.get_Attack()!=3 && getterANDSetterFile.get_Health()!=10 && getterANDSetterFile.get_Protection()!=3){
                    if(getterANDSetterFile.get_Health()>10){
                        inverse_health = getterANDSetterFile.get_Health() - 10;
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + price_health*inverse_health);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                        getterANDSetterFile.set_Health(10);
                        real_health.setText(getterANDSetterFile.get_Health()+"");
                    }
                    else{
                        getterANDSetterFile.set_Health(10);
                        real_health.setText(getterANDSetterFile.get_Health()+"");
                    }
                    if(getterANDSetterFile.get_Attack()>3){
                        inverse_attack = getterANDSetterFile.get_Attack() - 3;
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + price_attack * inverse_attack);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                        getterANDSetterFile.set_Attack(3);
                        real_attack.setText(getterANDSetterFile.get_Attack()+"");
                    }
                    else{
                        getterANDSetterFile.set_Attack(3);
                        real_attack.setText(getterANDSetterFile.get_Attack()+"");
                    }
                    if(getterANDSetterFile.get_Protection()>3){
                        inverse_protection = getterANDSetterFile.get_Protection() - 3;
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + price_protection * inverse_protection);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                        getterANDSetterFile.set_Protection(3);
                        real_protection.setText(getterANDSetterFile.get_Protection()+"");
                    }
                    else{
                        getterANDSetterFile.set_Protection(3);
                        real_attack.setText(getterANDSetterFile.get_Protection()+"");
                    }
                    if(getterANDSetterFile.get_Speed()>10){
                        inverse_speed = getterANDSetterFile.get_Speed() - 10;
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + price_speed*inverse_speed);
                        real_money.setText(getterANDSetterFile.get_Guardian_Money()+"");
                        getterANDSetterFile.set_Speed(10);
                        real_speed.setText(getterANDSetterFile.get_Speed()+"");
                    }
                    else{
                        getterANDSetterFile.set_Speed(10);
                        real_speed.setText(getterANDSetterFile.get_Speed()+"");
                    }
                }
            }
        });
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