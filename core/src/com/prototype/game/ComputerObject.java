/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ComputerObject extends GameObject {
    
    // Different animation textures
    private Texture[] states;
    // Current frame to be rendered
    private int stateIndex;
    
    private boolean on = false;
    private final double LOAD_TIME = 2.4;
    private double timeEllapsed = 0;
    

    public ComputerObject(Texture offText, Texture onText, Texture idleText, int width, int height, int x, int y, Level level, boolean collidable, Callback callback) {
        super(offText, width, height, x, y, level, collidable, callback);
        this.states = new Texture[3];
        
        this.states[0] = offText;
        this.states[1] = onText;
        this.states[2] = idleText;
        this.stateIndex = 0;
    }
    
    @Override
    public void render(SpriteBatch batch) {
        if(on && this.stateIndex != 2){
            timeEllapsed += Gdx.graphics.getDeltaTime();
        }
        
        if(timeEllapsed > LOAD_TIME){
            this.stateIndex = 2;
        }
        
        if(this.states[stateIndex] != null){
            batch.draw(this.states[stateIndex], x, y);
        }
    }
    
    @Override
    public void dispose() {
        for(Texture texture : states){
            if(texture != null){
                texture.dispose();
            }
        }
    }
    
    @Override
    public void action(){
        if(!on){
            on = true;
            this.stateIndex = 1;
        }
        if(this.callback != null){
            this.callback.action(this.level);
        }
        
    }

    
}
