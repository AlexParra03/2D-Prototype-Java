package com.prototype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Door extends GameObject {

	private String id;
	private boolean open;
	
	public Door(int x, int y, Level level, String id, boolean open) {
		super(new Texture(Gdx.files.internal("gameObjects/door.png")), 64, 64, x, y, level, true);
		this.id = id;
		this.open = open;
	}

	@Override
	public void action() {
		if(!this.open) {
			for(Key key : level.inventory.keys) {
				if(key.getID().equals(this.id)) {
					level.inventory.removeKey(key);
					this.open = true;
				}
			}
		} else  {	
			level.selectLevel(level.getCurrentLevel());
		}
	}

}
