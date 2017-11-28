package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

/**
 * Class for the inventory that displays keys obtained in the order in which they were obtained
 * @author Group 3
 *
 */
public class Inventory implements RenderableObject{

	//The container to hold the keys
	Array<Key> keys;
	//Creates the boxes for the inventory display
	ShapeRenderer box;
	//Creates the text for the key IDs
	BitmapFont font;
	//The width of the inner boxes
	private static final int BOXWIDTH = 40;
	//The height of the inner boxes
	private static final int BOXHEIGHT = 40;
	//Width from each left box edge to key texture 
	private static final int KEYX = 6;
	//Height from bottom of the screen to the key texture
	private static final int KEYY = 12;
	//Width from left side of box to text
	private static final int FONTX = 14;
	//Height from bottom of screen to text
	private static final int FONTY = 16;
	//The filehandle for the key texture
	public static final FileHandle KEY = Gdx.files.internal("gameObjects/key.png");
	
	/**
	 * Creates the inventory
	 */
	public Inventory() {
		keys = new Array<Key>();
		font = new BitmapFont();
		box = new ShapeRenderer();
	}
	
	/**
	 * Adds a key to the inventory
	 * @param key The key to be added
	 */
	public void addKey(Key key) {
		keys.add(key);
	}
	
	/**
	 * Removes a key from the inventory
	 * @param key The key to be removed
	 */
	public void removeKey(Key key) {
		keys.removeValue(key, true);
	}
	
	@Override
	/**
	 * Renders an inventory box for each key in the inventory
	 */
	public void render(SpriteBatch batch) {
		//Draw boxes first
		batch.end();
		box.begin(ShapeRenderer.ShapeType.Filled);
		for(int i = 0; i < keys.size*44; i+= 44) {
			box.setColor(Color.BLACK);
			box.rect(i, 0, BOXWIDTH + 4, BOXHEIGHT + 4);
			box.setColor(Color.GRAY);
			box.rect(i+2, 2, BOXWIDTH, BOXHEIGHT);
		}
		box.end();
		batch.begin();
		//Draw keys and text
		for(int i = 0; i < keys.size; i++) {
			Key key = keys.get(i);
			key.dispose();
			batch.draw(new Texture(KEY), KEYX + (i*44), KEYY);
			font.draw(batch, key.getID(), FONTX + (i*44), FONTY);
			
		}
		
	}
	
	@Override
	/**
	 * Disposes of all the inventory components
	 */
	public void dispose() {
		for(Key key: keys) {
			key.dispose();
		}
		box.dispose();
		font.dispose();
		
	}

}
