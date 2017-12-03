
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;


/**
 * Creates a new Level, essentially containg all data for each level, loading the levels, and saving/loading levels
 * @author Group 3
 *
 */
public class Level implements RenderableObject {
	//The player
    Player player;
    //The background
    TileMap map;
    //The in-game objects
    Array<GameObject> objects;
    //The dialog box
    Dialog dialog;
    //The input box
    InputScanner input;
    //The on-screen inventory
    Inventory inventory;
    //The hints for each level
    Hint hints;
    //The current level that the player is in
    protected static int currentLevel = -1;
    //A factory to create game objects
    private FactoryObject factory;
    
    
    /*
     * Initializes all components and loads level 1
     */
    public Level(){
        this.player = new Player();
        this.dialog = new Dialog();
        this.input = new InputScanner();
        this.inventory = new Inventory();
        this.hints = new Hint(this);
        this.factory = new FactoryObject(this);
        this.selectLevel(1);
        
    }
    
    /**
     * Builds the level that is given in the parameter
     * @param levelId The level to load
     */
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
            this.saveGame();
        }
    }
    
    /**
     * Constructs the first level
     */
    public void buildLevelOne(){
        this.map = new TileMap(30, 20);
        for(int i = 0; i < this.map.map.length; i++) {
        	for(int j = 0; j < this.map.map[0].length; j++) {
        		this.map.map[i][j] = 9;
        	}
        }
        this.objects = new Array<GameObject>();
        this.player.x = Gdx.graphics.getWidth()/2 - 16;
        this.player.y = 0;
        
        this.hints.setHint(1, "Binary-Decimal Conversion: To convert a binary number into decimal, you must add exponents of 2. "
				+ "Call the right position 0 and increment that number by 1 for each position up to the beginning of the number. "
				+ "For each position with a 1, calculate 2 raised to the power of that position number and add all of them together. "
				+ "This number is the decimal representation of the binary number. "
				+ "Ex: (1010) = 2^3 + 2^1 = 8 + 2 = 10");
        
        this.dialog.show("Welcome to the maze! "
        		+ "The way this works is quite simple, you must simply solve the puzzles in each room in order to escape. "
        		+ "Solving each puzzle will give you a key. Use that key to open the door and continue into the maze. "
        		+ "If you require help on figuring out how to solve the puzzles, a hint button is located in the top left corner. "
        		+ "This first puzzle involves converting binary to decimal, so walk up to the computer to get started.");
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Convert 10 to decimal");
               level.dialog.show("If your answer is correct, then open the box to get a key.");
            }
            
        };
        
        Callback function2 = new Callback(){
            @Override
            public void action(Level level) {
               if(level.input.text.equals("2")) {
            	   level.objects.add(level.factory.create("key", 300, 300));
            	   level.objects.removeIndex(2);
               }
            }
            
        };
        
        this.objects.add(factory.createDoor("up", Gdx.graphics.getWidth()/2 - 32, Gdx.graphics.getHeight()-64, 2));
        this.objects.add(factory.create("computer", 200, 200, function1));
        this.objects.add(factory.create("box", 300, 300, function2));
        this.objects.add(factory.create("rock", 45, 15));
        this.objects.add(factory.create("tree green", 135, 450));
        this.objects.add(factory.create("tree green", 450, 70));
        this.objects.add(factory.create("tree green", 500, 400));
        this.objects.add(factory.create("rock", 350, 200));
        this.objects.add(factory.create("rock", 600, 300));

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
    	selectLevel(data.getLevel());
    }
    

    @Override
    /**
     * Renders each component onto the screen
     */
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
    /*
     * Disposes of each component used by the level class when the game is closed or when the method is called upon
     */
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
