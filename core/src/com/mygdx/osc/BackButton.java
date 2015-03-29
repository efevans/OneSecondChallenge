package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class BackButton extends ImageButton
{

	OneSecondChallenge game;
	
	public BackButton(Drawable imageUp, Drawable imageDown, OneSecondChallenge gameO)
	{
		initializeActor();
	}
	
	private void initializeActor()
	{
		setTouchable(Touchable.enabled);
		initializeBounds();
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
	
	private void initializeBounds()
	{
		int x = (Assets.anxiousFace.getWidth() - Gdx.graphics.getWidth()) / 2;
		int y = Gdx.graphics.getHeight() - 80 - (Assets.anxiousFace.getHeight());
		setBounds(0, y, Assets.anxiousFace.getWidth(), Assets.anxiousFace.getHeight());
	}
}

