import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannonball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannonball extends Actor
{
    /**
     * Act - do whatever the Cannonball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private float movAngle;
    private GreenfootImage img;
    public Vector2 nextPos;
    private int rotation = 0;
    public Cannonball(int rotation){
        img = new GreenfootImage("Cannonball_resized.png");
        setImage(img);
        movAngle = rotation;
    }
    public void act() 
    {
        img.rotate(5);
        nextPos = Vector2.moveAtAngle(new Vector2(getX(), getY()), movAngle, 3);
        setLocation((int)nextPos.x, (int)nextPos.y);
    }  
}
