package com.teamname.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import FirebaseHelper.DatabaseHelper;
import FirebaseHelper.Multiplayer;
import Tools.GetterANDSetterFile;
import Tools.Spawner;
import com.teamname.game.Screens.GameSc;
import com.teamname.game.Screens.MenuSc;

//import Online.Getter;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;


public class Main extends Game {
	public static SpriteBatch batch,frontBatch,playerBatch,other;
	public Texture img;
	public static int WIDTH,HEIGHT;
	public static Texture circle,stickImg,background,actor,damaged_txr;

	public static int BACKGROUND_WIDTH;
	public static int BACKGROUND_HEIGHT;
	public static Texture un_testButtonTX,p_testButtonTX;

	private GetterANDSetterFile getter_setter;
	DatabaseHelper db;

	Multiplayer mp;





	public Main() {
	}




	@Override
	public void create () {
		GdxFIRApp.inst().configure();
//		GdxFIRDatabase.instance().inReference("coords_"+GameSc.player.nickname).push().setValue("none ahaha");
		//getter=new Getter();
		//getter.sendToFirebase(new Message("234","43"));
		batch = new SpriteBatch();
		frontBatch=new SpriteBatch();
		playerBatch=new SpriteBatch();
		other=new SpriteBatch();
		WIDTH= Gdx.graphics.getWidth();
		HEIGHT=Gdx.graphics.getHeight();
		circle=new Texture("circle.png");
		stickImg=new Texture("stick.png");
		actor=new Texture("actor.png");
		//GdxFIRDatabase.instance().inReference("heading").setValue("msg");
		background=new Texture("testlocation.png");
		BACKGROUND_WIDTH=background.getWidth();
		BACKGROUND_HEIGHT=background.getHeight();
		db=new DatabaseHelper();
		damaged_txr=new Texture("dameged_txr_elbrium.png");
		un_testButtonTX=new Texture("test_button_un_pressed.png");
		p_testButtonTX=new Texture("test_button_pressed.png");


		//mp=new Multiplayer();
		//mp.getPlayers();

		monitoring();

		setScreen(new GameSc(this));
	}


	@Override
	public void dispose () {
		batch.dispose();
		frontBatch.dispose();
		playerBatch.dispose();
		circle.dispose();
		stickImg.dispose();
		actor.dispose();
		background.dispose();

		getter_setter=new GetterANDSetterFile();
		GdxFIRDatabase.instance().inReference(getter_setter.get_Nickname()).removeValue();
		un_testButtonTX.dispose();
		p_testButtonTX.dispose();
	}

	public void monitoring(){
		Gdx.app.addLifecycleListener(new LifecycleListener() {
			@Override
			public void pause() {
				Gdx.app.error("Main","paused");
			}

			@Override
			public void resume() {
				Gdx.app.error("Main","res");
			}

			@Override
			public void dispose() {
				db.logOut();
				Gdx.app.error("Main","dispose");
			}
		});
	}
}
