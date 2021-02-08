import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CannonballCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    /**
     * Act - do whatever the CannonballCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score;
    private GreenfootImage image;
    public ScoreBoard(){
       score = 0;
       image = new GreenfootImage("Score: " + score, 30, Color.WHITE, Color.BLACK);
       setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void updateScore(int amount){
       score += amount;
       image = new GreenfootImage("Score: " + score, 30, Color.WHITE, Color.BLACK);
       setImage(image);
    }
    public int getScore(){
       return score;
    }
    
}
