
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    // contains logic being called before rendering
    void update(){
        this.normalizedMovement();
        this.updateCurrentFrame();
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
                //frame.dispose();
            }
        }
    }
    
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
        
        // Movement in several directions
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

	boolean isMovingRight() {
		return movingRight;
	}

	void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
		if(movingRight){
			this.animationDirection = 'R';
		}
	}

	boolean isMovingLeft() {
		return movingLeft;
	}

	void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
		if(movingLeft){
			this.animationDirection = 'L';
		}
	}

	boolean isMovingUp() {
		return movingUp;
	}

	void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
		if(movingUp){
			this.animationDirection = 'U';
		}
	}

	boolean isMovingDown() {
		return movingDown;
	}

	void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
		if(movingDown){
			this.animationDirection = 'D';
		}
	}
    
    
    
}
