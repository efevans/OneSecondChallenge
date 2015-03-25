package com.mygdx.osc;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OneSecondChallenge extends Game implements ApplicationListener {
	
	@Override
	public void create () 
	{
		// load assets and initialize any data here
//		setScreen(new GameScreen(this));
		setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void dispose() 
	{
//		super.dispose();
	}
}
