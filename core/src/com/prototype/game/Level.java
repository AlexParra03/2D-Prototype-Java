
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;


public class Level implements RenderableObject {
    Player player;
    TileMap map;
    Array<GameObject> objects;
    Dialog dialog;
    Inventory inventory;
    Key[] keys;
    private static int currentLevel = -1;
    private FactoryObject factory;
    
    
    public Level(){
        this.player = new Player();
        this.dialog = new Dialog();
        this.inventory = new Inventory();
        this.factory = new FactoryObject(this);
        this.selectLevel(1);
        
    }
    
    public void selectLevel(int levelId){
        if(Level.currentLevel != levelId){
            if(this.objects != null){
                for(GameObject object : this.objects){
                    object.dispose();
                }
            }
            
            switch(levelId){
                case 1:
                    buildLevelOne();
                    break;
            }
            
            this.player.setGameObjects(this.objects);
        }
    }
    
    public void buildLevelOne(){
        
        this.map = new TileMap(30, 20);
        this.objects = new Array<GameObject>();
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.dialog.show("Hello");
            }
            
        };
        this.objects.add(factory.create("door side", 400, 400, function1));
        this.objects.add(factory.create("door up", 200, 400, function1));

    }
    
    

    @Override
    public void render(SpriteBatch batch) {
        
        this.map.render(batch);
        for(GameObject object : objects){
            object.render(batch);
        }
        this.player.render(batch);
        this.inventory.render(batch);
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
        this.dialog.dispose();
    }
    
    
    
    
}
