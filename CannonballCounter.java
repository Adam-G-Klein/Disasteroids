import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CannonballCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CannonballCounter extends Actor
{
    /**
     * Act - do whatever the CannonballCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int cannonballs;
    private GreenfootImage image;
    public CannonballCounter(int startingCannonballs){
       cannonballs = startingCannonballs;
       image = new GreenfootImage("Ammo: " + cannonballs, 30, Color.WHITE, Color.BLACK);
       setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void updateCannonballs(int amount){
       cannonballs += amount;
       image = new GreenfootImage("Ammo: " + cannonballs, 30, Color.WHITE, Color.BLACK);
       setImage(image);
    }
    public int getCannonballs(){
       return cannonballs;
    }
    
}
