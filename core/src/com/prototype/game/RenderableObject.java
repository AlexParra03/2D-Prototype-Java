
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface RenderableObject {
    /**
     * Rendering objects into the frame
     * @param batch batch used to draw textures
     */
    
    public void render(SpriteBatch batch);
    /**
     * Removing textures from memory
     */
    public void dispose();
}
