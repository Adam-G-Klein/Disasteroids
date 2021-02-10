import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialogue1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue1 extends AsteroidWorld
{
    Button button;
    GreenfootImage img;
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public Dialogue1()
    {
       super(5, 650, 480);
    }
    public void act() {
       if (Greenfoot.mouseClicked(button)) {
          nextLevel();
       }
    }
    public void populate(){
       img = new GreenfootImage("Dialogue1Background.png");
       populateStoryImage(img, 650, 480);
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Read", 100, 50);
       addObject(new Dialogue1_1(), 400, 100);
       addObject(button, getWidth() - 55, getHeight() - 30); 
    }
}
