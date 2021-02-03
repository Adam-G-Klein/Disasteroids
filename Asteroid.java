import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private float movAngle;
    private GreenfootImage img;
    public Vector2 nextPos;
    public Vector2 currPos;
    public Asteroid(int width, int height, float angle){
        img = new GreenfootImage("rock.png");
        img.scale(width,height);
        setImage(img);
        movAngle = angle;
    }
    public void act() 
    {
        nextPos = Vector2.moveAtAngle(new Vector2(getX(), getY()), movAngle, 3);
        setLocation((int)nextPos.x, (int)nextPos.y);
    }    
}
