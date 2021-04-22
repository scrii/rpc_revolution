package com.mygdx.game;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.firebase.database.FirebaseDatabase;
import com.teamname.game.Main;

import Online.PlayerDataCreator;
import Tools.Point2D;

public class AndroidLauncher extends AndroidApplication {
	private FirebaseDatabase firebaseDatabase;
	private PlayerDataCreator data;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		firebaseDatabase = FirebaseDatabase.getInstance("https://final-server-bf945-default-rtdb.firebaseio.com/");
		initialize(new Main(), config);

	}
}
