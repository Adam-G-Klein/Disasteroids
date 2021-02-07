import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class EmotionController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmotionController extends Actor
{
    /**
     * Act - do whatever the EmotionController wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /*
        base faces: 
            0 score no damage: panik
            10 score one or no damage: surprise
            30 score one or no damage: happy
            50 score one or no damage: glasses
            two damage: rand(scared)
        
        take damage tempFace: rand(dizzy, angry)
        cannonball destroys 3+ asteroids tempFace: rand(heh, goodYell)

    
     */
    private Facecam fc;
    private int score = 0;
    private int damage = 0;
    private String baseFace = "panik";
    private String tempFace = "";
    private float tempTimer = 0f;
    public EmotionController(Facecam fc){
        this.fc = fc;
    }
    
    public void act() 
    {
        if(tempTimer > 0) tempTimer -= 0.01f;
        else fc.setEmotion(baseFace);

    }    
    
    public void addToDamage(int val){
        damage += val;
        updateBaseEmotion();
        event("Damage");
    }
    
    public void setScore(int val){
        score = val;
        updateBaseEmotion();
    }

    private void updateBaseEmotion(){
        if(damage <= 1){
            if(score <= 10) baseFace = "panik";
            else if(score <= 30) baseFace = "surprise";
            else if(score <= 50) baseFace = "happy";
            else baseFace = "glasses";
        } else {
            baseFace = "scared";
        }

    }

    public void event(String event){
        if(event == "Asteroid"){
            tempTimer = 5f;
            tempFace = Utils.random(0,1) == 1 ? "heh" : "goodYell";
        } else if (event == "Damage") {
            tempTimer = 5f;
            tempFace = Utils.random(0,1) == 1 ? "dizzy" : "angry";
        }
        fc.setEmotion(tempFace);
    }
    
}