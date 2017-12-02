
package com.prototype.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class GameObject implements RenderableObject{

    int width;
    int height;
    int x,y;
    Texture texture;
    Level level;
    boolean collidable;
    
    public GameObject(Texture texture, int width, int height, int x, int y, Level level, boolean collidable){
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.level = level;
        this.collidable = collidable;
    }
    
    public void changeTexture(Texture newTexture) {
    	this.texture = newTexture;
    }
    
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
    
    public abstract void action();
    
}
