import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    //beam colliders
    private CircleCollider shipColl = new CircleCollider(125, "Ship");
    private List<CircleCollider> beamColls = new ArrayList<CircleCollider>();
    private int numColliders = 5;
    private float betweenColliders = 20f;
    private int beamColliderRadius = 30;
    private boolean miningStatus = false;
    private int asteroidsBeingMined = 0;
    public Ship(World w){
        img = new GreenfootImage("Spaceship-Undamaged.png");
        //img.scale(160,212);
        setImage(img);
        CircleCollider c;
        for(int i = 0; i < numColliders; i+=1){
            c = new CircleCollider(beamColliderRadius, "Beam");
            w.addObject(c, 300, 300);
            beamColls.add(c);
        }
        w.addObject(shipColl, 300, 305);
    }
    
    public void act() 
    {
        placeColliders();
        if(!miningStatus){
            if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
                rotation = getRotation() - 2;
                setRotation(rotation);
            }
            if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
                rotation = getRotation() + 2;
                setRotation(rotation);
            }
        }
    }
    public int getBeamAngle(){
        return rotation - 180;
    }
    public Vector2 getPosition(){
        return new Vector2(getX(), getY());
    }
    private void placeColliders(){
        Vector2 centerPos = Utils.dirFromAngle(getBeamAngle());
        int toEachSide = (int) -Math.floor(numColliders/2);
        int colliderNum = -toEachSide;
        Vector2 collPos;
        System.out.println("beamAngle: " + getBeamAngle() + " angs: ");
        for(int i = 0; i < numColliders; i += 1){
            collPos = Utils.dirFromAngle(getBeamAngle() - 80 + (colliderNum * betweenColliders));
            //System.out.print(" " + (getBeamAngle() + (colliderNum * betweenColliders)) + " ");
            collPos.multiply(80,80);
            collPos.add(300,300);
            beamColls
                .get(i)
                .setLoc(collPos);
            colliderNum += 1;
        }
        
    }
    public void setMining(boolean mining){
        miningStatus = mining;
    }
    public void updateAsteroidsBeingMined(int amount){
        asteroidsBeingMined = asteroidsBeingMined + amount;
        if(asteroidsBeingMined == 0){
            setMining(false);
        }
        else{
            setMining(true);
        }
    }
}
