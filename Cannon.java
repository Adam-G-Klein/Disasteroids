import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;
/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img;
    public Cannon(){
        img = new GreenfootImage("Undamaged-Spaceship-Down-sized-2.png");
        setImage(img);
        
    }
    
    public void act() 
    {
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            Vector2 dir = new Vector2(mouse.getX(), mouse.getY());   
            dir.add(-350,-350);
            //dead zone to stop spazzing when mouse over center of screen
            if(dir.getMagnitude() >= 60){
                dir.normalize();
                setRotation((int)Utils.angleFromDir(dir));
            }
        }
        
    }    
    
    
    
    
    
}
