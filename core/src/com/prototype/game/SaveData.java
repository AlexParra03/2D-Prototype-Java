package com.prototype.game;

/**
 * Save Data for the game
 * @author Group 3
 *
 */
public class SaveData {
	
	//The current level
	private int levelID;

	/**
	 * Creates a new Save Data object (For JSON)
	 */
	public SaveData() {
		
	}
	
	/**
	 * Creates new save data to be saved
	 * @param levelID The current level
	 */
	public SaveData(int levelID) {
		this.levelID = levelID;
	}
	
	/**
	 * Returns the saved level number
	 * @return The saved level number
	 */
	public int getLevel() {
		return this.levelID;
	}
}
