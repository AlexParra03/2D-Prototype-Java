
package com.prototype.game;

import com.badlogic.gdx.graphics.Texture;


public class TreeObject extends GameObject {

    public TreeObject(Texture texture, int width, int height, int x, int y, Level level, boolean collidable, Callback callback) {
        super(texture, width, height, x, y, level, collidable,  callback);
    }

    
}
