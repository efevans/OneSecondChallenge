package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class BackButton extends ImageButton
{

	private final static float distanceFromLeft = 0.01f;
	private final static float distanceFromBottom = 0.76f;
	private final static float imageHeight = 0.10f;
	private final static float imageWidth = 0.10f;
	
	private OneSecondChallenge game;
	private Stage stage;
	
	public BackButton(Drawable imageUp, Drawable imageDown, OneSecondChallenge gameO, Stage stage)
	{
		super(imageUp, imageDown);
		this.stage = stage;
		this.game = gameO;
		initializeActor();
	}
	
	private void initializeActor()
	{
		setTouchable(Touchable.enabled);
		setupBounds();
		addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				Gdx.app.log("MyTag", "clicked back!");
				game.setScreen(new MainMenuScreen(game));
			}
		});
	}
	
	@Override
	public void act(float delta)
	{
		setupBounds();
	}
	
	private void setupBounds()
	{
		float x = stage.getWidth() * distanceFromLeft;
		float y = stage.getHeight() * distanceFromBottom;
		float width = stage.getWidth() * imageWidth;
		float height = stage.getHeight() * imageHeight;
		setBounds(x, y, width, height);
	}
}
