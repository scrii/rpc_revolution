package com.mygdx.game;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class PersonActivity extends AppCompatActivity {
    EditText name_person;
    Button confirm;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //what
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        name_person = findViewById(R.id.name_person);
        confirm = findViewById(R.id.confirm);
        s = name_person.getText().toString();                                //Получение вводимого имени в String (true)
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = name_person.getText().toString();
                if(s!=null)getterANDSetterFile.set_Nickname(s);
                else Toast.makeText(getApplicationContext(),"Никнейм не может быть пустым",Toast.LENGTH_SHORT).show();
            }
        });
        if(s!=null)getterANDSetterFile.set_Nickname(s);
        else Toast.makeText(getApplicationContext(),"Никнейм не может быть пустым",Toast.LENGTH_SHORT).show();
        //===========================================================
        //Запрещено трогать код ниже!!!!!!
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.person, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
    //Не трогать код выше
}