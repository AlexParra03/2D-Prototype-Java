/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class FactoryObject {
    
    private Level level;
    
    public FactoryObject(Level level){
        this.level = level;
    }
    
    
    public GameObject createDoor(String direction, int x, int y, Callback function, int levelDestination){
        if(direction.equals("up")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object7.png")), 40, 40, x, y, level, true, function, levelDestination);
        }else if(direction.equals("side")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 40, 40, x, y, level, true, function, levelDestination);
        }else{
            return null;
        }
    }
    
    public GameObject createDoor(String direction, int x, int y, int levelDestination){
        if(direction.equals("up")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object7.png")), 64, 64, x, y, level, true, null, levelDestination);
        }else if(direction.equals("side")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 20, 64, x, y, level, true, null, levelDestination);
        }else{
            return null;
        }
    }
    
    public GameObject create(String objectType, int x, int y, Callback function){
        
        if(objectType.equals("computer")){
            return new ComputerObject( new Texture(  Gdx.files.internal("gameObjects/object3.png")), new Texture(  Gdx.files.internal("gameObjects/object2.png")), new Texture(  Gdx.files.internal("gameObjects/object4.png")), 50, 50, x,y, level, true, function);
        }else if(objectType.equals("rock")){
            return new RockObject(new Texture(  Gdx.files.internal("gameObjects/object5.png")), 32, 32, x, y, level, true, function);
        }else if(objectType.equals("box")){
            return new BoxObject(new Texture(  Gdx.files.internal("gameObjects/object6.png")), 64, 64, x, y, level, true, function);
        }else if(objectType.equals("chest up")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object10.png")), 40, 40, x, y, level, true, function);    
        }else if(objectType.equals("chest down")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object9.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("barrel")){
            return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 32, 32, x, y, level, true, function);
        }else if(objectType.equals("key")){
            return new Key(new Texture(  Gdx.files.internal("gameObjects/key.png")), 32, 32, x ,y, level, false, function);
        }else if(objectType.equals("tree green")){
            return new TreeObject(new Texture(  Gdx.files.internal("gameObjects/object1.png")), 105, 115, x ,y, level, true, function);
        }else{
            return null;
        }
    }
    
    public GameObject create(String objectType, int x, int y){
        Callback function = null;
        
        if(objectType.equals("computer")){
            return new ComputerObject( new Texture(  Gdx.files.internal("gameObjects/object3.png")), new Texture(  Gdx.files.internal("gameObjects/object2.png")), new Texture(  Gdx.files.internal("gameObjects/object4.png")), 50, 50, x,y, level, true, function);
        }else if(objectType.equals("rock")){
            return new RockObject(new Texture(  Gdx.files.internal("gameObjects/object5.png")), 32, 32, x, y, level, true, function);
        }else if(objectType.equals("box")){
            return new BoxObject(new Texture(  Gdx.files.internal("gameObjects/object6.png")), 64, 64, x, y, level, true, function);
        }else if(objectType.equals("chest up")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object10.png")), 40, 40, x, y, level, true, function);    
        }else if(objectType.equals("chest down")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object9.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("barrel")){
            return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 32, 32, x, y, level, true, function);
        }else if(objectType.equals("key")){
            return new Key(new Texture(  Gdx.files.internal("gameObjects/key.png")), 32, 32, x ,y, level, false, function);
        }else if(objectType.equals("tree green")){
            return new TreeObject(new Texture(  Gdx.files.internal("gameObjects/object1.png")), 115, 115, x ,y, level, true, function);
        } else {
        	return null;
        }
        
    }
}
