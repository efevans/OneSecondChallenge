// Simple Global Assets manager
// static function load() should be called upon program start up to preload any game assets

package com.mygdx.osc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets
{
	public static Texture smallSadFace;
	public static Texture mediumSadFace;
	public static Texture largeSadFace;
	
	public static Texture smallHappyFace;
	public static Texture mediumHappyFace;
	public static Texture largeHappyFace;
	
	public static Texture startFace;
	public static Texture waitingFace;
	
	public static Texture backButtonUp;
	public static Texture backButtonDown;
	
	public static Texture holdAreaTexture;
	
	public static Texture titleScreenBackground;
	
	public static Sound wonRoundSound;
	public static Sound lostRoundSound;
	
	public static BitmapFont scoreFont;
	public static BitmapFont titleFont;
	public static BitmapFont buttonFont;
	
	public static Skin defaultSkin;
	
	// preload any game assets
	public static void load()
	{
		loadTextures();
		loadSkins();
		loadSounds();
		loadFonts();
	}
	
	// load any textures to be used
	private static void loadTextures()
	{
		smallSadFace = new Texture(Gdx.files.internal("textures/smallsad.png"));
		mediumSadFace = new Texture(Gdx.files.internal("textures/mediumsad.png"));
		largeSadFace = new Texture(Gdx.files.internal("textures/highsad.png"));
		
		smallHappyFace = new Texture(Gdx.files.internal("textures/smallhappy.png"));
		mediumHappyFace = new Texture(Gdx.files.internal("textures/mediumhappy.png"));
		largeHappyFace = new Texture(Gdx.files.internal("textures/highhappy.png"));
		
		startFace = new Texture(Gdx.files.internal("textures/start.png"));
		waitingFace = new Texture(Gdx.files.internal("textures/waiting.png"));
		
		backButtonUp = new Texture(Gdx.files.internal("textures/backbuttonup.png"));
		backButtonDown = new Texture(Gdx.files.internal("textures/backbuttondown.png"));
		
		holdAreaTexture = new Texture(Gdx.files.internal("textures/holdarea.png"));
		
		titleScreenBackground = new Texture(Gdx.files.internal("textures/titlescreen.png"));
	}
	
	// load any skins to be used
	private static void loadSkins()
	{
		defaultSkin = new Skin(Gdx.files.internal("skins/uiskin.json"));
	}
	
	// load any sounds to be used. This will likely only be short sound effects and
	// leave longer sounds, like long BGM, to streaming
	private static void loadSounds()
	{
		wonRoundSound = Gdx.audio.newSound(Gdx.files.internal("sounds/winsound.ogg"));
		lostRoundSound = Gdx.audio.newSound(Gdx.files.internal("sounds/losesound.ogg"));
	}
	
	private static void loadFonts()
	{
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/scoreFont.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 100;
		parameter.characters = "0123456789";
		scoreFont = generator.generateFont(parameter);
		parameter.size = 100;
		parameter.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		titleFont = generator.generateFont(parameter);
		parameter.size = 30;
		parameter.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		buttonFont = generator.generateFont(parameter);
		generator.dispose();
	}
	
}
