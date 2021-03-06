
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
    private Integer currentLevel;
    public abstract void populate();
    private GreenfootSound background;
    private boolean debugMode = false;
    public AsteroidWorld(Integer level, Integer x, Integer y)
    {    
        super(x, y, 1);
        currentLevel = level;
        background = new GreenfootSound("background2.wav");
        background.setVolume(33);
        if(!debugMode) background.playLoop();
        if (currentLevel == 0){
            populateWorldList();
            currentLevel = 0;
        }
        if(debugMode){
            currentLevel = 7;
        }
    }
    public void nextLevel() {
       worldList.get(currentLevel).populate();
       Greenfoot.setWorld(worldList.get(currentLevel));
    }
    public void previousLevel() {
       // repopulates the space level from the endscreen
       int spaceLevelIndex = currentLevel - 3;
       worldList.get(spaceLevelIndex).populate();
       Greenfoot.setWorld(worldList.get(spaceLevelIndex));
       //System.out.println(currentLevel);
    }
    public void playGoodEnding(){
       int spaceLevelIndex = currentLevel + 2;
       worldList.get(spaceLevelIndex).populate();
       Greenfoot.setWorld(worldList.get(spaceLevelIndex));
    }
    public void restart(){
       int spaceLevelIndex = 0;
       worldList.get(spaceLevelIndex).populate();
       Greenfoot.setWorld(worldList.get(spaceLevelIndex));
    }
    public void removeAllObjects() {
       removeObjects(getObjects(null));
    }
    private void populateWorldList(){
        worldList = new ArrayList<AsteroidWorld>();
        worldList.add(new Intro1());
        worldList.add(new Intro2());
        worldList.add(new Intro3());
        worldList.add(new Intro4());
        worldList.add(new Dialogue1());
        worldList.add(new Manual1());
        worldList.add(new Manual2());
        worldList.add(new Manual3());
        worldList.add(new Space());
        worldList.add(new Dialogue2());
        worldList.add(new EndScreen());
        worldList.add(new Dialogue3());
        worldList.add(new Credits());
    }
    public void populateStoryImage(GreenfootImage img, Integer imgX, Integer imgY){
       removeAllObjects();
       img = new GreenfootImage(img);
       img.scale(imgX, imgY);
       setBackground(img);
    }
}
