import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Intro4 extends AsteroidWorld
{
    Button button;
    GreenfootImage img;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public Intro4()
    {
       super(4, 650, 480);
    }
    public void act() {
       if (Greenfoot.mouseClicked(button)) {
          nextLevel();
       }
    }
    public void populate(){
       img = new GreenfootImage("Intro_3_resized.png");
       populateStoryImage(img, 650, 480);
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Next", 100, 50);
       addObject(button, getWidth() - 55, getHeight() - 30); 
    }
}
