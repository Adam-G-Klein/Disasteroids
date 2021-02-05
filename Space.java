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
        int num = Greenfoot.getRandomNumber(100);
        if(num == 5)
            setEmotion("panik");
        if(num == 10)
            setEmotion("sadYell");
        if(num == 15)
            setEmotion("angry");
        if(num == 20)
            setEmotion("glasses");
            
        int randVal = Utils.random(0,100);
        if(randVal > 98)
            spawnAsteroid();
            //addObject(new Asteroid(10, 10, new Vector2(-1, 1f), 1f), (int) 700, (int) 0);
        /*} else if (randVal > 50) {
            addObject(new Asteroid(10, 10, new Vector2(1, 1f), 1), (int) 0, (int) 0);
        } else if (randVal > 25) {
            addObject(new Asteroid(10, 10, new Vector2(1, -1f), 1), (int) 0, (int) 700);
        } else {
            addObject(new Asteroid(10, 10, new Vector2(-1, -1f), 1), (int) 700, (int) 700);
        }*/
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
    
    private void spawnAsteroid(){
        float angle = getSpawnAngle();
        Vector2 unit = getSpawnUnit(angle);
        Vector2 spawnPos = getSpawnPos(unit);
        Vector2 movDir = getMovDir(spawnPos);
        //System.out.println("unit: " + unit.toString() + " spawnPos: " + spawnPos.toString() + " movDir: " + movDir.toString());
        addObject(new Asteroid(30, 30, movDir, 0.01f), (int) spawnPos.x, (int) spawnPos.y);
    }
    
    private Vector2 getSpawnPos(Vector2 unit){
        return new Vector2((unit.x * 500) + 350, (unit.y * 500) + 350);   
    }
    
    private Vector2 getMovDir(Vector2 spawnPos){
        return Vector2.sub(new Vector2(350,350), spawnPos);
    }
    
    private float getSpawnAngle(){
        int randAng = Utils.random(0,365);
        return randAng;
    }
    
    private Vector2 getSpawnUnit(float angle){
        return Utils.dirFromAngle(angle);
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
        setPaintOrder(Ship.class, Facecam.class, FacecamHelmet.class, FacecamFrame.class, Cannon.class, Asteroid.class);
    }
    
}
