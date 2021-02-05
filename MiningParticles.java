import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiningParticles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiningParticles extends AnimatedActor
{
    /**
     * Act - do whatever the MiningParticles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MiningParticles(int rotation)
    {
        super("Mining_Particles",".png",9, rotation + 90);
        System.out.println(rotation);
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
