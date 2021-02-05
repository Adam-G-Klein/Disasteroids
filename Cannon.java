import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;
import java.util.ArrayList;
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
    private Integer rotation;
    public Cannon(){
        img = new GreenfootImage("Undamaged-Spaceship-Down-sized-2.png");
        setImage(img);
        
    }
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            Vector2 dir = new Vector2(mouse.getX(), mouse.getY());            
            dir.add(-300,-300);
            dir.normalize();
            rotation = (int)Utils.angleFromDir(dir);
            setRotation(rotation);
        }
        
    }
    public Integer GetRotation(){
        return rotation;
    }
    public ArrayList<Double> GetPosition(){
        double angleRad = Math.toRadians((float)rotation);
        ArrayList<Double> res = new ArrayList<Double>();
        res.add(Math.cos(angleRad));
        res.add(Math.sin(angleRad));
        return res;
    }
}
