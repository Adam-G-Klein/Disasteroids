import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends AsteroidWorld
{
    Button button;
    GreenfootImage img;
    /**
     * Constructor for objects of class Intro1.
     *
     */
    public Credits()
    {
        super(12, 600, 600);
        populate();
    }
    public void act() {  
        if (Greenfoot.mouseClicked(button)) {
            restart();
        }
    }
    public void populate(){
       img = new GreenfootImage("credits-screen.png"); 
       populateStoryImage(img, 600, 600);
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Restart", 100, 50);
       addObject(button, getWidth() - 55, getHeight() - 30);  
    }
}
