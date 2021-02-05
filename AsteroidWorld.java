import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class AsteroidWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class AsteroidWorld extends World
{

    /**
     * Constructor for objects of class AsteroidWorld.
     * 
     */
    static ArrayList<AsteroidWorld> worldList = new ArrayList<AsteroidWorld>();
    Integer currentLevel;
    public abstract void populate();
    public AsteroidWorld(Integer level, Integer x, Integer y)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(x, y, 1);
        currentLevel = level;
        if (currentLevel == 0){
            populateWorldList();
        }
    }
    public void nextLevel() {
       worldList.get(currentLevel).populate();
       Greenfoot.setWorld(worldList.get(currentLevel));
       currentLevel++;
    }
    public void removeAllObjects() {
       removeObjects(getObjects(null));
    }
    private void populateWorldList(){
        worldList = new ArrayList<AsteroidWorld>();
        worldList.add(new Intro2());
        worldList.add(new Intro3());
        worldList.add(new Intro4());
        worldList.add(new Space());
    }
    public void populateStoryImage(GreenfootImage img, Button button, String buttonText){
       removeAllObjects();
       img = new GreenfootImage(img);
       img.scale(650,480);
       setBackground(img);
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, buttonText, 100, 50);
       addObject(button, 595, 450);  
    }
}
