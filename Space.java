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
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        img = new GreenfootImage("background.jpg");
        setBackground(img);
        addObject(new Cannon(), 300, 300);
        addObject(new Ship(), 300, 300);
    }
    
    public void act(){
        spawnAsteroids();
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
}
