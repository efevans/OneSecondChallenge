package com.mygdx.osc;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.mygdx.osc.playerdata.GlobalPlayerData;

public class OneSecondChallenge extends Game implements ApplicationListener {
	
	@Override
	public void create () 
	{
		// load assets and initialize any data here
		GlobalPlayerData.initPlayerData();
		Assets.load();
		
		setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void dispose() 
	{
//		super.dispose();
	}
}
