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
	public static SpriteBatch batch,frontBatch,playerBatch,hudBatch;
	public Texture img;
	public static int WIDTH,HEIGHT;
	public static Texture circle,stickImg,background,actor,damaged_txr,deathSc,elbrium,elbriumCrash;

	public static Texture err;
	public static Texture ore1,ore2,ore3,ore4,ore5;
	public static Texture player1, player2, player3, player4, player5;

	public static int BACKGROUND_WIDTH;
	public static int BACKGROUND_HEIGHT;
	public static Texture un_testButtonTX,p_testButtonTX;

	public static GameSc gameSc;

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
		hudBatch=new SpriteBatch();
		WIDTH= Gdx.graphics.getWidth();
		HEIGHT=Gdx.graphics.getHeight();

		err=new Texture("error.png");

		circle=new Texture("circle.png");
		stickImg=new Texture("stick.png");
		actor=new Texture("actor.png");
		//GdxFIRDatabase.instance().inReference("heading").setValue("msg");
		background=new Texture("testlocation.jpg");
		BACKGROUND_WIDTH=background.getWidth();
		BACKGROUND_HEIGHT=background.getHeight();
		db=new DatabaseHelper();
		damaged_txr=new Texture("dameged_txr_elbrium.png");
		un_testButtonTX=new Texture("test_button_un_pressed.png");
		p_testButtonTX=new Texture("test_button_pressed.png");
		deathSc=new Texture("deathSc.jpg");
		elbrium=new Texture("ore.png");

		loadElbriumTextures();
		loadPlayerTextures();
		gameSc=new GameSc(this);

		//mp=new Multiplayer();
		//mp.getPlayers();

		monitoring();

		setScreen(gameSc);
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
				//db.logOut();
				Gdx.app.error("Main","dispose");
			}
		});
	}

	private void loadElbriumTextures(){
		ore1=new Texture(Gdx.files.internal("elbrium/ore1.png"));
		ore2=new Texture(Gdx.files.internal("elbrium/ore2.png"));
		ore3=new Texture(Gdx.files.internal("elbrium/ore3.png"));
		ore4=new Texture(Gdx.files.internal("elbrium/ore4.png"));
		ore5=new Texture(Gdx.files.internal("elbrium/ore5.png"));
		elbriumCrash=new Texture("elbrium/orecrash.png");
	}

	private void loadPlayerTextures(){
		player1=new Texture("players/player1.png");
		/*player2=new Texture("players/player2.png");
		player3=new Texture("players/player3.png");
		player4=new Texture("players/player4.png");
		player5=new Texture("players/player5.png");*/
	}
}
