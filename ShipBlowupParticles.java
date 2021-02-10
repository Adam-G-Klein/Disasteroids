import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidCrackingParticles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShipBlowupParticles extends AnimatedActor
{
    /**
     * Act - do whatever the CannonParticles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Asteroid asteroid;
    private int size;
    private Ship ship;
    public ShipBlowupParticles()
    {
        super("SpaceshipExplosion",".png", 19, 0, 5, 160, 145);
        this.asteroid = asteroid;
        this.size = size;
        this.ship = ship;
    }
    public void act() 
    {
        if(!super.donePlaying()){
            super.act();    
        }
        else{
            Space space = (Space)getWorld();
            space.removeObject(this);
            space.setDeathAnimationDone();
        }
        // Add your action code here.
    }    
}

