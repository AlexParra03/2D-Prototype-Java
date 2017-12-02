package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * A tree object
 * @author Group 3
 *
 */
public class TreeObject extends GameObject {
	
	/**
	 * Creates a new tree object at the given coordinates
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param level The level to put the tree into
	 */
	public TreeObject(int x, int y, Level level) {
		super(new Texture(Gdx.files.internal("gameObjects/tree2.png")), 115, 115, x, y, level, true);
		
	}

	@Override
	public void action() {
		
	}
}
