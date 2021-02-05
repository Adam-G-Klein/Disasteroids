import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    Color fill;
    Color outline;
    Color textColor;
    
    GreenfootImage back;
    GreenfootImage text;
    int sizeX;
    int sizeY;
    String textStr;

    public Button(Color fill, Color outline, Color textColor, String textStr, int sizeX, int sizeY) {
       this.fill = fill;
       this.outline = outline;
       this.textColor = textColor;
       
       this.sizeX = sizeX;
       this.sizeY = sizeY;
       this.textStr = textStr;
        
       back = new GreenfootImage(sizeX, sizeY);
       back.setColor(fill);
       back.fillRect(0, 0, sizeX, sizeY);
       back.setColor(outline);
       back.drawRect(0, 0, sizeX, sizeY);
       
       text = new GreenfootImage(textStr, 30, textColor, fill);
       back.drawImage(text, sizeX / 5, sizeY / 4);
       
       setImage(back);
    }
    
    public void act() {
       if (Greenfoot.mousePressed(this)) {
           back.setColor(outline);
           back.fillRect(0, 0, sizeX, sizeY);
           back.setColor(fill);
           back.drawRect(0, 0, sizeX, sizeY);
           
           text = new GreenfootImage(textStr, 30, textColor, outline);
           back.drawImage(text, sizeX / 4, sizeY / 4);
           setImage(back);
       }
       else if (Greenfoot.mousePressed(this)) {
           back.setColor(fill);
           back.fillRect(0, 0, sizeX, sizeY);
           back.setColor(outline);
           back.drawRect(0, 0, sizeX, sizeY);
           
           text = new GreenfootImage(textStr, 30, textColor, fill);
           back.drawImage(text, sizeX / 4, sizeY / 4);
           setImage(back);
       }
    }
}
