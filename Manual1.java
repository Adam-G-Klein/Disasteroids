import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Manual1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Manual1 extends AsteroidWorld
{
    Button button;
    GreenfootImage img;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public Manual1()
    {
       super(4, 700, 700);
    }
    public void act() {
       if (Greenfoot.mouseClicked(button)) {
          nextLevel();
       }
    }
    public void populate(){
        img = new GreenfootImage("manual1.png");
        populateStoryImage(img, 700, 700, button, "Read");
    }
}
