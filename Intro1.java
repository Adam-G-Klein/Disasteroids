import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Intro1 extends AsteroidWorld
{
    Button button;
    GreenfootImage img;
    /**
     * Constructor for objects of class Intro1.
     *
     */
    public Intro1()
    {
        super(1, 650, 480);
    }
    public void act() {  
        if (Greenfoot.mouseClicked(button)) {
            nextLevel();
        }
    }
    public void populate(){
       img = new GreenfootImage("Intro-0_resized.png"); 
       populateStoryImage(img, 650, 480);
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Next", 100, 50);
       addObject(button, getWidth() - 55, getHeight() - 30);  
    }
}
