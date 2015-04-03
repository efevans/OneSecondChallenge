// Game object to go on the GameScreen that displays the player's high score across all plays

package com.mygdx.osc;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.osc.playerdata.GlobalPlayerData;

public class HighScore extends Label
{
	
	private final static float fontScaleConst = 0.005f;

	private Stage stage;
	
	private int highScore;
	
	public HighScore(Stage stage)
	{
		super("", Assets.defaultSkin);
		this.stage = stage;
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
		setAlignment(0, 8);
		setY(stage.getHeight() * 0.95f);
		setX(stage.getWidth() * 0.90f);
		highScore = GlobalPlayerData.getHighScore();
		setText(Integer.toString(highScore));
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
