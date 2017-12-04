
package com.prototype.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameObject implements RenderableObject{
    
    // Collision dimensions
    int width, height;
    // Position coordinates
    int x,y;
    // Image to render
    Texture texture;
    // Reference to the level for callback purposes
    Level level;
    // Is a solid object
    boolean collidable;
    // Function to be executed after collision`
    Callback callback;
    
    /**
     * Creates a game object visible on the game
     * @param texture picture to be rendered
     * @param width width of the collision box
     * @param height height of the collision box
     * @param x x position of the object
     * @param y y position of the object
     * @param level reference of the level for callback purposes
     * @param collidable is a solid object
     * @param callback callback to be executed
     */
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
    
    /**
     * Default callback execution when colliding
     */
    public void action(){
        if (callback != null){
            callback.action(this.level);
        }
    }
    
}
