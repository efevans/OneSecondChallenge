// abstract class intended to ease the creation of ButtonTable

package com.mygdx.osc;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public abstract class AbstractButtonTable 
{
	
	protected Table table;
	protected Skin skin;
	protected HashMap<String, TextButton> buttonMap; // hash of Strings to buttons
	
	// general function to initialize the class's objects including table and buttons
	public abstract void initialize(); // perhaps take a viewport?
	
	// should be overriden to ready all the buttons
	public abstract void readyButtons();
	
	// should b overridden to ready anything for the table
	public abstract void readyTable(); // perhaps take a viewport?
	
	public Table getTable()
	{
		return table;
	}

}
