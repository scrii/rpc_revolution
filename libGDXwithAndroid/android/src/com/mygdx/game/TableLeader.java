package com.mygdx.game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class TableLeader extends AppCompatActivity {
    ListView listView;
    FirebaseListAdapter<LeaderBoard> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_leader);
        listView = findViewById(R.id.leaderView);
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        FirebaseDatabase.getInstance().getReference("LeaderBoard").push().setValue(new LeaderBoard(getterANDSetterFile.get_Nickname(),getterANDSetterFile.get_Ore_Elbrium()));
        adapter = new FirebaseListAdapter<LeaderBoard>(TableLeader.this,LeaderBoard.class,R.layout.leader_list, FirebaseDatabase.getInstance().getReference("LeaderBoard")) {
            @Override
            protected void populateView(View v, LeaderBoard model, int position) {
                TextView leader_nickname = v.findViewById(R.id.name_leader);
                TextView leader_elbrium = v.findViewById(R.id.elbrium_leader);
                leader_nickname.setText(model.getNickname());
                //leader_elbrium.setText(model.getElbrium());
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