package com.teamname.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Screens.GameSc;
import com.teamname.game.Screens.MenuSc;

//import Online.Getter;
import Online.Message;
import Online.PlayerDataCollect;
import Online.Reader;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;


public class Main extends Game {
	public static SpriteBatch batch;
	public Texture img;
	public static int WIDTH,HEIGHT;
	public static Texture circle,stickImg,background,actor;
	public MenuSc menu;
	boolean flag=false;
	public static Reader reader;

	//Getter getter;



	public Main() {
	}




	@Override
	public void create () {
		GdxFIRApp.inst().configure();
//		GdxFIRDatabase.instance().inReference("coords_"+GameSc.player.nickname).push().setValue("none ahaha");
		//getter=new Getter();
		//getter.sendToFirebase(new Message("234","43"));
		batch = new SpriteBatch();
		WIDTH= Gdx.graphics.getWidth();
		HEIGHT=Gdx.graphics.getHeight();
		circle=new Texture("circle.png");
		stickImg=new Texture("stick.png");
		actor=new Texture("actor.png");
		background=new Texture("testlocation.png");
		/*playerDataCollect=new PlayerDataCollect();
		playerDataCollect.getPosition();*/

		reader.getValue();

		setScreen(new GameSc(this));
	}


	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
