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

    public ComputerObject(int x, int y, Level level, boolean collidable) {
        super(new Texture(Gdx.files.internal("gameObjects/computer1.png")), 50, 50, x, y, level, collidable);
    }

    @Override
    public void action() {
    	level.dialog.show("PUZZLING PUZZLES AWAIT");
    }
    
}
