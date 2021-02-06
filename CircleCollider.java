import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        //if(tag == "Beam")
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
}
