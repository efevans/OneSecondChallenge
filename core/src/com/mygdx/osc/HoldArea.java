// Game object to go on the Game Screen. Contains the logic for timing the player's touches
// and notifying the Game Screen to update state.

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class HoldArea extends Actor 
{
	
	private static final float winBuffer = 0.15f;
	private static final float topBuffer = 0.25f;
	
	private GameScreen gameScreen;
	private Stage stage;
	
	float touchTimer;
	boolean timing;
	
	private Sprite touchAreaSprite;
	
	private Sound wonSound = Assets.wonRoundSound;
	private Sound lostSound = Assets.lostRoundSound;
	
	public HoldArea(GameScreen gameScreen, Stage stage)
	{
		this.gameScreen = gameScreen;
		this.stage = stage;
		initializeActor(stage);
		initializeTiming();
	}
	
	// initialize the hold screen actor, particularly the input listener for screen touching
	private void initializeActor(Stage stage)
	{
		touchAreaSprite = new Sprite(Assets.holdAreaTexture);
		setBounds(0, 0, stage.getWidth(), stage.getHeight() * topBuffer);
		setTouchable(Touchable.enabled);
		addListener(new InputListener() 
		{
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				touchTimer = 0.0f;
				timing = true;
				gameScreen.setState(GameScreen.WinState.TIMING);
				Gdx.app.log("HoldArea", "yep, it touched down");
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{
				checkBounds(touchTimer);
				timing = false;
				Gdx.app.log("HoldArea", Float.toString(touchTimer));
			}
		});
	}
	
	private void initializeTiming()
	{
		this.touchTimer = 0.0f;
		this.timing = false;
	}
	
	// check if the time is within the bounds for "winning", update accordingly
	private boolean checkBounds(float time)
	{
		if (time > 1.0f - winBuffer && time < 1.0f + winBuffer)
		{
			wonSound.play();
			gameScreen.incrementScore();
			gameScreen.setState(GameScreen.WinState.WONLAST);
		}
		else
		{
			lostSound.play();
			gameScreen.resetScore();
			gameScreen.setState(GameScreen.WinState.LOSTLAST);
		}
		
		return false;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		batch.draw(touchAreaSprite, 0, 0, getWidth(), getHeight());
	}
	
	@Override
	public void act(float delta)
	{
		setBounds(0, 0, stage.getWidth(), stage.getHeight() * (1 - topBuffer));
		if(timing)
		{
			touchTimer += delta;
		}
	}
}
