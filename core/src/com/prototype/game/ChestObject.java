/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.graphics.Texture;


public class ChestObject extends GameObject {

    public ChestObject(Texture texture, int width, int height, int x, int y, Level level, boolean collidable, Callback callback) {
        super(texture, width, height, x, y, level, collidable, callback);
    }

    
}
