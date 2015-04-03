// Game object to go on the GameScreen that displays the player's current score

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class CurrentScore extends Label
{
	
	private final static float fontScaleConst = 0.005f;
	
	Stage stage;
	
	private int currentScore;
	
	public CurrentScore(Skin skin, Stage stage)
	{
		super("hi", skin);
		this.stage = stage;
		currentScore = 0;
		setTouchable(Touchable.disabled);
		readyLabel();
	}
	
	@Override
	public void act(float delta)
	{
		readyLabel();
	}
	
	// prepares the position, size, and content of the label for displaying
	private void readyLabel()
	{
		float fontSize = stage.getHeight() * fontScaleConst;
		setFontScale(fontSize);
		setY(stage.getHeight() * 0.95f);
		setX(stage.getWidth() * 0.01f);
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
