
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;


public class Level implements RenderableObject {
    Player player;
    TileMap map;
    Array<GameObject> objects;
    Dialog dialog;
    Inventory inventory;
    Hint hints;
    private int curLevel;
    
    
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
    	this.inventory.reset();
    	this.curLevel = 1;
    	hints.setLevel(curLevel);
        this.map = new TileMap(30, 20, curLevel);
        this.objects = new Array<GameObject>();
        objects.add(new Door(300, 500, this, "01", false));
        objects.add( new ComputerObject(65, 400, this, true) );
        //objects.add( new ComputerObject(39, 200, this, true) );
        objects.add(new Key(420, 360, this, "01", false));
        objects.add(new Key(400, 350, this, "02", false));
        objects.add(new TreeObject(0, 200, this));
        objects.add(new CrateObject(45, 45, this));
        objects.add(new RockObject(250, 125, this));
        this.player.setGameObjects(objects);
        this.player.setXY(Gdx.graphics.getWidth()/2, 30);

    }
    
    /**
     * Return the current level
     * @return The current level
     */
    public int getCurrentLevel() {
    	return curLevel;
    }
    
    /**
     * Saves the current level to a JSON file to be loaded later
     */
    public void saveGame() {
    	SaveData data = new SaveData(curLevel);
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
    	selectLevel(data.getLevel());
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
