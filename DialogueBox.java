import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogueBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueBox extends Actor
{
    /**
     * Act - do whatever the DialogueBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage firstImg;
    GreenfootImage secondImg;
    int firstX;
    int secondX;
    int yPos;
    public void act() 
    {
        // Add your action code here.
    }    
    public DialogueBox(int firstX, int secondX, int yPos, int startingSpeaker)
    {
        this.firstX = firstX;
        this.secondX = secondX;
        this.yPos = yPos;
        firstImg = new GreenfootImage("PlayerDialogue.png");
        secondImg = new GreenfootImage("BossDialogue.png");
        firstImg.scale(500,174);
        secondImg.scale(500,174);
        updateDialogueBox(startingSpeaker);
    }
    public int updateDialogueBox(Integer speaker){
        if(speaker == 0){
            setImage(firstImg);
            setLocation(firstX, yPos);
            return firstX;
        }
        else{
            setImage(secondImg);
            setLocation(secondX, yPos);
            return secondX;
        }
    }
}
