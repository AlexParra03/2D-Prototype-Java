package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

/**
 * Hints for the puzzles in each level.
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
	//Whether the button is visible or not
	public boolean visible;
	
	/**
	 * Creates a Hint object
	 * @param dialog The dialog object to generate text on screen
	 */
	public Hint(Level level) {
		this.level = level;
		this.visible = false;
		icon = new Texture(Gdx.files.internal("icons/Question Mark.png"));
		circle = new ShapeRenderer();
		hints = new Array<String>(10);
		type = "";
		hints.add("Binary-Decimal Conversion: To convert a binary number into decimal, you must add exponents of 2. "
				+ "Call the right position 0 and increment that number by 1 for each position up to the beginning of the number. "
				+ "For each position with a 1, calculate 2 raised to the power of that position number and add all of them together. "
				+ "This number is the decimal representation of the binary number. "
				+ "Ex: (1010) = 2^3 + 2^1 = 8 + 2 = 10");
		hints.add("Simple Boolean Algebra: When working with boolean values, you only have the digits 0 and 1. "
				+ "Some properties that occur in decimal mathematics is similar to what occurs in boolean algebra. "
				+ "ADDING: {0+1=1, 1+0=1, 0+0=0, 1+1=1} MULTIPLICATION: {0*1=0, 1*0=0, 0*0=0, 1+1=1}");
		hints.add("Adding Two Binary Numbers: "
				+ "Working in base 10, you add one column at a time and if the numbers in the column add up to at least ten, then you carry the 1 to the next column "
				+ "and leave the ones digit in the first column. "
				+ "The process is the same in base 2 except you carry over when you add up to atleast 2. "
				+ "EX: (11) + (11) STEP 1: Add first column 1 + 1 = 2 = (10) so carry the 1 to the next column and put the 0 as the answer for the first column. "
				+ "STEP 2: Add the second column, plus that carried one. 1 + 1 + 1 = 3 = 11 No more columns so this number is written down making the final answer 110.");
		hints.add("Boolean Algebra Identities: "
				+ "Call x a boolean value of 0 or 1 and ~x the opposite value. "
				+ "EX: if x = 0, then ~x = 1. "
				+ "ADDITIVE IDENTITIES: x+0=x, x+1=1, x+x=x,x+~x=1 "
				+ "MULTIPLICATIVE IDENTITIES: x*0=0, x*1=x, x*x=x, x*~x=0");
	}
	
	/**
	 * Sets the hint type to the given hint type
	 * @param type The type of hint
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Returns the hint
	 * @return The hint string
	 */
	public String getHint() {
		if(type.equals("number conversion")) {
			return hints.get(0);
		} else if(type.equals("simple boolean algebra")) {
			return hints.get(1);
		} else if(type.equals("binary addition")) {
			return hints.get(2);
		} else if(type.equals("boolean identities")) {
			return hints.get(3);
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
		if(visible) {
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
