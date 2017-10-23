
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
    Texture[] idle = new Texture[3];
    ArrayList<Texture[]> animations = new ArrayList<Texture[]>();
    
    //Inputs
    boolean movingDown = false;
    boolean movingUp = false;
    boolean movingLeft = false;
    boolean movingRight = false;
    
    //Position
    public double x;
    public double y;
    
    //Statis
    double speed = 2;
    
    public Player(){
        this.idle[0] = new Texture(Gdx.files.internal("tiles/grass.png"));
        this.x = 10;
        this.y = 10;
        
        animations.add(this.up);
        animations.add(this.down);
        animations.add(this.left);
        animations.add(this.right);
    }

    // contains logic being called before rendering
    void update(){
        this.normalizedMovement();
    }
    
    @Override
    public void render(SpriteBatch batch) {
        //Update logic before rendering
        this.update();
        batch.draw( idle[0], (int)this.x, (int)this.y );
    }

    @Override
    public void dispose() {
        for(Texture[] set : animations){
            for(Texture frame : set){
                //frame.dispose();
            }
        }
    }
    
    // Player can only move a distance determined by the speed in any directions
    void normalizedMovement(){
        
        double dx = 0;
        double dy = 0;
        
        // Movement in several directions
        if( (this.movingUp || this.movingDown) && (this.movingLeft || this.movingRight) ){
            dy = (this.movingUp) ? ((Math.sqrt(2)/2)*this.speed) : -((Math.sqrt(2)/2)*this.speed);
            dx = (this.movingRight) ? ((Math.sqrt(2)/2)*this.speed) : -((Math.sqrt(2)/2)*this.speed);
        // Vertical Movement
        }else if(this.movingUp || this.movingDown){ 
            dy = (this.movingUp) ? (this.speed) : -(this.speed);
        // Horizontal Movement
        }else if(this.movingLeft || this.movingRight){ 
            dx = (this.movingRight) ? (this.speed) : -(this.speed);
        }
        
        this.x += dx;
        this.y += dy;
    }
    
}
