package com.mygdx.osc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class FeedbackLabel extends Actor
{
	
	private final static float distanceFromLeft = 0.83f;
	private final static float distanceFromBottom = 0.85f;
	
	private GameScreen gameScreen;
	private Stage stage;
	private BitmapFont font;
	
	private String informText;

	public FeedbackLabel(Stage stage, GameScreen gameScreen)
	{
		this.stage = stage;
		this.gameScreen = gameScreen;
		font = Assets.informFont;
		informText = "";
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
//		font.draw(batch, informText, getX(), getY());
		font.drawMultiLine(batch, informText, getX(), getY(), (1.0f - distanceFromLeft), HAlignment.CENTER);
	}
	
	// prepares the position, size, and content of the label for displaying
	private void readyLabel()
	{
		setX(stage.getWidth() * distanceFromLeft);
		setY(stage.getHeight() * distanceFromBottom);
		generateText();
	}
	
	// prepares the content of the text depending on game state
	private void generateText()
	{
		float lostBy = gameScreen.getLostBy();
		
		if(lostBy > 0.0f) // Went over the time
		{
			if(lostBy > 0.5)
			{
				informText = "Way too\nlong";
				font.setColor(Color.MAROON);
			}
			else if(lostBy > 0.15)
			{
				informText = "Too\nlong";
				font.setColor(Color.RED);
			}
			else if(lostBy > 0.05)
			{
				informText = "Bit too\nlong";
				font.setColor(Color.ORANGE);
			}
			else
			{
				informText = "Just\nlong!";
				font.setColor(Color.YELLOW);
			}
		}
		else if(lostBy < 0.0f) // Went under the time
		{
			if(lostBy < -0.5)
			{
				informText = "Way too\nshort";
				font.setColor(Color.MAROON);
			}
			else if(lostBy < -0.15)
			{
				informText = "Too\nshort";
				font.setColor(Color.RED);
			}
			else if(lostBy < -0.05)
			{
				informText = "Bit too\nshort";
				font.setColor(Color.ORANGE);
			}
			else
			{
				informText = "Just\nshort!";
				font.setColor(Color.YELLOW);
			}
		}
		
		// we won
		else informText = " "; 
	}
}
