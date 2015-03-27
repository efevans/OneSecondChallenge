package com.mygdx.osc.playerdata;

public class GlobalPlayerData
{
	
	private static PlayerData playerData;
	
	private GlobalPlayerData(){	}
	
	public static void initPlayerData(){
		playerData = PlayerDataIO.readUserData("playerdata.json");
	}
	
	public static int getHighScore(){
		return playerData.getHighScore();
	}
	
	public static void trySetNewHighScore(int new_val){
		if (new_val > getHighScore()){
			playerData.setHighScore(new_val);
			PlayerDataIO.writeSerializedData(playerData, "playerdata.json");
		}
	}
	
	public static void forceSetNewHighScore(int new_val){
		playerData.setHighScore(new_val);
		PlayerDataIO.writeSerializedData(playerData, "playerdata.json");
	}
}
