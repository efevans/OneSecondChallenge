// easy interface for writing and obtaining a PlayerData instance to/from file using
// libGdx's json serializer

package com.mygdx.osc.playerdata;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class PlayerDataIO
{
	
	// writes to the file filename in local storage a string containing the serialized
	// form of userData object
	public static String writeSerializedData(PlayerData userData, String filename){
		Json json = new Json();
		String text = json.toJson(userData);
		System.out.println(json.toJson(userData));
		Gdx.files.local(filename).writeString(text, false);
		
		return text;
	}
	
	// tries to read the file filename at the local data storage area. If successful, 
	// returns a PlayerData object relating to the deserialized json string read in. 
	// Otherwise returns a default PlayerData object.
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
	
	// returns a User data according to what is read at filename
	public static PlayerData readUserData(String filename){
		PlayerData userData = deserializeData(filename);
		return userData;
	}
}
