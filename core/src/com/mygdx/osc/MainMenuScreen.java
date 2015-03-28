// Basic Main Menu. Current just contains buttons for access the playable game screen. 
// Considering if it would be useful to have a reset high score button here.

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MainMenuScreen implements Screen 
{
	
	OneSecondChallenge game;
	private SpriteBatch batch;
	private Stage stage;
	private MainMenuTable mainMenuTable;
	
	MainMenuScreen(OneSecondChallenge game)
	{
		this.game = game;
	}

	@Override
	public void show() 
	{
		batch = new SpriteBatch();
		stage = new Stage();
		mainMenuTable = new MainMenuTable(game);
		
		stage.addActor(mainMenuTable.getTable());
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor((float)0.3, 0, (float)0.5, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() 
	{
		batch.dispose();
		stage.dispose();

	}

}
