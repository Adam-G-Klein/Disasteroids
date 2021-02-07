import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CircleCollider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleCollider extends Actor
{
    /**
     * Act - do whatever the CircleCollider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int radius;
    public String tag;
    private GreenfootImage img;
    public CircleCollider(int radius, String tag){
        this.radius = radius;
        this.tag = tag;
        img = new GreenfootImage("circle.png");
        img.scale(radius, radius);
        if(tag != "Asteroid")
            img.setTransparency(0);
        setImage(img);
    }
    
    public void act() 
    {
        
    }    
    
    public void setLoc(int x, int y){
        setLocation(x, y);
    }
    public void setLoc(Vector2 pos){
        setLocation((int)pos.x, (int)pos.y);
    }
    
    public Vector2 getLoc(){
        return new Vector2(getX(), getY());
    }
    
    public static List<CircleCollider> circleCast(World w, Vector2 centerPos, float radius, int resolution){
        List<CircleCollider> hits = new ArrayList<CircleCollider>();
        float angStep = 360 / resolution;
        Vector2 checkPos;
        List<CircleCollider> hitsAtPos;
        //System.out.println("Circ Cast from " + centerPos.toString() + " w radius " + radius);
        for(int angle = 0; angle < 360; angle += angStep){
            checkPos = Utils.dirFromAngle(angle);
            checkPos.multiply(radius);
            checkPos.add(centerPos);
            //System.out.println("\tChecking pos " + checkPos.toString());
            if(Utils.onscreen(w, checkPos)){
                hitsAtPos = w.getObjectsAt(
                    (int) (checkPos.x), 
                    (int) (checkPos.y), 
                    CircleCollider.class);            
                for(CircleCollider hit : hitsAtPos){
                    if(!hits.contains(hit)){
                        //System.out.println("\t\tnew hit: " + hit.getLoc());
                        hits.add(hit);
                    }
                }
            }
        }
        return hits;
    }
}
