
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;


/**
 * Creates a new Level, essentially containing all data for each level, loading the levels, and saving/loading levels
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
    //The minimaps for each level
    MiniMap maps;
    //The current level that the player is in
    protected static int currentLevel = -1;
    //A factory to create game objects
    private FactoryObject factory;
    
    //The save button
    public SaveButton button;
    
    protected boolean onMenu = false;
    
    
    /*
     * Initializes all components and loads level 1
     */
    public Level(){
        this.player = new Player();
        this.dialog = new Dialog();
        this.input = new InputScanner(this);
        this.inventory = new Inventory();
        this.hints = new Hint(this);
        this.factory = new FactoryObject(this);
        this.button = new SaveButton();
        this.maps = new MiniMap(this);
        //It seems like the reason it wasn't working is because the JSON file was corrupted, it works fine now just make sure you save it first
        try {
        	//this.loadGame();
        	this.selectLevel(8);
        } catch(Exception e) {
        	this.selectLevel(0);
        }
        
    }
    
    /**
     * Builds the level that is given in the parameter
     * @param levelId The level to load
     */
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
            //TODO Fix level order and add two more levels
            switch(levelId){
                case 0:
                    buildLevelZero();
                    break;
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
                	if(currentLevel == 3) {
                		buildLevelFive(true);
                	} else {
                		buildLevelFive(false);
                	}
                    break;
                case 6:
                	if(currentLevel == 5) {
                		buildLevelSix(true);
                	} else {
                		buildLevelSix(false);
                	}
                	break;        
                case 7:
                	if(currentLevel == 4) {
                		buildLevelSeven(false);
                	} else {
                		buildLevelSeven(true);
                	}
                	break;
                case 8:
                	buildLevelEight();
                	break;
                	
            }
            
            // ---------------------------------
            Level.currentLevel = levelId;
            if(levelId != 0) {
            	this.maps.visible = true;
            	this.hints.visible = true;
            	this.button.visible = true;
            }
            this.player.setGameObjects(this.objects);
            this.saveGame();
        }
    }
    

    private void buildLevelZero(){
        this.onMenu = true;
        this.player.x = -40;
        this.player.y = -40;
        this.map = new TileMap(0);
        this.objects = new Array<GameObject>();
        this.objects.add( new GameObject(new Texture( Gdx.files.internal("titlescreen.png")),  0, 0, 0, 0, this, false, null));
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
        
        this.hints.setType("number conversion");
        
        this.dialog.show("Welcome to the maze! "
        		+ "The way this works is quite simple, you must simply solve the puzzles in each room in order to escape. "
        		+ "Solving each puzzle will give you a key. Use that key to open the door and continue into the maze. "
        		+ "If you require help on figuring out how to solve the puzzles, a hint button is located in the top left corner. "
        		+ "This first puzzle involves converting binary to decimal, so walk up to the computer to get started.");
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Convert (10) to decimal", new Callback() {

				@Override
				public void action(Level level) {
					if(level.input.text.equals("2")) {
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
        this.objects.add(factory.create("tree green", 135, 450));
        this.objects.add(factory.create("tree green", 450, 70));
        this.objects.add(factory.create("tree green", 500, 400));
        this.objects.add(factory.create("rock", 350, 200));
        this.objects.add(factory.create("rock", 600, 300));

    }
    
    /**
     * Constructs the second level
     */
    private void buildLevelTwo() {
        this.map = new TileMap(30, 20);
        this.objects = new Array<GameObject>();
        this.player.x = Gdx.graphics.getWidth()/2 -16;
        this.player.y = 0;
        
        this.hints.setType("number conversion");
        
        Callback computer = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Convert (1101) to Decimal");
               level.dialog.show("Walk up to the rock with the index of your answer for a reward. (Index starting at 0)");
            }
            
        };
        
        Callback rock = new Callback(){
            @Override
            public void action(Level level) {
            	if(level.input.text.equals("13")) {
                	level.objects.add(level.factory.createKey(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 2));
                	level.dialog.close();
                	level.dialog.show("Before you lies two paths, one to the left and one to the right. "
                			+ "The right path will continue on the trials of boolean number conversion while the left will "
                			+ "set you on the path of boolean algebra. "
                			+ "Choose wisely and be prepared for what is to come.");
            	}
            }
            
        };
        
        Callback rock2 = new Callback(){
            @Override
            public void action(Level level) {
            	level.dialog.close();
            	level.dialog.show("Wrong rock!, is your input right?");
            }
            
        };
        
        this.objects.add(factory.createDoor("side", -28, Gdx.graphics.getHeight()/2, 3));
        this.objects.add(factory.createDoor("side", Gdx.graphics.getWidth() - 40, Gdx.graphics.getHeight()/2, 4));
        this.objects.add(factory.create("computer", 500, 100, computer));
        int rockX = 30;
        int rockY = 500;
        for(int i = 0; i < 25; i++) {
        	if(i == 13) {
        		this.objects.add(factory.create("rock", rockX, rockY, rock));
        	} else {
        		this.objects.add(factory.create("rock", rockX, rockY, rock2));
        	}
        	rockX += 30;
        }
        
    }
    
    
    /**
     * Constructs the third level
     */
    private void buildLevelThree() {
    	this.map = new TileMap(30, 20);
    	for(int i = 0; i < this.map.map.length; i++) {
    		for(int j = 0; j < this.map.map[0].length; j++) {
    			this.map.map[i][j] = 18;
    		}
    	}
    	this.objects = new Array<GameObject>();
    	this.player.x = Gdx.graphics.getWidth()-16;
    	this.player.y = Gdx.graphics.getHeight()/2 - 16;
    	
    	this.hints.setType("simple boolean algebra");
    	
    	Callback computer1 = new Callback() {

			@Override
			public void action(Level level) {
				level.input.show("What is the value of (1+1)*(0+1)?", new Callback() {

					@Override
					public void action(Level level) {
						if(level.input.text.equals("1")) {
							level.objects.add(level.factory.create("computer", 700, 500, new Callback() {

								@Override
								public void action(Level level) {
									level.input.show("What is the value of (1+0)*(0*(1+1))+0?", new Callback() {

										@Override
										public void action(Level level) {
											if(level.input.text.equals("0")) {
												level.objects.add(level.factory.create("tree blue", Gdx.graphics.getWidth()/2 - 64, Gdx.graphics.getHeight()/2, new Callback() {

													@Override
													public void action(Level level) {
														level.dialog.show("You touch the tree and it dissapears, leaving a key.");
														level.objects.removeIndex(3);
														level.objects.add(level.factory.createKey(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 3));
														
													}
													
												}));
											}
											
										}
										
									});
									
								}
								
							}));
						}
					}
					
				});
				
			}
    		
    	};
    	
    	this.objects.add(this.factory.create("computer", 50, 500, computer1));
    	this.objects.add(factory.createDoor("up", Gdx.graphics.getWidth()/2 - 32, Gdx.graphics.getHeight()-64, 5));
    	
    }
    
    /**
     * Constructs level four
     */
    public void buildLevelFour(){
        this.map = new TileMap(30, 20);
        for(int i = 0; i < this.map.map.length; i++) {
        	for(int j = 0; j < this.map.map[0].length; j++) {
        		this.map.map[i][j] = 9;
        	}
        }
        this.objects = new Array<GameObject>();
        this.player.x = Gdx.graphics.getWidth()/2 - 16;
        this.player.y = 0;
        
        this.hints.setType("number conversion");
        
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Convert (111110) base two to decimal", new Callback() {

				@Override
				public void action(Level level) {
					if(level.input.text.equals("62")) {
						level.objects.add(level.factory.createKey(300, 300, 4));
						level.dialog.close();
						level.dialog.show("The key has appeared! Grab it and unlock the door then walk through.");
					}
				}
            	   
               });
            }
            
        };
        
        this.objects.add(factory.createDoor("up", Gdx.graphics.getWidth()/2 - 32, Gdx.graphics.getHeight()-64, 7));
        this.objects.add(factory.create("computer", 200, 200, function1));
        this.objects.add(factory.create("tree blue", 75, 450));
        this.objects.add(factory.create("tree green", 700, 70));
        this.objects.add(factory.create("tree green", 50, 700));
    }
    
    /**
     * Constructs the fifth level
     * @param direction The direction that the player came from: true = level 3, false = level 6
     */
    private void buildLevelFive(boolean direction) {
    	this.map = new TileMap(30, 20);
    	for(int i = 0; i < this.map.map.length; i++) {
    		for(int j = 0; j < this.map.map[0].length; j++) {
    			this.map.map[i][j] = 18;
    		}
    	}
    	this.objects = new Array<GameObject>();
    	
    	if(direction) {
    		this.player.x = Gdx.graphics.getWidth()/2;
    		this.player.y = 0;
    		this.objects.add(factory.createDoor("side", Gdx.graphics.getWidth() - 40, Gdx.graphics.getHeight()/2, 6));
    	} else {
    		this.player.x = Gdx.graphics.getWidth()-16;
        	this.player.y = Gdx.graphics.getHeight()/2 - 16;
    	}
    	
    	this.hints.setType("simple boolean algebra");
    	
    	Callback computer1 = new Callback() {

			@Override
			public void action(Level level) {
				level.input.show("What is the value of (1+0)*(1+1+0+0+0+1+1)*1?", new Callback() {

					@Override
					public void action(Level level) {
						if(level.input.text.equals("1")) {
							level.objects.add(level.factory.create("computer", 650, 355, new Callback() {

								@Override
								public void action(Level level) {
									level.input.show("What is the value of ((0*0)+1+(1+(1*0)))*0?", new Callback() {

										@Override
										public void action(Level level) {
											if(level.input.text.equals("0")) {
												level.objects.add(level.factory.create("tree blue", Gdx.graphics.getWidth()/2 - 64, Gdx.graphics.getHeight()/2, new Callback() {

													@Override
													public void action(Level level) {
														level.dialog.show("You touch the tree and it dissapears, leaving a key.");
														level.objects.removeIndex(level.objects.size - 1);
														level.objects.add(level.factory.createKey(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 5));
														
													}
													
												}));
											}
											
										}
										
									});
									
								}
								
							}));
						}
					}
					
				});
				
			}
    		
    	};
    	
    	this.objects.add(this.factory.create("computer", 200, 300, computer1));
    	this.objects.add(factory.createDoor("up", Gdx.graphics.getWidth()/2 - 32, Gdx.graphics.getHeight()-64, 8));
    }
    
    /**
     * Constructs level six
     * @param direction The direction the player came from: true = level 5, false = level 7
     */
    public void buildLevelSix(boolean direction) {
    	this.map = new TileMap(30, 20);
    	for(int i = 0; i < this.map.map.length; i++) {
    		for(int j = 0; j < this.map.map[0].length; j++) {
    			this.map.map[i][j] = 3;
    		}
    	}
    	this.objects = new Array<GameObject>();
    	this.hints.setType("binary addition");
    	this.dialog.close();
    	this.dialog.show("This room offers you a new skill to learn."
    			+ " Answer the questions correctly and you will continue onto to path you diverted from in the beginning.");
    	
    	//Change spawn point based on where player entered from
    	if(direction) {
    		this.player.x = 0;
    		this.player.y = Gdx.graphics.getHeight()/2 - 16;
    		this.objects.add(this.factory.createDoor("side", Gdx.graphics.getWidth() - 40, Gdx.graphics.getHeight()/2, 7));
    	} else {
    		this.player.x = Gdx.graphics.getWidth()- 16;
    		this.player.y = Gdx.graphics.getHeight()/2 - 16;
    		this.objects.add(factory.createDoor("side", -28, Gdx.graphics.getHeight()/2, 5));
    	}
    	
    	Callback computer1 = new Callback() {

			@Override
			public void action(Level level) {
				level.input.show("Add (10) and (01).", new Callback() {

					@Override
					public void action(Level level) {
						if(level.input.text.equals("11")) {
							level.objects.add(level.factory.create("computer", 500, 400, new Callback() {

								@Override
								public void action(Level level) {
									level.input.show("Add (110) and (110).", new Callback() {

										@Override
										public void action(Level level) {
											level.dialog.close();
											level.dialog.show("If your answer is correct, then open the box for your reward.");
											
											
										}
										
									});
									
								}
								
							}));
						}
						
					}
					
				});
			}
    		
    	};
    	
    	Callback box1 = new Callback() {

			@Override
			public void action(Level level) {
				if(level.input.text.equals("1100")) {
					level.objects.add(level.factory.createKey(650, 500, 6));
					level.objects.removeIndex(1);
					
				}
				
			}
    		
    	};
    	
    	this.objects.add(this.factory.create("box", 650, 450, box1));
    	this.objects.add(this.factory.create("computer", 200, 200, computer1));
    }
    
    
    /**
     * Constructs level seven
     * @param direction The direction the player came from: false = level 4, true = level 6
     */
    public void buildLevelSeven(boolean direction){
        this.map = new TileMap(30, 20);
        for(int i = 0; i < this.map.map.length; i++) {
        	for(int j = 0; j < this.map.map[0].length; j++) {
        		this.map.map[i][j] = 11;
        	}
        }
        this.objects = new Array<GameObject>();
        if(direction) {
        	this.player.x = 0;
    		this.player.y = Gdx.graphics.getHeight()/2 - 16;
        } else {
        	this.player.x = Gdx.graphics.getWidth()/2 - 16;
        	this.player.y = 0;
        	this.objects.add(factory.createDoor("side", -28, Gdx.graphics.getHeight()/2, 3));
        }
        this.hints.setType("number conversion");
        
        
        Callback function1 = new Callback(){
            @Override
            public void action(Level level) {
               level.input.show("Convert (10110) base two to decimal.", new Callback() {

				@Override
				public void action(Level level) {
					if(level.input.text.equals("22")) {
						level.objects.add(level.factory.createKey(300, 300, 7));
						level.dialog.close();
						level.dialog.show("The key has appeared! Grab it and unlock the door then walk through.");
					}
				}
            	   
               });
            }
            
        };
        
        this.objects.add(factory.createDoor("up", Gdx.graphics.getWidth()/2 - 32, Gdx.graphics.getHeight()-64, 8));
        this.objects.add(factory.create("computer", 200, 200, function1));
        this.objects.add(factory.create("rock", 45, 15));
        this.objects.add(factory.create("tree green", 135, 450));
        this.objects.add(factory.create("tree green", 450, 70));
        this.objects.add(factory.create("tree green", 600, 250));
        this.objects.add(factory.create("tree green", 350, 200));
        	//test
    }
    
  /**
   * Constructs level eight
   */
    private void buildLevelEight() {
    	this.map = new TileMap(30, 20);
        for(int i = 0; i < this.map.map.length; i++) {
        	for(int j = 0; j < this.map.map[0].length; j++) {
        		this.map.map[i][j] = 11;
        	}
        }
        this.objects = new Array<GameObject>();
        this.player.x = Gdx.graphics.getWidth()/2 - 16;
        this.player.y = 0;
    			dialog.show("This will be your final challenge on the path of boolean algebra. "
    					+ "Complete this challenge and move on to the final challenge of the maze.");
    		
    	
    	this.hints.setType("boolean identities");
    			  
    	
    	Callback computerOne = new Callback() {

			@Override
			public void action(Level level) {
				level.input.show("Simplify the expression (x+x)*0.", new Callback() {

					
					
		@Override
		public void action(Level level) {
		if(level.input.text.equals("0")) {
			level.objects.add(level.factory.create("computer", 30, 200, new Callback() {

		@Override
		public void action(Level level) {
		level.input.show("Simplify the expression (x*~x)+(x*1)+(x*x)", new Callback() {

						@Override
		public void action(Level level) {
		if(level.input.text.equals("X")) {
			level.objects.add(level.factory.create("box", Gdx.graphics.getWidth()/2 - 64, Gdx.graphics.getHeight()/2, new Callback() {

					@Override
		public void action(Level level) {
		level.dialog.show("The box was hiding the key, take it.");
		level.objects.removeIndex(level.objects.size - 1);
		level.objects.add(level.factory.createKey(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 8));
														
						}
								}));
											}
											
										}
										
									});
									
								}
								
							}));
						}
					}
					
				});
				
			}
    		
    	};
    	
    	this.objects.add(this.factory.create("computer", 30, 400, computerOne));
    	this.objects.add(factory.createDoor("up", Gdx.graphics.getWidth()/2 - 32, Gdx.graphics.getHeight()-64, 9));
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
        objects.add( factory.create("tree blue", 90, 100)  );
        objects.add( factory.create("tree green", 400, 100)  );
        objects.add( factory.create("box", 30, 300)  );
        objects.add( factory.create("box", 500, 300)  );
    }
    
    
    /**
     * Saves the current level to a JSON file to be loaded later
     */
    public void saveGame() {
        int[] keys = new int[inventory.keys.size];
        for(int i=0; i<keys.length; i++){
            keys[i] = inventory.keys.get(i).levelDestination;
        }
        
    	SaveData data = new SaveData(currentLevel, player.x, player.y, keys, factory.keysSpawned);
    	Json jsonWriter = new Json();
    	FileHandle file = Gdx.files.local("data/data.json");
    	file.writeString(jsonWriter.toJson(data), false);
    }
    
    /**
     * Loads the last saved level from a local JSON file
     */
    public void loadGame() {
    	FileHandle reader = Gdx.files.internal("data/data.json");
    	Json jsonReader = new Json();
    	SaveData data = jsonReader.fromJson(SaveData.class ,reader.readString());
    	selectLevel(data.getLevel());
        player.x = data.getX();
        player.y = data.getY();
        factory.keysSpawned = data.getKeysSpawned();
        int[] keys = data.getKeys();
        for(int i=0; i<keys.length; i++){
            Key key = new Key(new Texture(  Gdx.files.internal("gameObjects/key.png")), 20, 20, 0 ,0, this, false, null);
            key.action();
            key.levelDestination = keys[i];
            key.used = keys[i] != -1;
        }
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
        this.maps.render(batch);
        this.dialog.render(batch);
        this.hints.render(batch);
        this.button.render(batch);
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
        this.button.dispose();
    }


    
    
}