// Game object to go on the GameScreen that displays the player's current score

package com.mygdx.osc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class CurrentScore extends Label
{
	
//	private final static float fontScaleConst = 0.005f;
	
	private Stage stage;
	private BitmapFont font;
	
	private int currentScore;
	
	public CurrentScore(Skin skin, Stage stage)
	{
		super("", skin);
		this.stage = stage;
		font = Assets.scoreFont;
		currentScore = 0;
		setTouchable(Touchable.disabled);
		readyLabel();
	}
	
	@Override
	public void act(float delta)
	{
		readyLabel();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		super.draw(batch, parentAlpha);
		readyLabel();
		font.draw(batch, Integer.toString(currentScore), getX(), getY());
	}
	
	// prepares the position, size, and content of the label for displaying
	private void readyLabel()
	{
//		float fontSize = stage.getHeight() * fontScaleConst;
//		setFontScale(fontSize);
		setX(stage.getWidth() * 0.01f);
		setY(stage.getHeight() * 0.965f);
		font.setColor(Color.YELLOW);
//		setText(Integer.toString(currentScore));
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
