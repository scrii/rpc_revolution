package com.mygdx.game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class About_us extends AppCompatActivity {
TextView pr,pr_text,com,j,j_text,l,l_text,an,an_text,a,a_text,e,e_text,bags_tv;
String text,prehistory,prehistory_txt,commands,join,join_txt,leave,leave_txt,an_nickname,an_nickname_txt,all,all_txt,example,example_text,bags,copy_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        pr = findViewById(R.id.prehistory);
        pr_text = findViewById(R.id.prehistory_text);
        com = findViewById(R.id.commands);
        j = findViewById(R.id.join);
        j_text = findViewById(R.id.join_text);
        l = findViewById(R.id.leave);
        l_text = findViewById(R.id.leave_text);
        an = findViewById(R.id.another_nickname);
        an_text = findViewById(R.id.another_nickname_text);
        a = findViewById(R.id.all);
        a_text = findViewById(R.id.all_text);
        e = findViewById(R.id.example);
        e_text = findViewById(R.id.example_text);
        bags_tv = findViewById(R.id.bags);
        prehistory = "Предыстория";
        prehistory_txt = "(текст)";
        commands = "Команды";
        join = "#join ";
        join_txt = "– вход в космическое пространство.";
        leave = "#leave ";
        leave_txt = "– вернуться в главное меню.";
        an_nickname = "@чужой_ник ";
        an_nickname_txt = "– упоминание пользователя.";
        all = "@all ";
        all_txt = "– упоминание всех пользователей.";
        example = "*текст* ";
        example_text = "– комментирование текста в случайном месте.";
        bags = "Нашли баг? Напишите нам: ";
        copy_txt = "sup.alone.port@gmail.com";
        pr.setText(prehistory);
        pr_text.setText(prehistory_txt + "\n");
        com.setText(commands);
        j.setText(join);
        j.setTextColor(getResources().getColor(R.color.command1));
        j_text.setText(join_txt+"\n");
        l.setText(leave);
        l.setTextColor(getResources().getColor(R.color.command1));
        l_text.setText(leave_txt+"\n");
        an.setText(an_nickname);
        an.setTextColor(getResources().getColor(R.color.ping2));
        an_text.setText(an_nickname_txt+"\n");
        a.setText(all);
        a.setTextColor(getResources().getColor(R.color.ping));
        a_text.setText(all_txt+"\n");
        e.setText(example);
        e.setTextColor(getResources().getColor(R.color.comment));
        e_text.setText(example_text+"\n\n");
        bags_tv.setText(bags + copy_txt);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.aboutUs, new About_us.SettingsFragment())
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
    }