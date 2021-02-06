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
    private Asteroid asteroid;
    private int size;
    private Ship ship;
    public AsteroidCrackingParticles(int rotation, Asteroid asteroid, int size, Ship ship)
    {
        super("AsteroidCracking",".png", 7, rotation, 20, size, size);
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
            World space = getWorld();
            space.removeObject(asteroid);    
            space.addObject(new AsteroidBlowupParticles(0, size), getX(), getY());
            ship.updateAsteroidsBeingMined(-1);
            space.removeObject(this);
        }
        // Add your action code here.
    }    
}

