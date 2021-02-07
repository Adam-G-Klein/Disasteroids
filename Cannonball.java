import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Cannonball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannonball extends Actor
{
    /**
     * Act - do whatever the Cannonball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private float movAngle;
    private GreenfootImage img;
    public Vector2 nextPos;
    private int rotation = 0;
    private CircleCollider coll = new CircleCollider(30, "Cannonball");
    public Cannonball(World w, int rotation, int xPos, int yPos){
        img = new GreenfootImage("Cannonball_resized.png");
        setImage(img);
        movAngle = rotation;
        w.addObject(coll, xPos, yPos);
    }
    public void act() 
    {
        img.rotate(5);
        nextPos = Vector2.moveAtAngle(new Vector2(getX(), getY()), movAngle, 3);
        deleteIfOffscreen();
        //handleCollisions();
        setLocation((int)nextPos.x, (int)nextPos.y);
        coll.setLoc(nextPos);
    }  
    
    private void deleteIfOffscreen(){
        if(!Utils.onscreen(getWorld(), nextPos)){
            getWorld().removeObject(coll);
            getWorld().removeObject(this);
        }
    }
    /*
    private void handleCollisions(){
        List<CircleCollider> hits = CircleCollider.circleCast(getWorld(), currPos, size, 8); 
        for(CircleCollider coll : hits){
            if(coll.tag == "Asteroid"){
                handleBeamCollision();
                return;
            }
        } 
    }*/
}
