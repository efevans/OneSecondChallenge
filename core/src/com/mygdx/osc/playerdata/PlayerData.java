// Basic class for player data, only player data atm is high score

package com.mygdx.osc.playerdata;

public class PlayerData 
{
	
	int highScore;
	
	public PlayerData(){
		highScore = 0;
	}
	
	public PlayerData(int val){
		highScore = val;
	}
	
	public void setHighScore(int value){
		highScore = value;
	}
	
	public int getHighScore(){
		return highScore;
	}
	
	public static PlayerData defaultValues(){
		PlayerData playerData = new PlayerData(0);
		return playerData;
	}
}
