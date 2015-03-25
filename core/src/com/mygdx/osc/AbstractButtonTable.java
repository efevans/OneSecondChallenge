package com.mygdx.osc;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public abstract class AbstractButtonTable 
{
	
	protected Table table;
	protected Skin skin;
	protected HashMap<String, TextButton> buttonMap;
	
	public abstract void initialize(); // perhaps take a viewport?
	public abstract void readyTable(); // perhaps take a viewport?
	public abstract void readyButtons();
	
	public Table getTable()
	{
		return table;
	}

}
