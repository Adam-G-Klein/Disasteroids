import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Facecam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Facecam extends Actor
{
    private GreenfootImage happy = new GreenfootImage("facecam-happy.png");
    private GreenfootImage scared = new GreenfootImage("facecam-scared.png");
    private GreenfootImage panik = new GreenfootImage("facecam-panik.png");
    private GreenfootImage surprised = new GreenfootImage("facecam-surprised.png");
    private GreenfootImage dizzy = new GreenfootImage("facecam-dizzy.png");
    private GreenfootImage sad = new GreenfootImage("facecam-sad.png");
    private GreenfootImage angry = new GreenfootImage("facecam-angry.png");
    private GreenfootImage goodYell = new GreenfootImage("facecam-goodYell.png");
    private GreenfootImage sadYell = new GreenfootImage("facecam-sadYell.png");
    private GreenfootImage heh = new GreenfootImage("facecam-heh.png");
    private GreenfootImage glasses = new GreenfootImage("facecam-glasses.png");
    
    private GreenfootImage bossHappy = new GreenfootImage("facecam-boss-happy.png");
    private GreenfootImage bossScared = new GreenfootImage("facecam-boss-scared.png");
    private GreenfootImage bossPanik = new GreenfootImage("facecam-boss-panik.png");
    private GreenfootImage bossSurprised = new GreenfootImage("facecam-boss-surprised.png");
    private GreenfootImage bossDizzy = new GreenfootImage("facecam-boss-dizzy.png");
    private GreenfootImage bossSad = new GreenfootImage("facecam-boss-sad.png");
    private GreenfootImage bossAngry = new GreenfootImage("facecam-boss-angry.png");
    private GreenfootImage bossGoodYell = new GreenfootImage("facecam-boss-goodYell.png");
    private GreenfootImage bossSadYell = new GreenfootImage("facecam-boss-sadYell.png");
    private GreenfootImage bossHeh = new GreenfootImage("facecam-boss-heh.png");
    private GreenfootImage bossGlasses = new GreenfootImage("facecam-boss-glasses.png");
    private Hashtable<String, GreenfootImage> EmotionToImage = new Hashtable<String, GreenfootImage>();
    public Facecam() {
        populateHT();
        scaleImages();
        setImage(panik);
    }
    private String currEmotion = "panik";
    private void scaleImages(){
        for (GreenfootImage img : EmotionToImage.values())
        {
            img.scale(80,75);
            img.setTransparency(175);
        }
    }
    private void populateHT(){
        EmotionToImage.put("happy",happy);
        EmotionToImage.put("scared",scared);
        EmotionToImage.put("panik",panik);
        EmotionToImage.put("surprised",surprised);
        EmotionToImage.put("sad",sad);
        EmotionToImage.put("angry",angry);
        EmotionToImage.put("goodYell",goodYell);
        EmotionToImage.put("sadYell",sadYell);
        EmotionToImage.put("heh",heh);
        EmotionToImage.put("dizzy",dizzy);
        EmotionToImage.put("glasses",glasses);
        
        EmotionToImage.put("boss-happy",bossHappy);
        EmotionToImage.put("boss-scared",bossScared);
        EmotionToImage.put("boss-panik",bossPanik);
        EmotionToImage.put("boss-surprised",bossSurprised);
        EmotionToImage.put("boss-sad",bossSad);
        EmotionToImage.put("boss-angry",bossAngry);
        EmotionToImage.put("boss-goodYell",bossGoodYell);
        EmotionToImage.put("boss-sadYell",bossSadYell);
        EmotionToImage.put("boss-heh",bossHeh);
        EmotionToImage.put("boss-dizzy",bossDizzy);
        EmotionToImage.put("boss-glasses",bossGlasses);
        
        
    }

    public void setEmotion(String emotion){
        if(emotion != currEmotion){
            GreenfootImage img = EmotionToImage.get(emotion);
            setImage(img);
            currEmotion = emotion;
        }
    }
    
}
