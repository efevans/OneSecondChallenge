// Simple Global Assets manager
// static function load() should be called upon program start up to preload any game assets

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets
{
	public static Texture sadFace;
	public static Texture happyFace;
	public static Texture happeningFace;
	public static Texture anxiousFace;
	
	public static Skin defaultSkin;
	
	// preload any game assets
	public static void load()
	{
		loadTextures();
		loadSkins();
	}
	
	// load any textures to be used
	private static void loadTextures()
	{
		sadFace = new Texture(Gdx.files.internal("textures/test1.png"));
		happyFace = new Texture(Gdx.files.internal("textures/test2.png"));
		happeningFace = new Texture(Gdx.files.internal("textures/test3.png"));
		anxiousFace = new Texture(Gdx.files.internal("textures/test4.png"));
	}
	
	// load and skins to be used
	private static void loadSkins()
	{
		defaultSkin = new Skin(Gdx.files.internal("skins/uiskin.json"));
	}
}
