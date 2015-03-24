package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {
	
	private OneSecondChallenge game;
	float touchTimer;
	
	public GameScreen(OneSecondChallenge game){
		this.game = game;
		touchTimer = 0.0f;
		System.out.println("hi");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		
		if (Gdx.input.isTouched())
		{
			touchTimer += delta;
		}
		
		if (!Gdx.input.isTouched() && touchTimer > 0.0)
		{
			Gdx.app.log("MyTag", Float.toString(touchTimer));
			touchTimer = 0.0f;
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
