// Basic Main Menu. Current just contains buttons for access the playable game screen and
// reseting high score. 

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainMenuScreen implements Screen 
{
	
	private class Title extends Actor
	{
		private final static float distanceFromBottom = 0.850f;
		private final static float maxWidth = 1.00f;
		
		private BitmapFont font;
		float xPos;
		float yPos;
		float titleWidth;
		
		public Title(Stage stage)
		{
			font = Assets.titleFont;
			xPos = 0.0f;
			yPos = stage.getHeight() * distanceFromBottom;
			titleWidth = stage.getWidth() * maxWidth;
			setTouchable(Touchable.disabled);
		}
		
		@Override
		public void draw(Batch batch, float parentAlpha)
		{
			super.draw(batch, parentAlpha);
			font.setColor(Color.NAVY);
			font.drawWrapped(batch, "ONE SECOND\nCHALLENGE", xPos, yPos, titleWidth, HAlignment.CENTER);
		}
	}
	
	private final static int minWorldHeight = 1400;
	private final static int minWorldWidth = 800;
	
	private OneSecondChallenge game;
	private Stage stage;
	
	// game objects
	private Image background;
	private MainMenuTable mainMenuTable;
	private Title title;
	
	MainMenuScreen(OneSecondChallenge game)
	{
		this.game = game;
	}

	@Override
	public void show() 
	{
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
		background = new Image(Assets.titleScreenBackground);
		mainMenuTable = new MainMenuTable(game, stage);
		title = new Title(stage);
		stage.addActor(background);
		stage.addActor(mainMenuTable.getTable());
		stage.addActor(title);
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
		stage.getViewport().update(width, height);
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
		stage.dispose();
	}

}
