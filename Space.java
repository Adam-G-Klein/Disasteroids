import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends AsteroidWorld
{

    /**
     * Constructor for objects of class Space.
     * 
     */
    private GreenfootImage img;
    private static Facecam fc;
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(7, 600, 600);
        //addObject(new MiningParticles(), 250, 350);
        //addObject(new CannonParticles(), 350, 250);
    }
    
    public void act(){
        spawnAsteroids();
        int num = Greenfoot.getRandomNumber(100);
        if(num == 5)
            setEmotion("panik");
        if(num == 10)
            setEmotion("sadYell");
        if(num == 15)
            setEmotion("angry");
        if(num == 20)
            setEmotion("glasses");
        if(Greenfoot.mouseClicked(null)){
            spawnCannonParticles();
            spawnMiningParticles();
        }
    }
    private void spawnCannonParticles(){
        ArrayList<Actor> cannons = new ArrayList<Actor>();
        for (Object obj : getObjects(Cannon.class)) {
            cannons.add((Actor)obj);
        }
        Cannon cannon = (Cannon)cannons.get(0);
        ArrayList<Double> cannonPos = new ArrayList<Double>();
        cannonPos = cannon.GetPosition();
        int rotation = cannon.GetRotation();
        int xOffset = (int)(300 + 100 * cannonPos.get(0));
        int yOffset = (int)(300 + 100 * cannonPos.get(1));
        addObject(new Cannonball(rotation), xOffset, yOffset);
        addObject(new CannonParticles(rotation), xOffset, yOffset);
        setEmotion("goodYell");    
    }
    private void spawnMiningParticles(){
        ArrayList<Actor> ships = new ArrayList<Actor>();
        for (Object obj : getObjects(Ship.class)) {
            ships.add((Actor)obj);
        }
        Ship ship = (Ship)ships.get(0);
        ArrayList<Double> shipPos = new ArrayList<Double>();
        shipPos = ship.GetPosition();
        addObject(new MiningParticles(ship.GetRotation()), (int)(300 + 100 * shipPos.get(0)),
                                         (int)(300 + 100 * shipPos.get(1)));
        setEmotion("goodYell");    
    }
    
    private void spawnAsteroids(){
        float angle = getSpawnAngle();
        Vector2 pos = getSpawnPos(angle);

    }
    
    private float getSpawnAngle(){
        int side = Utils.random(0,1);
        if(side == 0){
            return Utils.random(1, 210);
        } else { 
            return Utils.random(240, 359);
        }
    }
    
    private Vector2 getSpawnPos(float angle){
        Vector2 spawnUnitVector = Utils.dirFromAngle(angle);
        return new Vector2(spawnUnitVector.x * 850, spawnUnitVector.y * 850);
    }
    // For now you can set happy, sad, scared, panik, surprised, dizzy,
    // angry, goodYell, sadYell, heh, glasses
    public static void setEmotion(String emotion){
        fc.setPicture(emotion);
    }
    public void populate(){
        removeAllObjects();
        img = new GreenfootImage("background.jpg");
        img.scale(700,700);
        setBackground(img);
        addObject(new Cannon(), 300, 300);
        addObject(new Ship(), 300, 300);
        addObject(new FacecamFrame(), 525,55);
        fc = new Facecam();
        addObject(fc, 525,67);
        addObject(new FacecamHelmet(), 525,57);
    }
    
}
