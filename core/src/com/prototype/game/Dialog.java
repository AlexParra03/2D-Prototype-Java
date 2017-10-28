
package com.prototype.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;


public class Dialog implements RenderableObject {
    BitmapFont font = new BitmapFont();
    ShapeRenderer boxes = new ShapeRenderer();
    
    //Maximum allowed character per line
    private int maxCharacters = 100;
    //Maxumim allowed lines
    private int maxLines = 2;
    public boolean visible = false;
    ArrayList<String> textLines = new ArrayList<String>();
    
    // Vertical padding in which the text will be rendered before the button
    public int buttonY = 20; 
    public int buttonX = 300;
    public int buttonWidth = 50;
    public int buttonHeight = 30;
    
    private static final int WIDTH = 780;
    private static final int HEIGHT = 150;
    
    public Dialog(){
        boxes.setColor(50, 50, 50, 1);
        font.setColor(0,0,0,1);
    }
    
    public void show(String msg){
        this.visible = true;
        String[] words = msg.split(" ");
 
        int wordIndex = 0;
        // Making lines of text of complete words with no more than @charPerLine characters
        while(wordIndex < words.length-1){
            String line = "";
            for(String word : words){
                if(line.length()+word.length()+1  <= maxCharacters){
                    line += " " + word;
                    wordIndex++;
                }else{
                    break;
                }
            }
            textLines.add(line);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if(this.visible){
            batch.end();
            
            boxes.begin(ShapeRenderer.ShapeType.Filled);
            //Drawing background with black border
            boxes.setColor(0, 0, 0, 1);
            boxes.rect(10, 10, WIDTH, HEIGHT);
            boxes.setColor(200,200,200,1);
            boxes.rect(14, 14, WIDTH-8, HEIGHT-8);
            
            boxes.setColor(0,0,0,1);
            boxes.rect(buttonX, buttonY, buttonWidth, buttonHeight);
            boxes.setColor(200,200,200,1);
            boxes.rect(buttonX+3, buttonY+3, buttonWidth-4, buttonHeight-4);
            boxes.end();
            batch.begin();
            font.draw(batch, "Ok", buttonX+10, buttonY+buttonHeight-6);
            for(int sentence = 0; sentence < textLines.size(); sentence++){
                if(sentence+1 > maxLines ){ break; }
                
                font.draw(batch, textLines.get(sentence), 20, HEIGHT-(sentence*15));
            }
            
        }
    }

    @Override
    public void dispose() {
        font.dispose();
        boxes.dispose();
    }
    
    
}
