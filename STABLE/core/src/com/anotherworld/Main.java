package com.anotherworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anotherworld.Screens.MenuSc;

public class Main extends Game {
	public static SpriteBatch batch;
	public Texture img;
	public static int WIDTH,HEIGHT;
	public static Texture circle,actor,background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		WIDTH= Gdx.graphics.getWidth();
		HEIGHT=Gdx.graphics.getHeight();
		circle=new Texture("circle.png");
		actor=new Texture("actor.png");
		background=new Texture("testlocation.png");
		setScreen(new MenuSc(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
