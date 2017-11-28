/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class ComputerObject extends GameObject {
	
	private String puzzle;

    public ComputerObject(int width, int height, int x, int y, Level level, boolean collidable, String puzzle, int answer) {
        super(new Texture(Gdx.files.internal("gameObjects/object3.png")), width, height, x, y, level, collidable);
        this.puzzle = puzzle;
    }

    @Override
    public void action() {
    	Gdx.input.getTextInput(level.input, "TERMINAL INPUT", "", "Answer");
        level.dialog.show(puzzle);
    }
    
}
