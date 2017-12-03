
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
        this.input = new InputScanner(this);
        this.inventory = new Inventory();
        this.factory = new FactoryObject(this);
        this.selectLevel(1);
        
    }
    
    public void selectLevel(int levelId){
        if(Level.currentLevel != levelId){
            if(this.objects != null){
                for(GameObject object : this.objects){
                    if(object != null){
                        object.dispose();
                    }
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
            }
            
            // ---------------------------------
            Level.currentLevel = levelId;
            this.player.setGameObjects(this.objects);
        }
    }
    
    public void buildLevelFour(){
        this.map = new TileMap(30,20);
        this.objects = new Array<GameObject>();
        
        
        Callback functionOne = new Callback(){
            @Override
            public void action(Level level) {
                level.dialog.show("All the things");
                
            }
            
        };
        

        
        Callback functionTwo = new Callback(){
            @Override
            public void action(Level level) {
                
                
            Callback functionThree = new Callback(){
                @Override
                public void action(Level level) {
                    String inputFromText = level.input.text;
                    if(inputFromText.equals("3")){
                        level.objects.add( factory.createKey(300, 130, 1) );
                    }

                }
            
        };
                
                level.input.show("Convert 11 to Decimal", functionThree);
                
            }
            
        };
        
        Callback functionThree = new Callback(){
            @Override
            public void action(Level level) {
                String inputFromText = level.input.text;
                if(inputFromText.equals("3")){
                    level.objects.add( factory.createKey(300, 130, 1) );
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
        
        objects.add(null);
        
        objects.add( factory.create("rock", 45, 90)  );
        
        objects.add( factory.create("computer", 200, 90, functionTwo)  );
        
        objects.add( factory.create("computer", 300, 90, functionThree)  );
        
        objects.add( factory.create("barrel", 100, 90, functionOne)  );
        
        objects.add( factory.createDoor("up", 100, 300, teleport, 1 ) );
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
                level.input.show("Type the answer here?");
            }
        };
        
        Callback function2 = new Callback(){
            @Override
            public void action(Level level) {
                String textFromInput = level.input.text;
                if(textFromInput.equals("CAT")){
                    level.objects.add( level.factory.createKey( 180, 120, 2) );
                }
                //level.selectLevel(4);
            }
        };
        
        objects.add( factory.create("computer", 30, 30, function1)  );
        objects.add( factory.create("tree blue", 400, 100, function2));
        
        
        objects.add( factory.createDoor("up", 100, 160, 1) );
        
    }
    
    public void buildLevelOne(){
        
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
        
        this.objects.add(factory.createDoor("up", 400, 400, 4));
        this.objects.add(factory.create("computer", 200, 200, function1));
        this.objects.add(factory.createKey( 300, 200, 3));
        this.objects.add(factory.createKey(500, 300, 4));
        

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
        this.objects.add(factory.createKey( 330, 200, 5));
        this.objects.add(factory.createKey( 500, 340,6));
        this.map.map[5][5] = 3;
        this.map.map[6][6] = 3;
        
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
