
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
    InputScanner input;
    Inventory inventory;
    Key[] keys;
    protected static int currentLevel = -1;
    private FactoryObject factory;
    
    
    public Level(){
        this.player = new Player();
        this.dialog = new Dialog();
        this.input = new InputScanner();
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
                case 3:
                    buildLevelThree();
                    break;
                case 4:
                    buildLevelFour();
                    break;
                case 5:
                	buildlevelFive();
                	break;
                case 6:
                	buildlevelSix();
                	break;
                case 7:
                	buildlevelSeven();
                	break;
                
                
                	
            }
            
            // ---------------------------------
            Level.currentLevel = levelId;
            this.player.setGameObjects(this.objects);
        }
    }
    //new level 7
    public void buildlevelSeven(){
        this.map = new TileMap(30,20);
        this.objects = new Array<GameObject>();
        
        
        Callback functionOne = new Callback(){
            @Override
            public void action(Level level) {
                level.dialog.show("Welcome to level 7");
                
            }
            
        };
        
        Callback functionTwo = new Callback(){
            @Override
            public void action(Level level) {
                level.input.show("Convert (111111) 2   to decimal");
                level.dialog.show("When you are done check with the other computer");
                
            }
            
        };
        
        Callback functionThree = new Callback(){
            @Override
            public void action(Level level) {
                String inputFromText = level.input.text;
                if(inputFromText.equals("63")){
                    level.objects.add( factory.create("key", 700, 130) );
                }
                
            }
            
        };
        
        Callback teleport = new Callback(){
            @Override
            public void action(Level level) {
                level.player.x = 0;
                level.player.y = 300;
                
            }
            
        };
        objects.add( factory.create("rock", 100, 90)  );
        objects.add( factory.create("rock", 120, 90)  );
        objects.add( factory.create("rock", 140, 90)  );
        objects.add( factory.create("rock", 160, 90)  );
        objects.add( factory.create("rock", 180, 90)  );
        objects.add( factory.create("rock", 200, 90)  );
        objects.add( factory.create("rock", 220, 90)  );
        objects.add( factory.create("rock", 240, 90)  );
        objects.add( factory.create("rock", 260, 90)  );
        objects.add( factory.create("rock", 280, 90)  );
        objects.add( factory.create("rock", 300, 90)  );
        objects.add( factory.create("rock", 320, 90)  );
        objects.add( factory.create("rock", 340, 90)  );
        objects.add( factory.create("rock", 360, 90)  );
        objects.add( factory.create("rock", 380, 90)  );
        objects.add( factory.create("rock", 400, 90)  );
        objects.add( factory.create("rock", 420, 90)  );
        objects.add( factory.create("rock", 440, 90)  );
        objects.add( factory.create("rock", 460, 90)  );
        objects.add( factory.create("rock", 480, 90)  );
        objects.add( factory.create("rock", 500, 90)  );
        objects.add( factory.create("barrel", 90, 90 )  );
        objects.add( factory.create("barrel", 520, 90)  );
        objects.add( factory.create("rock", 100, 400)  );
        objects.add( factory.create("rock", 120, 400)  );
        objects.add( factory.create("rock", 140, 400)  );
        objects.add( factory.create("rock", 160, 400)  );
        objects.add( factory.create("rock", 180, 400)  );
        objects.add( factory.create("rock", 200, 400)  );
        objects.add( factory.create("rock", 220, 400)  );
        objects.add( factory.create("rock", 240, 400)  );
        objects.add( factory.create("rock", 260, 400)  );
        objects.add( factory.create("rock", 280, 400)  );
        objects.add( factory.create("rock", 300, 400)  );
        objects.add( factory.create("rock", 320, 400)  );
        objects.add( factory.create("rock", 340, 400)  );
        objects.add( factory.create("rock", 360, 400)  );
        objects.add( factory.create("rock", 380, 400)  );
        objects.add( factory.create("rock", 400, 400)  );
        objects.add( factory.create("rock", 420, 400)  );
        objects.add( factory.create("rock", 440, 400)  );
        objects.add( factory.create("rock", 460, 400)  );
        objects.add( factory.create("rock", 480, 400)  );
        objects.add( factory.create("rock", 500, 400)  );
        objects.add( factory.create("barrel", 90, 600, functionOne)  );
        objects.add( factory.create("barrel", 520, 600)  );

        
        objects.add( factory.create("computer", 600, 200, functionTwo)  );
        
        objects.add( factory.create("computer", 400, 200, functionThree)  );
        
        
        objects.add( factory.createDoor("up", 100, 300, teleport, 1 ) );
    }
    // new level 6
    public void buildlevelSix(){
        this.map = new TileMap(30,20);
        this.objects = new Array<GameObject>();
        
        
        Callback functionOne = new Callback(){
            @Override
            public void action(Level level) {
                level.dialog.show("Welcome to level 6");
                
            }
            
        };
        
        Callback functionTwo = new Callback(){
            @Override
            public void action(Level level) {
                level.input.show("Convert (11001011) 2  to decimal");
                level.dialog.show("When you are done check with the other computer");
                
            }
            
        };
        
        Callback functionThree = new Callback(){
            @Override
            public void action(Level level) {
                String inputFromText = level.input.text;
                if(inputFromText.equals("203")){
                    level.objects.add( factory.create("key", 700, 130) );
                }
                
            }
            
        };
        
                 
                
        objects.add( factory.create("rock", 100, 400)  );
        objects.add( factory.create("rock", 120, 400)  );
        objects.add( factory.create("rock", 140, 400)  );
        objects.add( factory.create("rock", 160, 400)  );
        objects.add( factory.create("rock", 180, 400)  );
        objects.add( factory.create("rock", 200, 400)  );
        objects.add( factory.create("rock", 220, 400)  );
        objects.add( factory.create("rock", 240, 400)  );
        objects.add( factory.create("rock", 260, 400)  );
        objects.add( factory.create("rock", 280, 400)  );
        objects.add( factory.create("rock", 300, 400)  );
        objects.add( factory.create("rock", 320, 400)  );
        objects.add( factory.create("rock", 340, 400)  );
        objects.add( factory.create("rock", 360, 400)  );
        objects.add( factory.create("rock", 380, 400)  );
        objects.add( factory.create("rock", 400, 400)  );
        objects.add( factory.create("rock", 420, 400)  );
        objects.add( factory.create("rock", 440, 400)  );
        objects.add( factory.create("rock", 460, 400)  );
        objects.add( factory.create("rock", 480, 400)  );
        objects.add( factory.create("rock", 500, 400)  );
        objects.add( factory.create("barrel", 90, 400, functionOne)  );
        objects.add( factory.create("barrel", 520, 400)  );

        
        objects.add( factory.create("computer", 600, 200, functionTwo)  );
        
        objects.add( factory.create("computer", 400, 200, functionThree)  );
        
        
        objects.add( factory.createDoor("up", 100, 300, 7 ) );
    }
    // new level 5
    public void buildlevelFive(){
        this.map = new TileMap(30,20);
        this.objects = new Array<GameObject>();
        
        
        Callback functionOne = new Callback(){
            @Override
            public void action(Level level) {
                level.dialog.show("Welcome to level 5");
                
            }
            
        };
        
        Callback functionTwo = new Callback(){
            @Override
            public void action(Level level) {
                level.input.show("Convert (1 0101 1111)2 to decimal");
                level.dialog.show("When you are done check with the other computer");
                
            }
            
        };
        
        Callback functionThree = new Callback(){
            @Override
            public void action(Level level) {
                String inputFromText = level.input.text;
                if(inputFromText.equals("351")){
                    level.objects.add( factory.create("key", 700, 130) );
                }
                
            }
            
        };
        
              
        objects.add( factory.create("rock", 100, 90)  );
        objects.add( factory.create("rock", 120, 90)  );
        objects.add( factory.create("rock", 140, 90)  );
        objects.add( factory.create("rock", 160, 90)  );
        objects.add( factory.create("rock", 180, 90)  );
        objects.add( factory.create("rock", 200, 90)  );
        objects.add( factory.create("rock", 220, 90)  );
        objects.add( factory.create("rock", 240, 90)  );
        objects.add( factory.create("rock", 260, 90)  );
        objects.add( factory.create("rock", 280, 90)  );
        objects.add( factory.create("rock", 300, 90)  );
        objects.add( factory.create("rock", 320, 90)  );
        objects.add( factory.create("rock", 340, 90)  );
        objects.add( factory.create("rock", 360, 90)  );
        objects.add( factory.create("rock", 380, 90)  );
        objects.add( factory.create("rock", 400, 90)  );
        objects.add( factory.create("rock", 420, 90)  );
        objects.add( factory.create("rock", 440, 90)  );
        objects.add( factory.create("rock", 460, 90)  );
        objects.add( factory.create("rock", 480, 90)  );
        objects.add( factory.create("rock", 500, 90)  );
        objects.add( factory.create("barrel", 90, 90, functionOne)  );
        objects.add( factory.create("barrel", 520, 90)  );

        
        objects.add( factory.create("computer", 600, 200, functionTwo)  );
        
        objects.add( factory.create("computer", 400, 200, functionThree)  );
        
        
        objects.add( factory.createDoor("up", 100, 300, 6 ) );
    }
    
    public void buildLevelFour(){
        this.map = new TileMap(30,20);
        this.objects = new Array<GameObject>();
        
        
        Callback functionOne = new Callback(){
            @Override
            public void action(Level level) {
                level.dialog.show("Welcome to level four");
                
            }
            
        };
        
        Callback functionTwo = new Callback(){
            @Override
            public void action(Level level) {
                level.input.show("Convert (10010) 2  to Decimal");
                level.dialog.show("When you are done check with the other computer");
                
            }
            
        };
        
        Callback functionThree = new Callback(){
            @Override
            public void action(Level level) {
                String inputFromText = level.input.text;
                if(inputFromText.equals("18")){
                    level.objects.add( factory.create("key", 300, 130) );
                }
                
            }
            
        };
                           
                
        objects.add( factory.create("rock", 45, 90)  );
        
        objects.add( factory.create("computer", 200, 90, functionTwo)  );
        
        objects.add( factory.create("computer", 300, 90, functionThree)  );
        
        objects.add( factory.create("barrel", 100, 90, functionOne)  );
        
        objects.add( factory.createDoor("up", 100, 300,  5 ) );
    }
    
    public void buildLevelThree(){
        this.map = new TileMap(30, 20);
        this.map.map[5][5] = 3;
        this.objects = new Array<GameObject>();
        
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
                level.player.x = 400;
                level.player.y = 400;
                level.map.map[7][7] = 4;
                level.input.show("Convert (1 1011) 2 to decimal");
            }
        };
        
        Callback function2 = new Callback(){
            @Override
            public void action(Level level) {
                String textFromInput = level.input.text;
                if(textFromInput.equals("27")){
                    level.objects.add( level.factory.create("key", 180, 120) );
                }
                level.selectLevel(4);
            }
        };
        
        objects.add( factory.create("computer", 330, 100, function1)  );
        objects.add( factory.create("box", 430, 100, function2));
        
        
        objects.add( factory.createDoor("up", 400, 400, 4) );
        
    }
    /**
     * Constructs the second level
     */
    /**
     * Constructs the first level
     */

    public void buildLevelTwo(){
        this.map = new TileMap(30, 20);
        for(int i = 0; i < this.map.map.length; i++) {
        	for(int j = 0; j < this.map.map[0].length; j++) {
        		this.map.map[i][j] = 9;
        	}
        }
        this.objects = new Array<GameObject>();
        this.player.x = Gdx.graphics.getWidth()/2 - 16;
        this.player.y = 0;
        
        this.hints.setType("number conversion operation");
        
        this.dialog.show("Welcome to the next level number conversion! ");
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("What is the value of(1 000 111) 2 + (111 0111) 2"
               		+ "on binary number ", new Callback() {

				@Override
				public void action(Level level) {
					if(level.input.text.equals("10111110")) {
						level.objects.get(2).dispose();
						level.objects.removeIndex(2);
						level.objects.add(level.factory.createKey(300, 300, 1));
						level.dialog.close();
						level.dialog.show("The key has appeared! Grab it and unlock the door then walk through.");
					}
				}
            	   
               });
               level.dialog.show("If your answer is correct, then the box will open to reveal a key.");
            }
            
        };
        

        this.objects.add(factory.createDoor("up", Gdx.graphics.getWidth()/2 - 32, Gdx.graphics.getHeight()-64, 2));
        this.objects.add(factory.create("computer", 200, 200, function1));
        this.objects.add(factory.create("box", 300, 300));
        this.objects.add(factory.create("rock", 45, 15));
        this.objects.add(factory.create("tree blue", 135, 450));
        this.objects.add(factory.create("tree blue", 450, 70));
        this.objects.add(factory.create("tree blue", 500, 400));
        this.objects.add(factory.create("rock", 350, 200));
        this.objects.add(factory.create("rock", 600, 300));

    }
    
    
    public void buildLevelOne(){
        
        this.map = new TileMap(30, 20);
        this.objects = new Array<GameObject>();
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Hello, Welcome to Binary and Boolean Number Game");
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
