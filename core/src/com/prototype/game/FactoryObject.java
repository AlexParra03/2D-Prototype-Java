/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class FactoryObject {
    
    // Array containing flags to prevent spawning the same key several times
    protected boolean[] keysSpawned;
    // Reference to the level to contruct objects
    private Level level;
    
    /**
     * Initialize components
     * @param level Level to be used when constructing objects
     */
    public FactoryObject(Level level){
        this.level = level;
        this.keysSpawned = new boolean[20];
    }
    
    /**
     * Creates a door to travel to a new level of the maze
     * @param direction pick texture of the directions of the door
     * @param x x position of the object
     * @param y y position of the object
     * @param function callback to be called when colliding
     * @param levelDestination level destination
     * @return Instance of a new door object
     */
    
    public GameObject createDoor(String direction, int x, int y, Callback function, int levelDestination){
        if(direction.equals("up")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object7.png")), 40, 40, x, y, level, true, function, levelDestination);
        }else if(direction.equals("side")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 40, 40, x, y, level, true, function, levelDestination);
        }else{
            return null;
        }
    }
    
        /**
     * Creates a door to travel to a new level of the maze
     * @param direction pick texture of the directions of the door
     * @param x x position of the object
     * @param y y position of the object
     * @param levelDestination level destination
     * @return Instance of a new door object
     */
    public GameObject createDoor(String direction, int x, int y, int levelDestination){
        if(direction.equals("up")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object7.png")), 64, 64, x, y, level, true, null, levelDestination);
        }else if(direction.equals("side")){
            return new DoorObject(new Texture(  Gdx.files.internal("gameObjects/object8.png")), 20, 64, x, y, level, true, null, levelDestination);
        }else{
            return null;
        }
    }
    
    /**
     * Creates a key
     * @param x x position of the key  
     * @param y y position of the key
     * @param keyId Unique Id of the key to prevent from spawning more than once
     * @return key object
     */
    public GameObject createKey(int x, int y, int keyId){
        --keyId;
        if(keyId < 0 || keyId >= this.keysSpawned.length){
            return null;
        }
        
        if(!this.keysSpawned[keyId]){
            this.keysSpawned[keyId] = true;
            return new Key(new Texture(  Gdx.files.internal("gameObjects/key.png")), 20, 20, x ,y, level, false, null);
        }else{
            return null;
        }    
    }
    
        /**
     * Creates a key
     * @param x x position of the key  
     * @param y y position of the key
     * @param callback function to be executed when colliding
     * @param keyId Unique Id of the key to prevent from spawning more than once
     * @return key object
     */
    public GameObject createKey(int x, int y, Callback callback, int keyId){
        --keyId;
        if(keyId < 0 || keyId >= this.keysSpawned.length){
            return null;
        }
        
        if(!this.keysSpawned[keyId]){
            this.keysSpawned[keyId] = true;
            return new Key(new Texture(  Gdx.files.internal("gameObjects/key.png")), 20, 20, x ,y, level, false, callback);
        }else{
            return null;
        }
    }
    
    /**
     * Creates a variety of game objects
     * @param objectType type of object to be selected
     * @param x x position of the object
     * @param y y position of the object
     * @param function callback to be executed
     * @return the chosen object
     */
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
            return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("tree blue")){
            return new TreeObject(new Texture(  Gdx.files.internal("gameObjects/object0.png")), 105, 115, x ,y, level, true, function);
        }else if(objectType.equals("tree green")){
            return new TreeObject(new Texture(  Gdx.files.internal("gameObjects/object1.png")), 105, 115, x ,y, level, true, function);
        }else{
            return null;
        }
    }
    
        /**
     * Creates a variety of game objects
     * @param objectType type of object to be selected
     * @param x x position of the object
     * @param y y position of the object
     * @return the chosen object
     */
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
            return new BarrelObject(new Texture(  Gdx.files.internal("gameObjects/object11.png")), 40, 40, x, y, level, true, function);
        }else if(objectType.equals("tree blue")){
            return new TreeObject(new Texture(  Gdx.files.internal("gameObjects/object0.png")), 115, 115, x ,y, level, true, function);
        }else if(objectType.equals("tree green")){
            return new TreeObject(new Texture(  Gdx.files.internal("gameObjects/object1.png")), 115, 115, x ,y, level, true, function);
        }else{
            return null;

        }
        
    }
}
