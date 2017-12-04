/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author alexu
 */
public class InputScanner implements RenderableObject {

    // Batches used to render
    BitmapFont font = new BitmapFont();
    ShapeRenderer boxes = new ShapeRenderer();
    // Input text
    protected String text;
    
    // Coordinates of the input box
    private final int X = 200;
    private final int Y = 300;
    private final int WIDTH = 400;
    private final int HEIGHT = 70;

    // Reference to the level for callback purposes
    private Level level;
    // Function to be executed when closed
    private Callback callback;
    // Message being shown when opened
    private String message;
    
    public boolean visible;
    
    /**
     * Initializes fields
     * @param level reference to the level for callback purposes
     */
    InputScanner(Level level){
        this.text = "";
        this.message = "";
        this.visible = false;
        font.setColor(0,0,0,1);
        this.level = level;
    }
    
    /**
     * Creates an input box reading input and showing the message
     * @param msg message to be shown
     */
    public void show(String msg){
        if(!this.visible){
            this.text = "";
            this.message = msg;
            this.visible = true;
        }
    }
    
    /**
     * Creates a input box reading input and showing message
     * @param msg message to be shown
     * @param callback function to be executed when closed
     */
    public void show(String msg, Callback callback){
        if(!this.visible){
            this.text = "";
            this.message = msg;
            this.visible = true;
            this.callback = callback;
        }
    }
    
    /**
     * Closes the dialog box and executes callback
     */
    public void close(){
        visible = false;
        if(this.callback != null){
            callback.action(level);
            this.callback = null;
        }
    }
    
    /**
     * Adds one letter/character to the input text
     * @param c character to be added
     */
    public void addCharacter(char c){
        if(this.text.length() < 35){
            this.text += c;
        }
    }
    
    @Override
    public void render(SpriteBatch batch) {
       if(this.visible){
            batch.end();
            
            boxes.begin(ShapeRenderer.ShapeType.Filled);
            //Drawing background with black border
            boxes.setColor(0, 0, 0, 1);
            boxes.rect(X, Y, WIDTH, HEIGHT);
            boxes.setColor(200,200,200,1);
            boxes.rect(X+4, Y+4, WIDTH-8, HEIGHT-8);
            
            boxes.end();
            batch.begin();
            font.draw(batch, this.message, X+ 14, Y+HEIGHT-10);
            font.draw(batch, this.text, X + 14, Y+HEIGHT - 30);
            font.draw(batch, "Press ENTER to close.", X + 14, Y+HEIGHT - 50);

            
        }    }

    @Override
    public void dispose() {
        boxes.dispose();
        font.dispose();
    }

    /**
     * removes last character from input text
     */
    void backspace() {
        if(this.text.length() > 0){
            this.text = this.text.substring(0, text.length()-1);
        }
    }
    
}
