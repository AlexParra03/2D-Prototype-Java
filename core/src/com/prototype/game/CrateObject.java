package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * A crate object
 * @author Group 3
 *
 */
public class CrateObject extends GameObject {
	
	/**
	 * Creates a crate object at the given coordinates
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param level The level to create the crate in
	 */
	public CrateObject(int x, int y, Level level) {
		super(new Texture(Gdx.files.internal("gameObjects/crate.png")), 60, 60, x, y, level, true);
	}

	@Override
	public void action() {
		
	}
}
