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
    private int keyIdBinded;
    
    public DoorObject(Texture texture, int width, int height, int x, int y, Level level, boolean collidable, Callback callback, int levelDestination) {
        super(texture, width, height, x, y, level, collidable, callback);
        this.levelDestination = levelDestination;
        this.keyIdBinded = -1;
    }


    @Override
    public void action(){
        if (callback != null){
            callback.action(this.level);
        }
        if(keyIdBinded == -1){
            if(level.inventory.keys != null){
                for(Key key : level.inventory.keys ){
                    if(!key.used){
                        key.used = true;
                        this.keyIdBinded = key.id;
                        break;
                    }
                }
            }
        }else{
            //level.selectLevel(levelDestination);
        }
    }
    
}
