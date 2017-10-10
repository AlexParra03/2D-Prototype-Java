package com.prototype.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainPrototype extends ApplicationAdapter {
	SpriteBatch batch;
        TileMap map;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                
                //Creating instance of map  
                this.map = new TileMap( 10, 10 );
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                
		batch.begin();
                map.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for(Texture tile : map.tileTextures){
                    tile.dispose();
                }
	}
}
