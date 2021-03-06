import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends AsteroidWorld
{
    Button button;
    GreenfootImage img;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public EndScreen()
    {
       super(11, 600, 600);
    }
    public void act() {
       if (Greenfoot.mouseClicked(button)) {
          previousLevel();
       }
    }
    public void populate(){
       img = new GreenfootImage("EndScreen_resized.png");
       populateStoryImage(img, 600, 600);
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Retry", 100, 50);
       addObject(button, getWidth() - 55, getHeight() - 30); 
    }
}

