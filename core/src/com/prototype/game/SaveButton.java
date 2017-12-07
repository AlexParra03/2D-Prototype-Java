package com.prototype.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * The button used to save
 * @author Group 3
 *
 */
public class SaveButton implements RenderableObject {
	
	//To create the button
	private ShapeRenderer box;
	//To create the text
	private BitmapFont font;
	
	//Whether the button is visible
	public boolean visible;
	
	//Width of the save button
	public final int WIDTH = 80;
	//Height of the save button
	public final int HEIGHT = 40;
	//X value of the save button
	public final int X = 675;
	//Y value of the save button
	public final int Y = 550;
	
	
	/**
	 * Creates a new save button object
	 */
	public SaveButton() {
		this.visible = false;
		this.box = new ShapeRenderer();
		this.font = new BitmapFont();
	}
	
	@Override
	/**
	 * Renders the save button if it is visible
	 */
	public void render(SpriteBatch batch) {
		if(visible) {
			batch.end();
			box.begin(ShapeRenderer.ShapeType.Filled);
			box.setColor(Color.BLACK);
			box.rect(X, Y, WIDTH, HEIGHT);
			box.setColor(Color.BLUE);
			box.rect(X+2, Y+2, WIDTH - 4, HEIGHT - 4);
			box.end();
			batch.begin();
			font.setColor(Color.WHITE);
			font.draw(batch, "SAVE", X + 20, Y + 25);
		}
		
		
		
	}

	@Override
	/**
	 * Disposes of the components used by the save button
	 */
	public void dispose() {
		box.dispose();
		font.dispose();
		
	}

}