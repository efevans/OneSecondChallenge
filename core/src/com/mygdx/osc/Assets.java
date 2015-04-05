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
	public static Texture sadFace;
	public static Texture happyFace;
	public static Texture happeningFace;
	public static Texture anxiousFace;
	
	public static Texture backButtonUp;
	public static Texture backButtonDown;
	
	public static Texture holdAreaTexture;
	
	public static Sound pressDownSound;
	public static Sound wonRoundSound;
	public static Sound lostRoundSound;
	public static Sound enteredGameScreenSound;
	
	public static BitmapFont scoreFont;
	
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
		sadFace = new Texture(Gdx.files.internal("textures/test1.png"));
		happyFace = new Texture(Gdx.files.internal("textures/test2.png"));
		happeningFace = new Texture(Gdx.files.internal("textures/test3.png"));
		anxiousFace = new Texture(Gdx.files.internal("textures/test4.png"));
		
		backButtonUp = new Texture(Gdx.files.internal("textures/backbuttonup.png"));
		backButtonDown = new Texture(Gdx.files.internal("textures/backbuttondown.png"));
		
		holdAreaTexture = new Texture(Gdx.files.internal("textures/holdarea.png"));
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
		pressDownSound = Gdx.audio.newSound(Gdx.files.internal("sounds/snap.wav"));
//		wonRoundSound = Gdx.audio.newSound(Gdx.files.internal("sounds/wawawa.flac"));
//		lostRoundSound = Gdx.audio.newSound(Gdx.files.internal("sounds/wawawa.flac"));
//		enteredGameScreenSound = Gdx.audio.newSound(Gdx.files.internal("sounds/wawawa.flac"));
		wonRoundSound = pressDownSound;
		lostRoundSound = pressDownSound;
		enteredGameScreenSound = pressDownSound;
	}
	
	private static void loadFonts()
	{
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/scoreFont.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 100;
		parameter.characters = "0123456789";
		scoreFont = generator.generateFont(parameter);
		generator.dispose();
	}
	
}
