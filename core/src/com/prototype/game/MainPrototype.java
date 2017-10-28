package com.prototype.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainPrototype extends ApplicationAdapter {
	SpriteBatch batch;
        TileMap map;
        Player player;
        Dialog dialog;
	
	@Override
	public void create () {
            Gdx.graphics.setWindowedMode(800, 600);
            batch = new SpriteBatch();
                
            //Creating instance of map  
            this.map = new TileMap(Gdx.graphics.getWidth()/32, Gdx.graphics.getHeight()/32);
            this.player = new Player();
            this.dialog = new Dialog();
            
	}

	@Override
	public void render () {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            handleInput();
            batch.begin();
            map.render(batch);
            player.render(batch);
            dialog.render(batch);
            dialog.show("Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello  Hi");
            batch.end();
	}
	
	@Override
	public void dispose () {
            batch.dispose();
            map.dispose();
            player.dispose();
            dialog.dispose();
	}
        
        void handleInput(){
            
            //Player movement
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                player.setMovingLeft(true);
            }else{
                player.setMovingLeft(false);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                player.setMovingRight(true);
            }else{
                player.setMovingRight(false);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                player.setMovingUp(true);
            }else{
                player.setMovingUp(false);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                player.setMovingDown(true);
            }else{
                player.setMovingDown(false);
            }
            
             if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                 System.out.println(Gdx.input.getY());
                if(Gdx.input.getX() >= dialog.buttonX && Gdx.input.getX() <= (dialog.buttonX + dialog.buttonWidth)){
                    if(Gdx.input.getY() <= dialog.buttonY && Gdx.input.getY() <= (dialog.buttonY + dialog.buttonHeight)){
                        dialog.visible = false;
                        System.out.println("click");
                    }
                }
             
             }
            
        }
        
        /*
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
        sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
                Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
    }
        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
            sprite.setPosition(Gdx.graphics.getWidth()/2 -sprite.getWidth()/2, 
                    Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
        }
        */
}
