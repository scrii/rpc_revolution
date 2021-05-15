package com.mygdx.game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TableLeader extends AppCompatActivity {
    ListView listView;
    ArrayList arrayList;
    TextView leader_nickname,leader_elbrium,number;
    FirebaseListAdapter<LeaderBoard> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_leader);
        listView = findViewById(R.id.leaderView);
        arrayList = new ArrayList();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        //Log.d("Database",FirebaseDatabase.getInstance().getReference("LeaderBoard").getParent().toString());
        if(getterANDSetterFile.get_Ore_Elbrium()>0.0)FirebaseDatabase.getInstance().getReference("LeaderBoard").push().setValue(new LeaderBoard(getterANDSetterFile.get_Nickname(),getterANDSetterFile.get_Ore_Elbrium()));
        adapter = new FirebaseListAdapter<LeaderBoard>(TableLeader.this,LeaderBoard.class,R.layout.leader_list, FirebaseDatabase.getInstance().getReference("LeaderBoard")){
            @Override
            protected void populateView(View v, LeaderBoard model, int position) {
                number = v.findViewById(R.id.number);
                leader_nickname = v.findViewById(R.id.name_leader);
                leader_elbrium = v.findViewById(R.id.elbrium_leader);
                number.setText(position+" ");
                leader_nickname.setText(model.getNickname()+" ");
                leader_elbrium.setText(model.getElbrium()+"");
                if(position==0)number.setTextColor(getResources().getColor(R.color.zero));
                if(position>0 && position<=10)number.setTextColor(getResources().getColor(R.color.one_ten));
                if(position>10 && position<=20)number.setTextColor(getResources().getColor(R.color.ten_twenty));
                if(position>20 && position<=30)number.setTextColor(getResources().getColor(R.color.twenty_thirty));
                if(position>30 && position<=40)number.setTextColor(getResources().getColor(R.color.thirty_forty));
                if(position>40 && position<=50)number.setTextColor(getResources().getColor(R.color.forty_fifty));
                if(position>50 && position<=60)number.setTextColor(getResources().getColor(R.color.fifty_sixty));
                if(position>60 && position<=70)number.setTextColor(getResources().getColor(R.color.sixty_seventy));
                if(position>70 && position<=80)number.setTextColor(getResources().getColor(R.color.seventy_ninety));
                if(position>80 && position<=90)number.setTextColor(getResources().getColor(R.color.ninety_one_hundred));
                if(position>90)number.setTextColor(getResources().getColor(R.color.other));
                number.setTextSize(21);
                leader_nickname.setTextSize(21);
                leader_elbrium.setTextSize(21);
            }
        };
        listView.setAdapter(adapter);

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