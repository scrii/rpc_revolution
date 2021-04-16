package com.teamname.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Tools.Spawner;
import com.teamname.game.Screens.GameSc;
import com.teamname.game.Screens.MenuSc;

//import Online.Getter;
import pl.mk5.gdx.fireapp.GdxFIRApp;


public class Main extends Game {
	public static SpriteBatch batch;
	public Texture img;
	public static int WIDTH,HEIGHT;
	public static Texture circle,stickImg,background,actor;

	public static int BACKGROUND_WIDTH;
	public static int BACKGROUND_HEIGHT;






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
		//GdxFIRDatabase.instance().inReference("heading").setValue("msg");
		background=new Texture("testlocation.png");
		BACKGROUND_WIDTH=background.getWidth();
		BACKGROUND_HEIGHT=background.getHeight();
		setScreen(new GameSc(this));
	}


	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
