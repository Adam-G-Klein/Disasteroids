import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidBlowupParticles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidBlowupParticles extends AnimatedActor
{
    /**
     * Act - do whatever the CannonParticles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public AsteroidBlowupParticles(int rotation, int size)
    {
        super("AsteroidBlowup",".png", 5, rotation, 8, size * 2, size * 2);
    }
    public void act() 
    {
        if(!super.donePlaying()){
            super.act();    
        }
        else{
            World space = getWorld();
            space.removeObject(this);
        }
        // Add your action code here.
    }    
}
