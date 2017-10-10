
package com.prototype.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;


public class TileMap {
    
    int[][] map;
    public ArrayList<Texture> tileTextures;
    static final int TILE_SIZE = 32;
    
    public TileMap(int height, int width){
        this.map = new int[height][width];
        this.tileTextures = new ArrayList<Texture>();
        
        //Fill the array with numbers for now
        for(int i=0; i<this.map.length; i++ ){
            for(int j=0; j<this.map[0].length; j++){
                this.map[i][j] = 0;
            }
        }
        
        this.map[4][4] = 1;
        this.map[5][4] = 1;
        
        //Add 0th texture
        tileTextures.add(  new Texture("stone.png")   );
        tileTextures.add(  new Texture("grass.png")   );
    }
    
    public void render(SpriteBatch batch){
        
        for(int i=0; i<this.map.length; i++ ){
            for(int j=0; j<this.map[0].length; j++){
                batch.draw(tileTextures.get( this.map[i][j] ), TILE_SIZE*i, TILE_SIZE*j);
            }
        }
    }
}
