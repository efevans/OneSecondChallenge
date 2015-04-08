// Button Table for the Main Menu
// Should contain buttons for any functionality desired at the main menu
// eg. Start Game, reset high Score

package com.mygdx.osc;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.osc.playerdata.GlobalPlayerData;

public class MainMenuTable extends AbstractButtonTable 
{
	
	private final static int buttonWidth = 360;
	private final static int buttonHeight = 180;
	private final static float tableYPos = -0.10f;

	private OneSecondChallenge game;
	private Stage stage;
	
	public MainMenuTable(OneSecondChallenge game, Stage stage){
		this.game = game;
		this.stage = stage;
		initialize();
	}
	
	public void initialize() 
	{
		table = new Table();
		buttonMap = new HashMap<String, TextButton>();

		readyButtons();
		readyTable();
	}
	
	public void readyButtons() 
	{
		Skin skin = readySkin();
		TextButton start = new TextButton("Start", skin);
		start.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				Gdx.app.log("MyTag", "clicked!");
				Gdx.input.setInputProcessor(null);
				game.setScreen(new GameScreen(game));
			}
		});
		
		TextButton resetHighScore = new TextButton("Reset HighScore", skin);
		resetHighScore.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				Gdx.app.log("MyTag", "clicked!");
				GlobalPlayerData.forceSetNewHighScore(0);
			}
		});
		
		buttonMap.put("Start", start);
		buttonMap.put("Temp", resetHighScore);
		
	}

	public void readyTable() 
	{
		table.row().prefSize(120, 60);
		table.add(buttonMap.get("Start")).pad(10).prefSize(buttonWidth, buttonHeight);
		table.row();
		table.add(buttonMap.get("Temp")).pad(10).prefSize(buttonWidth, buttonHeight);
		table.setFillParent(true);
		table.setY(stage.getHeight() * tableYPos);
	}
	
	private Skin readySkin()
	{
		Skin skin = new Skin();
		skin.add("texture", new Texture(Gdx.files.internal("skins/buttontexture.png")));
		skin.add("text", Assets.buttonFont);
		
		TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
		buttonStyle.up = skin.newDrawable("texture");
		buttonStyle.down = skin.newDrawable("texture", Color.CYAN);
		buttonStyle.font = skin.getFont("text");
		skin.add("default", buttonStyle);
		
		return skin;
	}
}
