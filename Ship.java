import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img;
    public Ship(){
        img = new GreenfootImage("Undamaged-spaceship.png");
        //img.scale(80,106);
        setImage(img);
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            setRotation(getRotation() - 2);
        }
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            setRotation(getRotation() + 2);
        }
    }    
}
