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
		WONLASTSHORT,
		WONLASTMEDIUM,
		WONLASTLONG,
		LOSTLASTSHORT,
		LOSTLASTMEDIUM,
		LOSTLASTLONG,
		NOTPLAYED
	}
	
	private final static int minWorldHeight = 1400;
	private final static int minWorldWidth = 800;
	
	private OneSecondChallenge game;
	
	// personal objects
	private Stage stage;
	private static WinState winState;
	private static int loseStreak;
	
	// game objects
	private HoldArea holdArea;
	private CurrentScore currentScore;
	private HighScore highScore;
	private EmotionalHumanoid emotionalHumanoid;
	private BackButton backButton;
	
	public GameScreen(OneSecondChallenge game)
	{
		this.game = game;
	}

	@Override
	public void show() 
	{
		winState = WinState.NOTPLAYED;
		loseStreak = 0;
		initializeStage();
		initializeGameObjects();
		Gdx.input.setInputProcessor(stage);
	}
	
	// initialize the stage object with correct viewport
	private void initializeStage()
	{
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, minWorldWidth, minWorldHeight);
		StretchViewport viewport = new StretchViewport(minWorldWidth, minWorldHeight, camera);
		stage = new Stage(viewport);
	}
	
	// initialize the set of game objects and add them to the stage
	private void initializeGameObjects()
	{
		holdArea = new HoldArea(this, stage);
		currentScore = new CurrentScore(Assets.defaultSkin, stage);
		highScore = new HighScore(stage);
		emotionalHumanoid = new EmotionalHumanoid(new Sprite(Assets.startFace), this, stage);
		backButton = new BackButton(new SpriteDrawable(new Sprite(Assets.backButtonUp)),
									new SpriteDrawable(new Sprite(Assets.backButtonDown)), game, stage);
		stage.addActor(holdArea);
		stage.addActor(currentScore);
		stage.addActor(highScore);
		stage.addActor(emotionalHumanoid);
		stage.addActor(backButton);
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
	
	// increment current score and update high score if needed, reset lose streak count
	public void incrementScore()
	{
		int score = currentScore.incrementCurrentScore();
		highScore.trySetHighScore(score);
		updateState(score);
		loseStreak = 0;
	}
	
	// reset current score and increment lose streak, after a loss
	public void resetScore()
	{
		currentScore.resetCurrentScore();
		++loseStreak;
		updateState(0);
	}
	
	// update state based on score and lose streak
	private void updateState(int score)
	{
		if(score >= 20) 		winState = WinState.WONLASTLONG;
		else if(score >= 10) 	winState = WinState.WONLASTMEDIUM;
		else if(score >= 1)		winState = WinState.WONLASTSHORT;
		else if(loseStreak >= 5)	winState = WinState.LOSTLASTLONG;
		else if(loseStreak >= 3)	winState = WinState.LOSTLASTMEDIUM;
		else if(loseStreak >= 1)	winState = WinState.LOSTLASTSHORT;
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
