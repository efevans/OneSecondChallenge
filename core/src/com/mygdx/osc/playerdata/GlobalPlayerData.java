// Interface for accessing the persistent player Data, right now that is just the high score.
// Use initPlayerData() to retrieve any stored data from file, getHighScore() to get the
// high score, and try/forceSetNewHighScore() to attempt/force a new high score to be written.

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
	
	// set and write new_val as the high score is new_val is larger than current high score
	public static void trySetNewHighScore(int new_val){
		if (new_val > getHighScore()){
			playerData.setHighScore(new_val);
			PlayerDataIO.writeSerializedData(playerData, "playerdata.json");
		}
	}
	
	// set and write new_val as high score, foregoes checks
	public static void forceSetNewHighScore(int new_val){
		playerData.setHighScore(new_val);
		PlayerDataIO.writeSerializedData(playerData, "playerdata.json");
	}
}
