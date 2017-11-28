
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;


public class Level implements RenderableObject {
    Player player;
    TileMap map;
    Array<GameObject> objects;
    Dialog dialog;
    Inventory inventory;
    Hint hints;
    
    
    public Level(){
        this.player = new Player();
        this.dialog = new Dialog();
        this.inventory = new Inventory();
        this.hints = new Hint(dialog);
        this.selectLevel(1);
    }
    
    public void selectLevel(int levelId){
        switch(levelId){
            case 1:
                buildLevelOne();
                break;
        }
    }
    
    private void buildLevelOne(){
    	hints.setLevel(1);
        this.map = new TileMap(30, 20);
        this.objects = new Array<GameObject>();
        objects.add( new ComputerObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")),50, 50, 65, 400, this, true) );
        objects.add( new ComputerObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")),50, 50, 39, 200, this, true) );
        this.player.setGameObjects(objects);
        objects.add(new Key(new Texture(Inventory.KEY), 32, 32, 400, 350, this, "01", false, false));
        objects.add(new Key(new Texture(Inventory.KEY), 32, 32, 40, 200, this, "02", false, false));
    }
    

    @Override
    public void render(SpriteBatch batch) {
        
        this.map.render(batch);
        for(GameObject object : objects){
            object.render(batch);
        }
        this.player.render(batch);
        this.inventory.render(batch);
        this.hints.render(batch);
        this.dialog.render(batch);
    }

    @Override
    public void dispose() {
        this.map.dispose();
        for(GameObject object : objects){
            object.dispose();
        }
        this.player.dispose();
        this.inventory.dispose();
        this.hints.dispose();
        this.dialog.dispose();
    }
    
    
    
    
}
