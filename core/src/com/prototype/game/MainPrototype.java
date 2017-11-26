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
    Level level;



    @Override
    public void create () {
        Gdx.graphics.setWindowedMode(800, 600);
        Gdx.graphics.setResizable(false);
        batch = new SpriteBatch();
        this.level = new Level();


    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        handleInput();
        batch.begin();
        level.render(batch);
        batch.end();
        
    }

    @Override
    public void dispose () {
        batch.dispose();
        level.dispose();
    }

    void handleInput(){

        Player player = level.player;
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

        Dialog dialog = level.dialog;
         if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            if(Gdx.input.getX() >= dialog.buttonX && Gdx.input.getX() <= (dialog.buttonX + dialog.buttonWidth)){
                if(Gdx.input.getY() >= (Gdx.graphics.getHeight()- dialog.buttonY-dialog.buttonHeight) && Gdx.input.getY() <= (Gdx.graphics.getHeight()-dialog.buttonY)){
                    dialog.close();
                }
            }

         }

    }

}
