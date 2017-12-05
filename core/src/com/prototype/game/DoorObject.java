/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;



public class DoorObject extends GameObject{

    private int levelDestination;
    
    public DoorObject(Texture texture, int width, int height, int x, int y, Level level, boolean collidable, Callback callback, int levelDestination) {
        super(texture, width, height, x, y, level, collidable, callback);
        this.levelDestination = levelDestination;
    }


    @Override
    public void action(){
        if (callback != null){
            callback.action(this.level);
        }
        if(level.inventory.keys != null){
            
            boolean doorOpened = false;
            for(Key key : level.inventory.keys ){
                if(key.levelDestination == this.levelDestination){
                    level.selectLevel(this.levelDestination);
                    doorOpened = true;
                    break;
                }
            }
            if(!doorOpened){
                for(Key key : level.inventory.keys ){
                    if(!key.used){
                        key.levelDestination = this.levelDestination;
                        key.used = true;
                        break;
                    }
                }
            }
        }

    }
    
}
