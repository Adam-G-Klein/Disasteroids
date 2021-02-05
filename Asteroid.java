import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Vector2 movPerAct;
    private Vector2 movPerActNormed;
    private int turnsPerMov;
    private int turnCnt;
    private GreenfootImage img;
    public Vector2 nextPos;
    public Vector2 currPos;
    private float size;
    private boolean hasBeenOnScreen = false;
    public Asteroid(int radius, Vector2 dir, float speed){
        img = new GreenfootImage("rock.png");
        img.scale(radius,radius);
        setImage(img);
        movPerAct = Vector2.mult(dir,speed);
        movPerActNormed = Vector2.mult(dir, speed);
        movPerActNormed.normalize();
        //TODO handle mov magnitudes < 1
        //float mag = movPerAct 
        if(Math.abs(movPerAct.getMagnitude()) < 1.1f){
            turnsPerMov = (int)(1 / movPerAct.getMagnitude()) * 4;
            movPerAct.normalize();
            movPerAct.multiply(4,4);
        } else {
            turnsPerMov = 1;
        }
        size = radius;
    }
    public void act() 
    {
        /*
        nextPos = Vector2.moveAtAngle(new Vector2(getX(), getY()), movAngle, 3);
        setLocation((int)nextPos.x, (int)nextPos.y);*/
        currPos = new Vector2(getX(), getY());
        Vector2 nextPos = currPos;
        if(!hasBeenOnScreen 
            && (!Utils.offscreenX(getWorld(), -movPerAct.x, currPos)
                && !Utils.offscreenY(getWorld(), -movPerAct.y, currPos))){
            hasBeenOnScreen = true;
            //System.out.println("setOnScreen for " + movPerAct.toString());
        }
        if(turnCnt + 1 == turnsPerMov) {
            currPos = new Vector2(getX(), getY());
            nextPos = new Vector2(currPos.x + movPerAct.x, currPos.y + movPerAct.y);
            turnCnt = 0;
        } else {
            turnCnt += 1;
        }
        if(hasBeenOnScreen 
            && (Utils.offscreenX(getWorld(), movPerAct.x, currPos) 
                || Utils.offscreenY(getWorld(), movPerAct.y, currPos))){
            getWorld().removeObject(this);
            return;
        }
        
        Vector2 leadingEdge = new Vector2(nextPos.x + movPerActNormed.x * size * 0.3f, nextPos.y + movPerActNormed.y * size * 0.3f);
        List<CircleCollider> collidersAtEdge = getWorld().getObjectsAt(
            (int) (leadingEdge.x), 
            (int) (leadingEdge.y), 
            CircleCollider.class);
        for(CircleCollider coll : collidersAtEdge){
            if(coll.tag == "Beam"){
                getWorld().removeObject(this);
                return;
            }
            else if(coll.tag == "Ship"){
                getWorld().removeObject(this);
                return;
            }
        }
        
        /*
        if(leadingEdge.x < 600 && leadingEdge.x > 0 && leadingEdge.y > 0 && leadingEdge.y < 600){
            //System.out.println("color at " + leadingEdge.toString() + " is " + );
            collisionColor = getWorld().getColorAt((int)leadingEdge.x, (int)leadingEdge.y);
            if(Math.abs(collisionColor.getRed() - 255) <= 15
                && Math.abs(collisionColor.getBlue() - 197) <= 15
                && Math.abs(collisionColor.getGreen() - 23) <= 15){
                    getWorld().removeObject(this);
                    return;
            }
        }*/
        
        setLocation((int) nextPos.x, (int) nextPos.y);
        
    }   
}
