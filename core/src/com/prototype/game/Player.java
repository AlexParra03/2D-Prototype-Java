
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import static com.prototype.game.TileMap.TILE_SIZE;
import java.util.ArrayList;

public class Player implements RenderableObject {
    
    
    // Textures
    Texture[] up = new Texture[3];
    Texture[] down = new Texture[3];
    Texture[] left = new Texture[3];
    Texture[] right = new Texture[3];
    ArrayList<Texture[]> animations = new ArrayList<Texture[]>();
    
    //Inputs
    private boolean movingDown = false;
    private boolean movingUp = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    
    //Collision
    private boolean leftCollision = false;
    private boolean rightCollision = false;
    private boolean upCollision = false;
    private boolean downCollision = false;
    private boolean colliding = false;
    
    // Used to pick the set of animations U: Up, D: Down, L: Left, R: Right
    private char animationDirection = 'D';
    private double animationTimer = 0;
    private Texture currentFrame;
    private final double ANIMATION_SPEED = 6.0;
    
    //Position
    public double x;
    public double y;
    
    
    //Statistics
    double speed = 2;
    
    //Game Object collisions
    Array<GameObject> objects;
    
    /**
     * Initialize animations, textures and positions
     */
    public Player(){
    	
    	//Adding animation frames to each set
        for(int i=0; i<3; i++){
        	this.up[i] = new Texture(Gdx.files.internal("character/up" + i + ".png"));
        }
        for(int i=0; i<3; i++){
        	this.down[i] = new Texture(Gdx.files.internal("character/down" + i + ".png"));
        }
        for(int i=0; i<3; i++){
        	this.left[i] = new Texture(Gdx.files.internal("character/left" + i + ".png"));
        }
        for(int i=0; i<3; i++){
        	this.right[i] = new Texture(Gdx.files.internal("character/right" + i + ".png"));
        }
        
        this.currentFrame = this.down[0];
  
        // Adding set animations together
        animations.add(this.up);
        animations.add(this.down);
        animations.add(this.left);
        animations.add(this.right);
        
        //Starting position
        this.x = 300;
        this.y = 300;
    }
    /**
    * contains logic being called before rendering
    */
    void update(){
        this.normalizedMovement();
        this.updateCurrentFrame();
        this.gameObjectsCollision();
    }
    
    @Override
    public void render(SpriteBatch batch) {
        //Update logic before rendering
        this.update();
        batch.draw( this.currentFrame, (int)this.x, (int)this.y );
    }

    @Override
    public void dispose() {
        for(Texture[] set : animations){
            for(Texture frame : set){
                frame.dispose();
            }
        }
    }
    
    /**
     * Handles collision with game objects in the level
     */
    private void gameObjectsCollision(){
        int xOffset = 10;
        
        // Check for object collision
        if(objects != null){
            for(int i=0; i<objects.size; i++){
                GameObject object = objects.get(i);
                if(object != null){
                    if( (int)this.x + xOffset > object.x && (int)this.x + xOffset < object.x + object.width ){
                        if((int)this.y > object.y && (int)this.y < object.y + object.height){
                            if(object.collidable) {
                                    if(!this.colliding){
                                            this.leftCollision = this.movingLeft;
                                            this.rightCollision = this.movingRight;
                                            this.upCollision = this.movingUp;
                                            this.downCollision = this.movingDown;
                                            object.action();
                                            this.colliding = true;
                                    }
                            } else {
                                    object.action();
                                    this.colliding = true;
                            }
                        }
                    }
                }

            }
            
            if(this.colliding){ // Checking collision with all objects
                boolean stillColliding = false;
                for(GameObject object : objects){
                    if(object != null){
                        // If player is colliding with object
                         if( (int)this.x + xOffset > object.x && (int)this.x + xOffset < object.x + object.width && (int)this.y > object.y && (int)this.y < object.y + object.height ){
                             stillColliding = true;
                             break;
                         }
                    }
                }
                

                if(!stillColliding){  // Resetting collision flags
                        this.leftCollision = false;
                        this.rightCollision = false;
                        this.upCollision = false;
                        this.downCollision = false;
                        this.colliding = false;
                }
            }
            
  
            if(!this.colliding){
                    // Check for border/edge collision if there is no object collision
                    this.rightCollision = (int)this.x > 783;
                    this.leftCollision = (int)this.x < -1;
                    this.upCollision = (int)this.y > 583;
                    this.downCollision = (int)this.y < 1;
            }

                
        }
        

    }
    
    /**
     * Handles animation frames
     */
    private void updateCurrentFrame(){
    	if(this.movingDown || this.movingUp || this.movingLeft || this.movingRight){
    		this.animationTimer += (Gdx.graphics.getDeltaTime()* this.ANIMATION_SPEED) % 3;	
    	}
    	
    	int i = (int) this.animationTimer % 3 ;
    	
    	switch(this.animationDirection){
            case 'U':
                    this.currentFrame = this.up[i];
                    break;
            case 'D':
                    this.currentFrame = this.down[i];
                    break;
            case 'L':
                    this.currentFrame = this.left[i];
                    break;
            case 'R':
                    this.currentFrame = this.right[i];
                    break;
            default:
                    this.currentFrame = this.down[0];
                    break;
    	}
    }
    
    // Player can only move a distance determined by the speed in any directions
    void normalizedMovement(){
        
        double dx = 0;
        double dy = 0;
        
        // Movement in 2 directions
        if( (this.isMovingUp() || this.isMovingDown()) && (this.isMovingLeft() || this.isMovingRight()) ){
            dy = (this.isMovingUp()) ? ((Math.sqrt(2)/2)*this.speed) : -((Math.sqrt(2)/2)*this.speed);
            dx = (this.isMovingRight()) ? ((Math.sqrt(2)/2)*this.speed) : -((Math.sqrt(2)/2)*this.speed);
        // Vertical Movement
        }else if(this.isMovingUp() || this.isMovingDown()){ 
            dy = (this.isMovingUp()) ? (this.speed) : -(this.speed);
        // Horizontal Movement
        }else if(this.isMovingLeft() || this.isMovingRight()){ 
            dx = (this.isMovingRight()) ? (this.speed) : -(this.speed);
        }
        
        this.x += dx;
        this.y += dy;
    }

    /**
     * determine if the player is moving right
     * @return if the player is moving right
     */
    boolean isMovingRight() {
        return movingRight;
    }

    /**
     * Setting right movement and handling animations
     * @param movingRight 
     */
    void setMovingRight(boolean movingRight) {
        this.movingRight = !this.rightCollision && movingRight ;
        if(movingRight){
                this.animationDirection = 'R';
        }
    }

    /**
     * Determine if the player is moving left
     * @return if the player is moving left
     */
    boolean isMovingLeft() {
        return movingLeft;
    }

    /**
     * Setting left movement and handling animations
     * @param movingLeft if the player is moving left
     */
    void setMovingLeft(boolean movingLeft) {
        this.movingLeft = !this.leftCollision && movingLeft;
        if(movingLeft){
                this.animationDirection = 'L';
        }
    }

    /**
     * Determining if the player is moving up
     * @return if the player is moving up
     */
    boolean isMovingUp() {
        return movingUp;
    }

    /**
     * Setting up movement and animations
     * @param movingUp if the player is moving up
     */
    void setMovingUp(boolean movingUp) {
        this.movingUp = !this.upCollision && movingUp;
        if(movingUp){
                this.animationDirection = 'U';
        }
    }

    /**
     * Determine if the player is moving down
     * @return if the player is moving down
     */
    boolean isMovingDown() {
        return movingDown;
    }

    /**
     * Setting down movement and animation
     * @param movingDown if the player is moving down
     */
    void setMovingDown(boolean movingDown) {
        this.movingDown = !this.downCollision && movingDown;
        if(movingDown){
                this.animationDirection = 'D';
        }
    }

    /**
     * Objects are used to handle player collision and callbacks
     * @param objects List of objects to be checked against for collision
     */
    void setGameObjects(Array<GameObject> objects){
       this.objects = objects;
    }

    
    
    
}
