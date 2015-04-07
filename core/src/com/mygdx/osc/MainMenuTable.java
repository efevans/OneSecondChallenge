// Button Table for the Main Menu
// Should contain buttons for any functionality desired at the main menu
// eg. Start Game, reset high Score

package com.mygdx.osc;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.osc.playerdata.GlobalPlayerData;

public class MainMenuTable extends AbstractButtonTable 
{

	OneSecondChallenge game;
	private Sound startGameSound;
	Skin skin;
	
	public MainMenuTable(OneSecondChallenge game){
		this.game = game;
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
		startGameSound = Assets.enteredGameScreenSound;
		TextButton start = new TextButton("Start", skin);
		start.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				Gdx.app.log("MyTag", "clicked!");
				startGameSound.play();
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
		table.add(buttonMap.get("Start")).pad(10).prefSize(240, 120);
		table.row();
		table.add(buttonMap.get("Temp")).pad(10).prefSize(240, 120);
		table.setFillParent(true);

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
