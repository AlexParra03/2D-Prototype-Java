
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;


public class Level implements RenderableObject {
    Player player;
    TileMap map;
    ArrayList<GameObject> objects;
    Dialog dialog;
    
    
    public Level(){
        this.player = new Player();
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
        this.map = new TileMap(24, 18);
        this.objects = new ArrayList<GameObject>();
        objects.add( new ComputerObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")),50, 50, 65, 400, this) );
        objects.add( new ComputerObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")),50, 50, 400, 400, this) );
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
