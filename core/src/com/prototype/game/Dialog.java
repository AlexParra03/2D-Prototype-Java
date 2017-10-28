
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Dialog implements RenderableObject {
    BitmapFont font = new BitmapFont();
    ShapeRenderer boxes = new ShapeRenderer();
    private String message = "";
    private boolean visible = false;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    
    public Dialog(){
        boxes.setColor(50, 50, 50, 1);
    }
    
    public void show(String msg){
        this.visible = true;
        this.message = msg;
    }

    @Override
    public void render(SpriteBatch batch) {
        if(this.visible){
            batch.end();
            boxes.begin(ShapeRenderer.ShapeType.Filled);
            boxes.rect(10, 10, WIDTH, HEIGHT);
            boxes.end();
            batch.begin();
            font.draw(batch, this.message, 20, 10);
        }
    }

    @Override
    public void dispose() {
        font.dispose();
        boxes.dispose();
    }
    
}
