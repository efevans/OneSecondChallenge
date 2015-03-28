// Game object to go on the GameScreen that displays the player's current score

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class CurrentScore extends Label
{
	
	private int currentScore;
	
	public CurrentScore(Skin skin)
	{
		super("hi", skin);
		currentScore = 0;
		setTouchable(Touchable.disabled);
		
		// TODO make this more clear and platform independent
		setFontScale(5);
		setY(Gdx.graphics.getHeight() - 60);
		setX(10);
	}
	
	@Override
	public void act(float delta)
	{
		setText(Integer.toString(currentScore));
	}
	
	public void incrementCurrentScore()
	{
		++currentScore;
	}
	
	public void resetCurrentScore()
	{
		currentScore = 0;
	}
	
	public int getCurrentScore()
	{
		return currentScore;
	}
	
}
