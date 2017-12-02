/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author alexu
 */
public class InputScanner implements RenderableObject {

    private String text;
    
    public boolean visible;
    
    InputScanner(){
        this.text = "";
    }
    
    public String returnText(){
        String output = this.text;
        this.text = "";
        return output;
    }
    
    public void addCharacter(char c){
        this.text += c;
    }
    
    @Override
    public void render(SpriteBatch batch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
