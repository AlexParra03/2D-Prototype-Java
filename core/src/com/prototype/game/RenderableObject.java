
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface RenderableObject {
    public void render(SpriteBatch batch);
    public void dispose();
}
