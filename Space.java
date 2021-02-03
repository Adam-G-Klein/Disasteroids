import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
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
        super(700, 700, 1); 
        setPaintOrder(Ship.class, Facecam.class, FacecamHelmet.class, FacecamFrame.class, Cannon.class, Asteroid.class);
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
    
    public void act(){
        int num = Greenfoot.getRandomNumber(100);
        if(num == 5)
            setEmotion("sad");
        if(num == 10)
            setEmotion("goodYell");
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
    
    
    // For now you can set happy or sad
    public static void setEmotion(String emotion){
        fc.setPicture(emotion);
    }
    
    
}
