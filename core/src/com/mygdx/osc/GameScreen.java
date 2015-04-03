// Game Screen where the main game is played. Contains the accessor functions for
// each of the objects on the game screen to interact to each other through. Contains the
// game state.

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameScreen implements Screen 
{
	
	enum WinState
	{
		TIMING,
		WONLAST,
		LOSTLAST,
		NOTPLAYED
	}
	
	private final static int minWorldHeight = 1000;
	private final static int minWorldWidth = 800;
	
	private OneSecondChallenge game;
	
	// personal objects
	private Stage stage;
	private static WinState winState;
	
	// game objects
	HoldArea holdArea;
	CurrentScore currentScore;
	HighScore highScore;
	EmotionalHumanoid emotionalHumanoid;
	BackButton backButton;
	
	public GameScreen(OneSecondChallenge game)
	{
		this.game = game;
	}

	@Override
	public void show() 
	{
		winState = WinState.NOTPLAYED;
		initializeStage();
		initializeGameObjects();
		
		Gdx.input.setInputProcessor(stage);
	}
	
	// initialize the set of game objects and add them to the stage
	private void initializeGameObjects()
	{
		holdArea = new HoldArea(this, stage);
		currentScore = new CurrentScore(Assets.defaultSkin, stage);
		highScore = new HighScore(stage);
		emotionalHumanoid = new EmotionalHumanoid(new Sprite(Assets.sadFace), this, stage);
		backButton = new BackButton(new SpriteDrawable(new Sprite(Assets.happeningFace)),
									new SpriteDrawable(new Sprite(Assets.happyFace)), game);
		stage.addActor(holdArea);
		stage.addActor(currentScore);
		stage.addActor(highScore);
		stage.addActor(emotionalHumanoid);
//		stage.addActor(backButton);
	}
	
	// initialize the stage object with correct viewport
	private void initializeStage()
	{
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, minWorldWidth, minWorldHeight);
		StretchViewport viewport = new StretchViewport(minWorldWidth, minWorldHeight, camera);
		stage = new Stage(viewport);
	}

	@Override
	public void render(float delta) 
	{
//		setDisplay(winState);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}
	
	// set the color of the display depending on the current state
	// TODO make this more involved with pretty graphics
//	private void setDisplay(WinState winState)
//	{
//		switch (winState)
//		{
//		case TIMING:
//			Gdx.gl.glClearColor(0, 0, 1.0f, 1);
//			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//			break;
//		case WONLAST:
//			Gdx.gl.glClearColor(0, 1.0f, 0, 1);
//			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//			break;
//		case LOSTLAST:
//			Gdx.gl.glClearColor(1.0f, 0, 0, 1);
//			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//			break;
//		case NOTPLAYED:
//			Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
//			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//			break;
//		}
//	}

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
		stage.getViewport().update(width, height);
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
