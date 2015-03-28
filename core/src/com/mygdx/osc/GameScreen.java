package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
	
	// game objects
	HoldArea holdArea;
	CurrentScore currentScore;
	HighScore highScore;
	EmotionalHumanoid emotionalHumanoid;
	
	public GameScreen(OneSecondChallenge game)
	{
		this.game = game;
	}

	@Override
	public void show() 
	{
		winState = WinState.NOTPLAYED;
		initializeGameObjects();
		initializeStage();
		
		Gdx.input.setInputProcessor(stage);
	}
	
	// initialize the set of game objects that gon on the GameScreen
	private void initializeGameObjects()
	{
		holdArea = new HoldArea(this);
		currentScore = new CurrentScore(Assets.defaultSkin);
		highScore = new HighScore(Assets.defaultSkin);
		emotionalHumanoid = new EmotionalHumanoid(new Sprite(Assets.sadFace), this);
	}
	
	// initialize the stage object and actors within it
	private void initializeStage()
	{
		stage = new Stage();
		stage.addActor(holdArea);
		stage.addActor(currentScore);
		stage.addActor(highScore);
		stage.addActor(emotionalHumanoid);
	}

	@Override
	public void render(float delta) 
	{
		setDisplay(winState);
		stage.act(delta);
		stage.draw();
	}
	
	// set the color of the display depending on the current state
	// TODO make this more involved with pretty graphics
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
	
	// get current score
	public int getScore()
	{
		return currentScore.getCurrentScore();
	}
	
	// increment current score and update high score if needed
	public void incrementScore()
	{
		currentScore.incrementCurrentScore();
		highScore.trySetHighScore(currentScore.getCurrentScore());
	}
	
	// reset current score, after a loss
	public void resetScore()
	{
		currentScore.resetCurrentScore();
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
