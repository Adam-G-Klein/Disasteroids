import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Hashtable;

/**
 * Write a description of class Facecam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Facecam extends Actor
{
    /**
     * Act - do whatever the Facecam wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
    private Hashtable<String, GreenfootImage> EmotionToImage = new Hashtable<String, GreenfootImage>();
    public Facecam(){
        populateHT();
        scaleImages();
        setImage(happy);
    }
    private void scaleImages(){
        for (GreenfootImage img : EmotionToImage.values())
        {
            img.scale(80,75);
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
        
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void setPicture(String emotion){
        GreenfootImage img = EmotionToImage.get(emotion);
        setImage(img);
    }
}
