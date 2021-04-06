package com.teamname.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Screens.MenuSc;
import com.teamname.game.Screens.SpaceSc;
import Online.DatabaseHelper;
import pl.mk5.gdx.fireapp.GdxFIRApp;

public class Main extends Game {
	public static SpriteBatch batch;
	public static int WIDTH,HEIGHT;
	public static int BACKGROUND_WIDTH,BACKGROUND_HEIGHT;
	public static Texture circle,stickImg,background,actor;
	public DatabaseHelper databaseHelper;


	public Main() {
	}

	@Override
	public void create () {
		GdxFIRApp.inst().configure();
		databaseHelper=new DatabaseHelper();

		//databaseHelper.playerInitialization();
		batch = new SpriteBatch();
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();

		circle=new Texture("circle.png");
		stickImg=new Texture("stick.png");
		actor=new Texture("actor.png");
		background=new Texture("largebackground.jpg");
		BACKGROUND_WIDTH=background.getWidth();
		BACKGROUND_HEIGHT=background.getHeight();


		setScreen(new SpaceSc(this));
	}


	@Override
	public void dispose () {
		batch.dispose();
	}
}
