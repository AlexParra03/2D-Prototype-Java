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

    BitmapFont font = new BitmapFont();
    ShapeRenderer boxes = new ShapeRenderer();
    private String text;
    
    private final int X = 200;
    private final int Y = 300;
    private final int WIDTH = 400;
    private final int HEIGHT = 70;

    private String message;
    public boolean visible;
    
    InputScanner(){
        this.text = "";
        this.message = "";
        this.visible = false;
        font.setColor(0,0,0,1);
    }
    
    public void show(String msg){
        this.message = msg;
        this.visible = true;
    }
    
    public void close(){
        visible = false;
    }
    
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

    void backspace() {
        if(this.text.length() > 0){
            this.text = this.text.substring(0, text.length()-1);
        }
    }
    
}
