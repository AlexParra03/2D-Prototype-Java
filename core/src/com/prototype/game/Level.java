
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Level {
    SpriteBatch batch;
    Player player;
    TileMap map;
    GameObject[] objects;
    
    public Level(SpriteBatch batch, Player player){
        this.batch = batch;
        this.player = player;
    }
    
    public void levelOne(){
        TileMap map = new TileMap(10,10);
    }
    
    
    
    
}
