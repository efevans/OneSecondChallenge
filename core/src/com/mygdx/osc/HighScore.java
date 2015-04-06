// Game object to go on the GameScreen that displays the player's high score across all plays

package com.mygdx.osc;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.osc.playerdata.GlobalPlayerData;

public class HighScore extends Label
{

	private final static float distanceFromLeft = 0.87f;
	private final static float distanceFromBottom = 0.965f;
	
	private Stage stage;
	private BitmapFont font;
	
	private int highScore;
	
	public HighScore(Stage stage)
	{
		super("", Assets.defaultSkin);
		this.stage = stage;
		font = Assets.scoreFont;
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
		font.drawMultiLine(batch, Integer.toString(highScore), getX(), getY(), stage.getWidth() * 0.1f, HAlignment.RIGHT);
	}
	
	// prepares the position, size, and content of the label for displaying
	private void readyLabel()
	{
		setX(stage.getWidth() * distanceFromLeft);
		setY(stage.getHeight() * distanceFromBottom);
		highScore = GlobalPlayerData.getHighScore();
	}
	
	public void trySetHighScore(int score)
	{
		if (score > highScore)
		{
			highScore = score;
			GlobalPlayerData.forceSetNewHighScore(highScore);
		}
	}
}
