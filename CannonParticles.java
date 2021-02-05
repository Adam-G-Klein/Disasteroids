import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CannonParticles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CannonParticles extends AnimatedActor
{
    /**
     * Act - do whatever the CannonParticles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CannonParticles(int rotation)
    {
        super("Cannon_Particles_resized",".png", 7, rotation + 90, 5);
    }
    public void act() 
    {
        if(!super.donePlaying()){
            super.act();    
        }
        else{
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }    
}
