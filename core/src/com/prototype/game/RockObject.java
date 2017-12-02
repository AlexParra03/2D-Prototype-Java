package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * A rock object
 * @author Group 3
 *
 */
public class RockObject extends GameObject {
	
	/**
	 * Creates a rock object at the given coordinates
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param level The level to create the rock in
	 */
	public RockObject(int x, int y, Level level) {
		super(new Texture(Gdx.files.internal("gameObjects/rock.png")), 32, 32, x, y, level, true);
	}

	@Override
	public void action() {
		
	}
}
