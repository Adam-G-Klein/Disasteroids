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
    private Asteroid a;
    public AsteroidCrackingParticles(int rotation, Asteroid asteroid)
    {
        super("AsteroidCracking",".png", 7, rotation, 20);
        a = asteroid;
    }
    public void act() 
    {
        if(!super.donePlaying()){
            super.act();    
        }
        else{
            World space = getWorld();
            space.removeObject(a);    
            space.addObject(new AsteroidBlowupParticles(0), getX(), getY());
            space.removeObject(this);
        }
        // Add your action code here.
    }    
}

