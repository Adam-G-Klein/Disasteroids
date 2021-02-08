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
    private float collRadius;
    private int widthAndHeight;
    private boolean hasBeenOnScreen = false;
    private boolean beingMined = false;
    private Ship ship;
    public Asteroid(int widthAndHeight, Vector2 dir, float speed){
        img = new GreenfootImage("Asteroid.png");
        img.scale(widthAndHeight,widthAndHeight);
        this.widthAndHeight = widthAndHeight;
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
        Vector2 temp = new Vector2(widthAndHeight,widthAndHeight);
        collRadius =  widthAndHeight / 3;
    }
    public void act() 
    {
        /*
        nextPos = Vector2.moveAtAngle(new Vector2(getX(), getY()), movAngle, 3);
        setLocation((int)nextPos.x, (int)nextPos.y);*/
        currPos = new Vector2(getX(), getY());
        deleteIfOffscreen(getWorld(), currPos);
        Vector2 nextPos = getNextPos(currPos);
        handleCollisions();
        setLocation((int) nextPos.x, (int) nextPos.y);
        
    }   
    
    private void handleCollisions(){
        List<CircleCollider> hits = CircleCollider.circleCast(getWorld(), currPos, collRadius, 8); 
        for(CircleCollider coll : hits){
            if(coll.tag == "Beam" && beingMined == false){
                handleBeamCollision();
                return;
            }
            else if(coll.tag == "Ship"){
                handleShipCollision();
                return;
            } else if(coll.tag == "Cannonball"){
                handleCannonballCollision();
                return;
            }
        }   
    }
    
    private Vector2 getNextPos(Vector2 currPos){
        if(turnCnt + 1 == turnsPerMov) {
            turnCnt = 0;
            return new Vector2(currPos.x + movPerAct.x, currPos.y + movPerAct.y);
        } else {
            turnCnt += 1;
            return currPos;
        }
    }
    
    private void deleteIfOffscreen(World w, Vector2 currPos){
        if(!hasBeenOnScreen 
            && (!Utils.offscreenX(w, -movPerAct.x, currPos)
                && !Utils.offscreenY(w, -movPerAct.y, currPos))){
            hasBeenOnScreen = true;
        }
        if(hasBeenOnScreen 
            && (Utils.offscreenX(w, movPerAct.x, currPos) 
                || Utils.offscreenY(w, movPerAct.y, currPos))){
            w.removeObject(this);
            return;
        }
    }
    
    private void handleBeamCollision(){
        beingMined = true;
        movPerAct = new Vector2(0,0);
        Space space = (Space)getWorld();
        ship = space.getShip();
        ship.updateAsteroidsBeingMined(1);
        space.updateCBC(1);
        space.addObject(new AsteroidCrackingParticles(0, this, (int)widthAndHeight, ship), getX(), getY());
    }
    
    private void handleShipCollision(){
        Space s = (Space)getWorld();
        s.addObject(new AsteroidBlowupParticles(0, (int)widthAndHeight), getX(), getY());
        s.playerDamaged();
        Greenfoot.playSound("ShipHitByAsteroid.wav");
        selfDestruct(); 
    }
    
    private void handleCannonballCollision(){
        Space s = (Space)getWorld();
        s.addObject(new AsteroidBlowupParticles(0, (int)widthAndHeight), getX(), getY());
        ((Space)getWorld()).addToScore(1);
        Greenfoot.playSound("AsteroidDestroyedByCannonball.wav");
        selfDestruct();
    }
    
    public void selfDestruct(){
        getWorld().removeObject(this);
    }
}
