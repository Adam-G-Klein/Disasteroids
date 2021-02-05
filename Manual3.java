import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Manual3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Manual3 extends AsteroidWorld
{
    Button button;
    GreenfootImage img;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public Manual3()
    {
       super(6, 700, 700);
    }
    public void act() {
       if (Greenfoot.mouseClicked(button)) {
          nextLevel();
       }
    }
    public void populate(){
        img = new GreenfootImage("manual3.png");
        populateStoryImage(img, 700, 700, button, "Play");
    }
}
