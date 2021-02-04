import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Actor
{
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] images;
    private int imageBuffer = 5;
    private int currentImage = 0;
    public boolean animateBuffer()
    {
        if (imageBuffer < 1)
        {
            imageBuffer = 5;
            return true;
        }
        else
            imageBuffer--;
            
        return false;
    }
    public AnimatedActor(String basename, String suffix, int noOfImages)
    {
        images = new GreenfootImage[noOfImages];
        
        for(int i=0; i < noOfImages; i++) {
            images[i] = new GreenfootImage(basename + '-' + i + suffix);
        }
        
        setImage(images[currentImage]);
    }
    public void act() 
    {
        if (animateBuffer())
            currentImage = (currentImage + 1) % images.length;
            setImage(images[currentImage]);
    }   
}
