import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        super(4, 700, 700); 
        //addObject(new MiningParticles(), 250, 350);
        //addObject(new CannonParticles(), 350, 250);
    }
    
    public void act(){
        spawnAsteroids();
        int num = Greenfoot.getRandomNumber(100);
        if(num == 5)
            setEmotion("panik");
        if(num == 10)
            setEmotion("goodYell");
        if(num == 15)
            setEmotion("angry");
        if(num == 20)
            setEmotion("glasses");
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
        addObject(new Cannon(), 350, 350);
        addObject(new Ship(), 350, 350);
        addObject(new FacecamFrame(), 625,55);
        fc = new Facecam();
        addObject(fc, 625,67);
        addObject(new FacecamHelmet(), 625,57);
    }
    
}
