
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;


public class TileMap implements RenderableObject {
    
    int[][] map;
    public ArrayList<Texture> tileTextures;
    static final int TILE_SIZE = 32;
    
    public TileMap(int height, int width){
        if(height < 0 || width < 0){
            throw new Error("Dimensions for Tile Map not allowed.");
        }
        
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
        tileTextures.add(  new Texture(  Gdx.files.internal("tiles/Rockpixel1.jpg") )   );
        tileTextures.add(  new Texture( Gdx.files.internal( "tiles/grass.png") )   );
    }
    
    public void changeTile(int row, int column, int textureKey){
        if(textureKey < 0 || textureKey >= tileTextures.size()){
            throw new Error("Texture Key does not exists or is out of range.");
        }
        if(row < 0 || row >= this.map.length || column < 0 || column >= this.map[0].length){
            throw new Error("Position is out of range, cannont replace tile");
        }
        
        this.map[row][column] = textureKey;
        
    }
    
    @Override
    public void render(SpriteBatch batch){
        
        for(int i=0; i<this.map.length; i++ ){
            for(int j=0; j<this.map[0].length; j++){
                batch.draw(tileTextures.get( this.map[i][j] ), TILE_SIZE*i, TILE_SIZE*j);
            }
        }
    }

    @Override
    public void dispose() {
        for(Texture texture : tileTextures){
            texture.dispose();
        }
    }
}