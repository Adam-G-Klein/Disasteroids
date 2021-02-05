import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FacecamHelmet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FacecamHelmet extends Actor
{
    /**
     * Act - do whatever the FacecamHelmet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img;
    public FacecamHelmet(){
        img = new GreenfootImage("facecam-helmet-2.png");
        img.setTransparency(175);
        img.scale(106,104);
        setImage(img);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
