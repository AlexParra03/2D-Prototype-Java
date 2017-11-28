package com.prototype.game;

import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.utils.Array;

public class TextInput implements TextInputListener{
	
	private String inputText;
	private Array<GameObject> objects;
	
	public TextInput(Array<GameObject> objects) {
		this.objects = objects;
	}

	@Override
	public void input(String text) {
		this.inputText = text;
		System.out.println(inputText);
	}

	@Override
	public void canceled() {
		// TODO Auto-generated method stub
		
	}
	
	public String getText() {
		return inputText;
	}
	
}
