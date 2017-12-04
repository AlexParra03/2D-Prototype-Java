package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

/**
 * Hints for the puzzles in each level
 * @author Group 3
 *
 */
public class Hint implements RenderableObject {

	//X value for the button
	public final int X = 30;
	//Y value for the button
	public final int Y = 565;
	//The total radius of the button
	public final int TOTAL_RADIUS = 24;
	//To create the button shapes
	private ShapeRenderer circle;
	//The texture for the button
	private Texture icon;
	//Contains all the hints to be displayed
	private Array<String> hints;
	//The level being used
	private Level level;
	//The hint type
	private String type;
	
	/**
	 * Creates a Hint object
	 * @param dialog The dialog object to generate text on screen
	 */
	public Hint(Level level) {
		this.level = level;
		icon = new Texture(Gdx.files.internal("icons/Question Mark.png"));
		circle = new ShapeRenderer();
		hints = new Array<String>(10);
		type = "";
		hints.add("Binary-Decimal Conversion: To convert a binary number into decimal, you must add exponents of 2. "
				+ "Call the right position 0 and increment that number by 1 for each position up to the beginning of the number. "
				+ "For each position with a 1, calculate 2 raised to the power of that position number and add all of them together. "
				+ "This number is the decimal representation of the binary number. "
				+ "Ex: (1010) = 2^3 + 2^1 = 8 + 2 = 10");
	}
	
	/**
	 * Sets the hint type to the given hint type
	 * @param type The type of hint
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Sets the hint for the given level to the given string
	 * @param levelNum The level number for the hint
	 * @param newHint The hint to add to the level
	 */
	public void setHint(int levelNum, String newHint) {
		hints.set(levelNum-1, newHint);
	}
	
	/**
	 * Returns the hint
	 * @return The hint string
	 */
	public String getHint() {
		if(type.equals("number conversion")) {
			return hints.get(0);
		} else if(type.equals("boolean algebra")) {
			return hints.get(1);
		} else {
			return "";
		}
			
	}
	
	/**
	 * Shows the hint for the given level
	 */
	public void show() {
		level.dialog.show(getHint());
	}
	
	@Override
	/**
	 * Renders the hint button on the screen
	 */
	public void render(SpriteBatch batch) {
		batch.end();
		circle.begin(ShapeRenderer.ShapeType.Filled);
		circle.setColor(Color.BLACK);
		circle.circle(X, Y, 24);
		circle.setColor(Color.BLUE);
		circle.circle(X - 1, Y, 20);
		circle.end();
		batch.begin();
		batch.draw(icon, X - 16, Y - 16);
	}

	@Override
	/**
	 * Disposes of the objects used by the hint class
	 */
	public void dispose() {
		icon.dispose();
		circle.dispose();
	}

}
