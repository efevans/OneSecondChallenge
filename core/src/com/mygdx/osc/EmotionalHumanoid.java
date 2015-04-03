// Game object to go on the Game Screen that displays some image as feedback for the 
// player's performance

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class EmotionalHumanoid extends Image
{
	
	private GameScreen gameScreen;
	private Stage stage;
	
	private Sprite currentSprite;
	
	public EmotionalHumanoid(Sprite sprite, GameScreen gameScreen, Stage stage)
	{
		super(sprite);
		this.stage = stage;
		currentSprite = sprite;
		this.gameScreen = gameScreen;
		setTouchable(Touchable.disabled);
	}
	
	@Override
	public void act(float delta)
	{
		setImage();
		setX((stage.getWidth() - currentSprite.getWidth()) / 2);
		setY((stage.getHeight() - currentSprite.getHeight()) * 0.95f);
		setOrigin(currentSprite.getWidth() / 2.0f, currentSprite.getHeight() / 2.0f);
	}
	
	private void setImage()
	{
		GameScreen.WinState state = gameScreen.getState();
		switch(state)
		{
		case TIMING: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.happeningFace)));
			break;
		case WONLAST: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.happyFace)));
			break;
		case LOSTLAST: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.sadFace)));
			break;
		case NOTPLAYED: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.anxiousFace)));
			break;
		}
	}
	
}
