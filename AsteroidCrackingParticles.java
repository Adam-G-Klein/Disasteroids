import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidCrackingParticles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidCrackingParticles extends AnimatedActor
{
    /**
     * Act - do whatever the CannonParticles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AsteroidCrackingParticles(int rotation)
    {
        super("AsteroidCracking",".png", 7, rotation, 20);
    }
    public void act() 
    {
        if(!super.donePlaying()){
            super.act();    
        }
        else{
            getWorld().addObject(new AsteroidBlowupParticles(0), getX(), getY());
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }    
}

