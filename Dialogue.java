import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dialogue1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue extends DialogAnimator
{
    /**
     * Act - do whatever the CannonParticles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dialogue(String suffix, int numOfImages, ArrayList<GreenfootImage> images)
    {
        super("Dialogue" + suffix + "/Dialogue" + suffix,".png", numOfImages, 4, 500, 174, images);
    }
    public void act() 
    {
        if(!super.donePlaying()){
            super.act();    
        }

        // Add your action code here.
    }
}
