// Game object to go on the GameScreen that displays the player's high score across all plays

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.osc.playerdata.GlobalPlayerData;

public class HighScore extends Label
{

	private int highScore;
	
	public HighScore(Skin skin)
	{
		super("", skin);
		highScore = GlobalPlayerData.getHighScore();
		setTouchable(Touchable.disabled);
		
		// TODO make this more clear and platform independent
		setFontScale(5);
		setY(Gdx.graphics.getHeight() - 60);
		setX(Gdx.graphics.getWidth() - 50);
	}
	
	@Override
	public void act(float delta)
	{
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
