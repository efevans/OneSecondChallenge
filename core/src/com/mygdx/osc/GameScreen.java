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
	
	// personal objects
	private Stage stage;
	private static WinState winState;
	
	// class interface objects
	HoldArea holdArea;
	CurrentScore currentScore;
	
	public GameScreen(OneSecondChallenge game)
	{
		this.game = game;
	}

	@Override
	public void show() 
	{
		winState = WinState.NOTPLAYED;
		stage = new Stage();
		holdArea = new HoldArea(this);
		currentScore = new CurrentScore(new Skin(Gdx.files.internal("skins/uiskin.json")));
		stage.addActor(holdArea);
		stage.addActor(currentScore);
		
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

	public WinState getState()
	{
		return winState;
	}
	
	public void setState(WinState state)
	{
		winState = state;
	}
	
	public int getScore()
	{
		return currentScore.getScore();
	}
	
	public void incrementScore()
	{
		currentScore.incrementScore();
	}
	
	public void resetScore()
	{
		currentScore.resetScore();
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
