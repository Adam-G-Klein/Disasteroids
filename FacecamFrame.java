import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FacecamFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FacecamFrame extends Actor
{
    /**
     * Act - do whatever the FacecamFrame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img;
    public FacecamFrame(){
        img = new GreenfootImage("facecam-frame.png");
        img.scale(150,112);
        setImage(img);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
