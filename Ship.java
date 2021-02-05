import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    private int rotation;
    public Ship(){
        img = new GreenfootImage("Spaceship-Damaged-Once.png");
        //img.scale(160,212);
        setImage(img);
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            rotation = getRotation() - 2;
            setRotation(rotation);
        }
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            rotation = getRotation() + 2;
            setRotation(rotation);
        }
    }
    public int GetRotation(){
        return rotation - 180;
    }
    public ArrayList<Double> GetPosition(){
        double angleRad = Math.toRadians((float)rotation - 180);
        ArrayList<Double> res = new ArrayList<Double>();
        res.add(Math.cos(angleRad));
        res.add(Math.sin(angleRad));
        return res;
    }
}
