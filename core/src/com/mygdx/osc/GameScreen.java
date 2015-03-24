package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {
	
	enum WinState
	{
		TIMING,
		WONLAST,
		LOSTLAST,
		NOTPLAYED
	}
	
	private OneSecondChallenge game;
	float touchTimer;
	boolean timing;
	WinState winState;
	
	public GameScreen(OneSecondChallenge game){
		this.game = game;
		this.touchTimer = 0.0f;
		this.timing = false;
		this.winState = WinState.NOTPLAYED;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		
		// while screen is touched accumulate time of touch
		if (Gdx.input.isTouched())
		{
			timing = true;
			touchTimer += delta;
			this.winState = WinState.TIMING;
		}
		else // screen is not being touched
		{
			
			// if this is the first loop after finishing touching, check for win
			if(timing)
			{
				if (withinBounds(touchTimer))
				{
					this.winState = WinState.WONLAST;
				}
				else
				{
					this.winState = WinState.LOSTLAST;
				}
				
				timing = false;
			}
			
			// logging the end time for testing, also reset timer here
			if (touchTimer > 0.0f)
			{
				Gdx.app.log("MyTag", Float.toString(touchTimer));
				touchTimer = 0.0f;
			}
		}
		
		setDisplay(this.winState);
	}
	
	// checks if the 
	private boolean withinBounds(float time)
	{
		if (time > 0.93f && time < 1.07f)
		{
			return true;
		}
		
		return false;
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

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
