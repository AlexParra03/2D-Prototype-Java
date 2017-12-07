package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MiniMap implements RenderableObject {
	
	//The textures for the maps
	private Texture[] maps;
	//The level
	private Level level;
	//Whether the map is visible or not
	public boolean visible;
	//The x value for the map
	private final int X = 700;
	//The y value for the map
	private final int Y = 50;
	
	/**
	 * Creates a minimap with the given level
	 * @param level The level for the minimap
	 */
	public MiniMap(Level level) {
		this.level = level;
		this.visible = false;
		maps = new Texture[10];
		for(int i = 1; i <= maps.length; i++) {
			maps[i-1] = new Texture(Gdx.files.internal("maps/map" + i + ".png"));
		}
	}
	
	@Override
	/**
	 * Renders the minimap on screen if it is visible
	 */
	public void render(SpriteBatch batch) {
		if(visible) {
			batch.draw(maps[level.currentLevel - 1], X, Y);
		}
		
	}

	@Override
	/**
	 * Disposes of all map textures
	 */
	public void dispose() {
		for(Texture map : maps) {
			map.dispose();
		}
		
	}

}
