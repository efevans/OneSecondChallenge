// Button Table for the Main Menu
// Should contain buttons for any functionality desired at the main menu
// eg. Start Game, reset high Score

package com.mygdx.osc;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuTable extends AbstractButtonTable 
{

	OneSecondChallenge game;
	
	public MainMenuTable(OneSecondChallenge game){
		this.game = game;
		initialize();
	}
	
	@Override
	public void initialize() 
	{
		skin = new Skin(Gdx.files.internal("skins/uiskin.json")); // temp, no skin avail
		table = new Table();
		buttonMap = new HashMap<String, TextButton>();

		readyButtons();
		readyTable();
	}
	
	@Override
	public void readyButtons() 
	{
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
		
		buttonMap.put("Start", start);
		buttonMap.put("Temp", new TextButton("Temp", skin));
		
	}

	@Override
	public void readyTable() 
	{
		table.row().prefSize(120, 60);
		table.add(buttonMap.get("Start")).pad(10).prefSize(240, 120);
		table.row();
		table.add(buttonMap.get("Temp")).pad(10).prefSize(240, 120);
		table.setFillParent(true);

	}
}
