package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * A key object to unlock doors
 * @author Group 3
 *
 */
public class Key extends GameObject{
	
	//ID number for the key
	private String id;
	//Whether the key is an actual game object or for display only (for inventory)
	private boolean inInventory;
        //Auto increment for each key
        private static int globalId = 0;
	
	/**
	 * Creates a key object
	 * @param texture The texture for the key
	 * @param width Width of the key texture
	 * @param height Height of the key texture
	 * @param x X position of the key
	 * @param y Y position of the key
	 * @param level The level the key is for
	 * @param id The id of the key
	 * @param display Whether the key is for display or for collecting
	 */
	public Key(Texture texture, int width, int height, int x, int y, Level level, boolean collidable, Callback callback) {
		super(texture, width, height, x, y, level, collidable, callback);
		this.id = ""+Key.globalId;
                Key.globalId++;
		this.inInventory = false;
	}
	
	/**
	 * Determines if the key has been collected and put into the inventory
	 * @return True if the key has been collected and false if it has not
	 */
	public boolean isInInventory() {
		return inInventory;
	}
	
	/**
	 * Gives the key's id
	 * @return The id
	 */
	public String getID() {
		return id;
	}

	
	@Override
	public void action() {
		if(!inInventory) {
			inInventory = true;
			level.inventory.addKey(this);
		}
                if(callback != null){
                    callback.action(this.level);
                }
                
	}
	
	@Override
	public void render(SpriteBatch batch) {
		if(!inInventory) {
			batch.draw(texture, x, y);
		}
	}
	

}
