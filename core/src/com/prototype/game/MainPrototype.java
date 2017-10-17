package com.prototype.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainPrototype extends ApplicationAdapter {
	SpriteBatch batch;
        TileMap map;
        Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                
        //Creating instance of map  
        this.map = new TileMap(Gdx.graphics.getWidth()/32, Gdx.graphics.getHeight()/32);
        this.player = new Player();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		handleInput();
		batch.begin();
        map.render(batch);
        player.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		map.dispose();
        player.dispose();
	}
        
        void handleInput(){
            
            //Player movement
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                player.movingLeft = true;
                System.out.println("YESS");
            }else{
                player.movingLeft = false;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                player.movingRight = true;
            }else{
                player.movingRight = false;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                player.movingUp = true;
            }else{
                player.movingUp = false;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                player.movingDown = true;
            }else{
                player.movingDown = false;
            }
            
        }
}
