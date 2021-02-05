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
        super(0, 650, 480);
        populate();
    }
    public void act() {
        if (Greenfoot.mouseClicked(button)) {
            nextLevel();
        }
    }
    public void populate(){
        img = new GreenfootImage("Intro-0_resized.png");
        populateStoryImage(img, 650, 480, button, "Next");
    }
}
