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
		float x = 0.01f;
		float y = stage.getHeight() * 0.79f;
		float width = stage.getWidth() * 0.10f;
		float height = stage.getHeight() * 0.07f;
		setBounds(x, y, width, height);
	}
}
