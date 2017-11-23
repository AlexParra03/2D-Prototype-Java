
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;


public class Level implements RenderableObject {
    Player player;
    TileMap map;
    ArrayList<GameObject> objects;
    Dialog dialog;
    
    
    public Level(){
        this.player = player;
        this.dialog = new Dialog();
        
        this.selectLevel(1);
    }
    
    public void selectLevel(int levelId){
        switch(levelId){
            case 1:
                buildLevelOne();
                break;
        }
    }
    
    public void buildLevelOne(){
        this.map = new TileMap(10,10);
        this.objects = new ArrayList<GameObject>();
        this.player.setGameObjects(objects);
    }
    

    @Override
    public void render(SpriteBatch batch) {
        
        this.map.render(batch);
        for(GameObject object : objects){
            object.render(batch);
        }
        this.player.render(batch);
        this.dialog.render(batch);
    }

    @Override
    public void dispose() {
        this.map.dispose();
        for(GameObject object : objects){
            object.dispose();
        }
        this.player.dispose();
        this.dialog.dispose();
    }
    
    
    
    
}
