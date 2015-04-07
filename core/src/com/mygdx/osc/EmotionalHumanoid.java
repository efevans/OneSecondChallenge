// Game object to go on the Game Screen that displays some image as feedback for the 
// player's performance

package com.mygdx.osc;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class EmotionalHumanoid extends Image
{

	private final static float imageHeight = 0.20f;
	private final static float imageWidth = 1400f / 800f * 0.20f;
	private final static float topBuffer = 0.02f;
	
	private GameScreen gameScreen;
	private Stage stage;
	
	public EmotionalHumanoid(Sprite sprite, GameScreen gameScreen, Stage stage)
	{
		super(sprite);
		this.stage = stage;
		this.gameScreen = gameScreen;
		setTouchable(Touchable.disabled);
		setupBounds();
	}
	
	@Override
	public void act(float delta)
	{
		setImage();
		setupBounds();
	}
	
	private void setupBounds()
	{
		float x = (stage.getWidth() * (1 - imageWidth)) / 2;
		float y = (stage.getHeight() * (1 - imageHeight - topBuffer));
		float width = stage.getWidth() * imageWidth;
		float height = stage.getHeight() * imageHeight;
		setBounds(x, y, width, height);
	}
	
	private void setImage()
	{
		GameScreen.WinState state = gameScreen.getState();
		switch(state)
		{
		case TIMING: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.waitingFace)));
			break;
		case WONLASTSHORT: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.smallHappyFace)));
			break;
		case WONLASTMEDIUM: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.mediumHappyFace)));
			break;
		case WONLASTLONG: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.largeHappyFace)));
			break;
		case LOSTLASTSHORT: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.smallSadFace)));
			break;
		case LOSTLASTMEDIUM: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.mediumSadFace)));
			break;
		case LOSTLASTLONG: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.largeSadFace)));
			break;
		case NOTPLAYED: 
			setDrawable(new SpriteDrawable(new Sprite(Assets.startFace)));
			break;
		}
	}
	
}
