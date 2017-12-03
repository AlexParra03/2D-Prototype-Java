
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;


public class Level implements RenderableObject {
    Player player;
    TileMap map;
    Array<GameObject> objects;
    Dialog dialog;
    InputScanner input;
    Inventory inventory;
    Key[] keys;
    Hint hints;
    protected static int currentLevel = -1;
    private FactoryObject factory;
    
    
    public Level(){
        this.player = new Player();
        this.dialog = new Dialog();
        this.input = new InputScanner();
        this.inventory = new Inventory();
        this.hints = new Hint(this);
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
            if(this.map != null){
                this.map.dispose();
            }
            
            // ADD LEVELS TO MAPING HERE --------------
            switch(levelId){
                case 1:
                    buildLevelOne();
                    break;
                case 2:
                    buildLevelTwo();
                    break;
            }
            
            // ---------------------------------
            Level.currentLevel = levelId;
            this.player.setGameObjects(this.objects);
        }
    }
    
    public void buildLevelOne(){
        
        this.map = new TileMap(30, 20);
        this.objects = new Array<GameObject>();
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Hello");
               level.loadGame();
            }
            
        };
        
        Callback function2 = new Callback(){
            @Override
            public void action(Level level) {
               level.player.x = 40;
               level.player.y = 30;
               level.dialog.show("Dialog");
            }
            
        };
        
        this.objects.add(factory.createDoor("up", 400, 400, 2));
        this.objects.add(factory.create("computer", 200, 200, function1));
        this.objects.add(factory.create("key", 300, 200));
        this.objects.add(factory.create("key", 500, 300));
        

    }
    
    private void buildLevelTwo() {

        this.map = new TileMap(30, 20);
        this.objects = new Array<GameObject>();
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Hello");
            }
            
        };
        
        Callback function2 = new Callback(){
            @Override
            public void action(Level level) {
               level.player.x = 40;
               level.player.y = 30;
               level.dialog.show("Dialog");
            }
            
        };
        
        this.objects.add(factory.createDoor("up", 500, 400, 1));
        this.objects.add(factory.create("computer", 250, 200, function1));
        this.objects.add(factory.create("key", 330, 200));
        this.objects.add(factory.create("key", 500, 340));
        this.map.map[5][5] = 3;
        this.map.map[6][6] = 3;
        
    }
    
    /**
     * Saves the current level to a JSON file to be loaded later
     */
    public void saveGame() {
    	SaveData data = new SaveData(currentLevel);
    	Json jsonWriter = new Json();
    	FileHandle writer = Gdx.files.local("SaveData/save.json");
    	writer.writeString(jsonWriter.prettyPrint(data), false);
    }
    
    /**
     * Loads the last saved level from a local JSON file
     */
    public void loadGame() {
    	FileHandle reader = Gdx.files.internal("SaveData/save.json");
    	Json jsonReader = new Json();
    	SaveData data = jsonReader.fromJson(SaveData.class ,reader.readString());
    	selectLevel(data.getLevel() + 1);
    }
    

    @Override
    public void render(SpriteBatch batch) {
        
        this.map.render(batch);
        for(GameObject object : objects){
            if(object != null){
                object.render(batch);
            }
        }
        this.player.render(batch);
        this.inventory.render(batch);
        this.dialog.render(batch);
        this.hints.render(batch);
        this.input.render(batch);
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
