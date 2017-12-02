
package com.prototype.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameObject implements RenderableObject{

    int width;
    int height;
    int x,y;
    Texture texture;
    Level level;
    boolean collidable;
    Callback callback;
    
    public GameObject(Texture texture, int width, int height, int x, int y, Level level, boolean collidable, Callback callback){
  
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.level = level;
        this.collidable = collidable;
        this.callback = callback;
    }
    
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
    
    public void action(){
        if (callback != null){
            callback.action(this.level);
        }
    }
    
}
