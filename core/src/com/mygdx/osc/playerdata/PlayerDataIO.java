package com.mygdx.osc.playerdata;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class PlayerDataIO
{
	
	public static String writeSerializedData(PlayerData userData, String filename){
		Json json = new Json();
		String text = json.toJson(userData);
		System.out.println(json.toJson(userData));
		Gdx.files.local(filename).writeString(text, false);
		
		return text;
	}
	
	public static PlayerData deserializeData(String filename){
		Json json = new Json();
		PlayerData playerData;
		
		if (Gdx.files.local(filename).exists()){
			FileHandle fileHandle = Gdx.files.local(filename);
			playerData = json.fromJson(PlayerData.class, fileHandle);
		} else {
			playerData = PlayerData.defaultValues();
		}
		
		return playerData;
	}
	
	public static PlayerData readUserData(String filename){
		PlayerData userData = deserializeData(filename);
		return userData;
	}
}
