package com.prototype.game;

import com.badlogic.gdx.utils.Array;

/**
 * Save Data for the game
 * @author Group 3
 *
 */
public class SaveData {
	
	//The current level
	private int levelID;
        // Coordinates of the player
        private double xPos, yPos;
        // Inventory
        int[] keys;
	/**
	 * Creates a new Save Data object (For JSON)
	 */
	public SaveData() {
		
	}
	
	/**
	 * Creates new save data to be saved
	 * @param levelID The current level
	 */
	public SaveData(int levelID, double xPos, double yPos, int[] keys) {
		this.levelID = levelID;
                this.xPos = xPos;
                this.yPos = yPos;
                this.keys = keys;
	}
	
	/**
	 * Returns the saved level number
	 * @return The saved level number
	 */
	public int getLevel() {
		return this.levelID;
	}
}