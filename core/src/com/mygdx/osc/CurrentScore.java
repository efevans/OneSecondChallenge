package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class CurrentScore extends Label
{
	
	static int currentScore;
	
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
	
	static public void incrementScore()
	{
		++currentScore;
	}
	
	static public void resetScore()
	{
		currentScore = 0;
	}
	
	static public int getScore()
	{
		return currentScore;
	}
	
}
