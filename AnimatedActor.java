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
                public AnimatedActor(String basename, String suffix, int noOfImages, int rotation, int speed)
                {
                    animationSpeed = speed;
                    imageBuffer = speed;
                    images = new GreenfootImage[noOfImages];
                    
                    for(int i=0; i < noOfImages; i++) {
                        GreenfootImage img = new GreenfootImage(basename + '-' + i + suffix);
                        img.rotate(rotation);
                        images[i] = img;
                    }
                    
                    setImage(images[currentImage]);
                }
                public void act() 
                {
                    if (animateBuffer())
                    {
                        currentImage = currentImage + 1;
                        setImage(images[currentImage]);
                    }
                } 
                public Boolean donePlaying(){
                     if(currentImage == images.length - 1){
                         return true;
                     }
                     return false;
                }
}
