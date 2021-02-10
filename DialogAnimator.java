            import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
            import java.util.ArrayList;
            /**
             * Write a description of class AnimatedActor here.
             * 
             * @author (your name) 
             * @version (a version number or a date)
             */
            public class DialogAnimator extends Actor
            {
                /**
                 * Act - do whatever the AnimatedActor wants to do. This method is called whenever
                 * the 'Act' or 'Run' button gets pressed in the environment.
                 */
                private ArrayList<GreenfootImage> images;
                private int animationSpeed;
                private int imageBuffer;
                private int currentImage = 0;
                public boolean animateBuffer()
                {
                    if (imageBuffer < 1)
                    {
                        imageBuffer = animationSpeed;
                        return true;
                    }
                    else
                        imageBuffer--;
                        
                    return false;
                }
                public DialogAnimator(String basename, String suffix, int noOfImages, int speed, int sizeX, int sizeY, ArrayList<GreenfootImage> images)
                {
                    animationSpeed = speed;
                    imageBuffer = speed;
                    this.images = images;
                    
                    setImage(images.get(currentImage));
                }
                public void act() 
                {
                    if (animateBuffer())
                    {
                        currentImage = currentImage + 1;
                        setImage(images.get(currentImage));
                    }
                } 
                public Boolean donePlaying(){
                     if(currentImage == images.size() - 1){
                         return true;
                     }
                     return false;
                }
}
