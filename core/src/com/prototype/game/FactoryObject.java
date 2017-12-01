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
    
    
    public GameObject create(String objectType, int x, int y, Callback function){
                /*
        switch(objectType){
            //case "key":
                //new Key( new Texture(Gdx.files.internal("gameObjects/key.png")), 32, 32, 420, 360, level, "01", false, false, function)
            case "door up":
                return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")), 40, 40, x, y, level, true, function);
            case "door side":
                return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 40, 40, x, y, level, true, function);
            case "rock":
                return new RockObject(new Texture(  Gdx.files.internal("gameObjects/object5.png")), 40, 40, x, y, level, true, function);
            case "box":
                return new BoxObject(new Texture(  Gdx.files.internal("gameObjects/object6.png")), 40, 40, x, y, level, true, function);
            case "chest up":
                return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object10.png")), 40, 40, x, y, level, true, function);    
            case "chest down":
                return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object9.png")), 40, 40, x, y, level, true, function);
            case "barrel":
                return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 40, 40, x, y, level, true, function);
            default:
                return null;
                
        }
        */
        
        if(objectType.equals("door up")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("door side")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("rock")){
            return new RockObject(new Texture(  Gdx.files.internal("gameObjects/object5.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("box")){
            return new BoxObject(new Texture(  Gdx.files.internal("gameObjects/object6.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("chest up")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object10.png")), 40, 40, x, y, level, true, function);    
        }else if(objectType.equals("chest down")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object9.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("barrel")){
            return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 40, 40, x, y, level, true, function);
        }else{
            return null;
        }
    }
    
    public GameObject create(String objectType, int x, int y){
        Callback function = null;
        /*
        switch(objectType){
            //case "key":
                //new Key( new Texture(Gdx.files.internal("gameObjects/key.png")), 32, 32, 420, 360, level, "01", false, false, function)
            case "door up":
                return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")), 40, 40, x, y, level, true, function);
            case "door side":
                return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 40, 40, x, y, level, true, function);
            case "rock":
                return new RockObject(new Texture(  Gdx.files.internal("gameObjects/object5.png")), 40, 40, x, y, level, true, function);
            case "box":
                return new BoxObject(new Texture(  Gdx.files.internal("gameObjects/object6.png")), 40, 40, x, y, level, true, function);
            case "chest up":
                return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object10.png")), 40, 40, x, y, level, true, function);    
            case "chest down":
                return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object9.png")), 40, 40, x, y, level, true, function);
            case "barrel":
                return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 40, 40, x, y, level, true, function);
            default:
                return null;
                
        }
        */
        
        if(objectType.equals("door up")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object3.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("door side")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("rock")){
            return new RockObject(new Texture(  Gdx.files.internal("gameObjects/object5.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("box")){
            return new BoxObject(new Texture(  Gdx.files.internal("gameObjects/object6.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("chest up")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object10.png")), 40, 40, x, y, level, true, function);    
        }else if(objectType.equals("chest down")){
            return new ChestObject(new Texture(  Gdx.files.internal("gameObjects/object9.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("barrel")){
            return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 40, 40, x, y, level, true, function);
        }else{
            return null;
        }
        
    }
}
