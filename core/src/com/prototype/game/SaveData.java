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
        // ID of keys already spawned
        boolean[] keysSpawned;
	/**
	 * Creates a new Save Data object (For JSON)
	 */
	public SaveData() {
		
	}
	
	/**
	 * Creates new save data to be saved
	 * @param levelID The current level
	 */
	public SaveData(int levelID, double xPos, double yPos, int[] keys, boolean[] keysSpawned) {
		this.levelID = levelID;
                this.xPos = xPos;
                this.yPos = yPos;
                this.keys = keys;
                this.keysSpawned = keysSpawned;
	}
	
	/**
	 * Returns the saved level number
	 * @return The saved level number
	 */
	public int getLevel() {
		return this.levelID;
	}
        
        /*
        Returns the Y position
        @return Y position
        */
        public double getY(){
            return this.yPos;
        }
        
        public double getX(){
            return this.xPos;
        }
        
        public boolean[] getKeysSpawned(){
            return this.keysSpawned;
        }
        
        public int[] getKeys(){
            return this.keys;
        }
}