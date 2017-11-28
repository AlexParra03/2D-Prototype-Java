package com.prototype.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 

public class SaveFile {
 
    public static void main(String[] args) {
    	
    	ArrayList savingArray = new ArrayList();
    	//help getting these.  obviously they wouldnt be in quotes
    	savingArray.add("Level");
    	savingArray.add("Keys");
    	savingArray.add("Any checks");
    	savingArray.add("Any checks");
    	
    	try
    	{
    		File file=new File("Save.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.print(savingArray);
            
    	}
    	
    }

}
