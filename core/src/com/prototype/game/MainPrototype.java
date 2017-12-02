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
         
        
        if(level.input.visible){
            mapKeys();
        }
        

    }
    
    void mapKeys(){
        InputScanner input = level.input;
        if(Gdx.input.isButtonPressed( 29 )){
             input.addCharacter('A');
        }else if(Gdx.input.isButtonPressed( 30 )){
             input.addCharacter('B');
        }else if(Gdx.input.isButtonPressed( 31 )){
             input.addCharacter('C');
        }else if(Gdx.input.isButtonPressed( 32 )){
            input.addCharacter('D');
        }else if(Gdx.input.isButtonPressed( 33 )){
            input.addCharacter('E');
        }else if(Gdx.input.isButtonPressed( 34 )){
            input.addCharacter('F');
        }else if(Gdx.input.isButtonPressed( 35 )){
            input.addCharacter('G');
        }else if(Gdx.input.isButtonPressed( 36 )){
            input.addCharacter('H');
        }else if(Gdx.input.isButtonPressed( 37 )){
            input.addCharacter('I');
        }else if(Gdx.input.isButtonPressed( 38 )){
            input.addCharacter('J');
        }else if(Gdx.input.isButtonPressed( 39 )){
            input.addCharacter('K');
        }else if(Gdx.input.isButtonPressed( 40 )){
            input.addCharacter('L');
        }else if(Gdx.input.isButtonPressed( 41 )){
            input.addCharacter('M');
        }else if(Gdx.input.isButtonPressed( 42 )){
            input.addCharacter('N');
        }else if(Gdx.input.isButtonPressed( 43 )){
            input.addCharacter('O');
        }else if(Gdx.input.isButtonPressed( 44 )){
            input.addCharacter('P');
        }else if(Gdx.input.isButtonPressed( 45 )){
            input.addCharacter('Q');
        }else if(Gdx.input.isButtonPressed( 46 )){
            input.addCharacter('R');
        }else if(Gdx.input.isButtonPressed( 47 )){
            input.addCharacter('S');
        }else if(Gdx.input.isButtonPressed( 48 )){
            input.addCharacter('T');
        }else if(Gdx.input.isButtonPressed( 49 )){
            input.addCharacter('U');
        }else if(Gdx.input.isButtonPressed( 50 )){
            input.addCharacter('V');
        }else if(Gdx.input.isButtonPressed( 51 )){
            input.addCharacter('W');
        }else if(Gdx.input.isButtonPressed( 52 )){
            input.addCharacter('X');
        }else if(Gdx.input.isButtonPressed( 53 )){
            input.addCharacter('Y');
        }else if(Gdx.input.isButtonPressed( 54 )){
            input.addCharacter('Z');
        }else if(Gdx.input.isButtonPressed( 7 ) || Gdx.input.isButtonPressed( 144 )){
            input.addCharacter('0');
        }else if(Gdx.input.isButtonPressed( 8 ) || Gdx.input.isButtonPressed( 145 )){
            input.addCharacter('1');
        }else if(Gdx.input.isButtonPressed( 9 ) || Gdx.input.isButtonPressed( 146 )){
            input.addCharacter('2');
        }else if(Gdx.input.isButtonPressed( 10 ) || Gdx.input.isButtonPressed( 147 )){
            input.addCharacter('3');
        }else if(Gdx.input.isButtonPressed( 11 ) || Gdx.input.isButtonPressed( 148 )){
            input.addCharacter('4');
        }else if(Gdx.input.isButtonPressed( 12 ) || Gdx.input.isButtonPressed( 149 )){
            input.addCharacter('5');
        }else if(Gdx.input.isButtonPressed( 13 ) || Gdx.input.isButtonPressed( 150 )){
            input.addCharacter('6');
        }else if(Gdx.input.isButtonPressed( 14 ) || Gdx.input.isButtonPressed( 151 )){
           input.addCharacter('7');
        }else if(Gdx.input.isButtonPressed( 15 ) || Gdx.input.isButtonPressed( 152 )){
            input.addCharacter('8');
        }else if(Gdx.input.isButtonPressed( 16 ) || Gdx.input.isButtonPressed( 153 )){
            input.addCharacter('9');
        }
    }

}
