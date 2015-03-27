package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameScreen implements Screen 
{
	
	enum WinState
	{
		TIMING,
		WONLAST,
		LOSTLAST,
		NOTPLAYED
	}
	
	private OneSecondChallenge game;
	private Stage stage;
	private static WinState winState;
	
	public GameScreen(OneSecondChallenge game)
	{
		this.game = game;
	}

	@Override
	public void show() 
	{
		winState = WinState.NOTPLAYED;
		stage = new Stage();
		stage.addActor(new HoldArea());
		stage.addActor(new CurrentScore(new Skin(Gdx.files.internal("skins/uiskin.json"))));
		
		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void render(float delta) 
	{
		setDisplay(winState);
		stage.act(delta);
		stage.draw();
	}
	
	private void setDisplay(WinState winState)
	{
		switch (winState)
		{
		case TIMING:
			Gdx.gl.glClearColor(0, 0, 1.0f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			break;
		case WONLAST:
			Gdx.gl.glClearColor(0, 1.0f, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			break;
		case LOSTLAST:
			Gdx.gl.glClearColor(1.0f, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			break;
		case NOTPLAYED:
			Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			break;
		}
	}

	static public WinState getState()
	{
		return winState;
	}
	
	static public void setState(WinState state)
	{
		winState = state;
	}

	@Override
	public void resize(int width, int height) 
	{

		
	}

	@Override
	public void pause() 
	{

		
	}

	@Override
	public void resume() 
	{

		
	}

	@Override
	public void hide() 
	{

		
	}
	
	@Override
	public void dispose() 
	{


	}

}
