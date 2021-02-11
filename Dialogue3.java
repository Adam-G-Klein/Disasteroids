import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dialogue1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue3 extends AsteroidWorld
{
    Button button;
    Button dialogueButton;
    GreenfootImage img;
    int currentDialogueIndex;
    Dialogue currentDialogue;
    ArrayList<Integer> speakerOrder;
    ArrayList<Integer> imageNumList;
    ArrayList<String> expressionList;
    DialogueBox db;
    Facecam fc;
    private ArrayList<ArrayList<GreenfootImage>> listOfImageLists = new ArrayList<ArrayList<GreenfootImage>>();
    /**
     * Constructor for objects of class Intro1.
     * 
     */
    public Dialogue3()
    {
       super(12, 650, 480);
       populateSpeakerOrder(); 
       populateImageNumList();
       populateExpressionList();
       processImages(imageNumList.size());
    }
    public void act() {
       if (Greenfoot.mouseClicked(button)) {
          nextLevel();
       }
       if (Greenfoot.mouseClicked(dialogueButton)) {
           if(currentDialogueIndex == (imageNumList.size() - 2)){
               removeObject(dialogueButton);
               nextDialogue();
           }
           else{
               nextDialogue();
            }
       }
    }
    public void populate(){
       currentDialogueIndex = 0;

       img = new GreenfootImage("Dialogue2Background.png");
       populateStoryImage(img, 650, 480);
       
       db = new DialogueBox(400, 250, 100,speakerOrder.get(currentDialogueIndex));
       int textloc = db.updateDialogueBox(speakerOrder.get(currentDialogueIndex));
       addObject(db, 250,100);
       
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Credits", 150, 50);      
       addObject(button, getWidth() - 100, getHeight() - 30);
       
       dialogueButton = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Continue", 150, 50);      
       addObject(dialogueButton, getWidth() - 100, getHeight() - 250);
       
       currentDialogue = new Dialogue("3-" + (currentDialogueIndex + 1), imageNumList.get(currentDialogueIndex),
                                      listOfImageLists.get(currentDialogueIndex));
       addObject(currentDialogue, textloc, 100);
       
       fc = new Facecam();
       fc.setEmotion(expressionList.get(currentDialogueIndex));       
       addObject(fc, 550, 100);
       if(speakerOrder.get(currentDialogueIndex) == 0){
           fc.setLocation(550,100);
        }
        else{
            fc.setLocation(100,100);
        }
    }
    public void processImages(int maxDialogueNumber){
        for(int dialogueNumber = 1; dialogueNumber < maxDialogueNumber + 1; dialogueNumber++){
            ArrayList<GreenfootImage> images = new ArrayList<GreenfootImage>();
            for(int i=0; i < imageNumList.get(dialogueNumber - 1); i++) {
                GreenfootImage img = new GreenfootImage("Dialogue3-" + dialogueNumber +
                                                        "/Dialogue3-" + dialogueNumber + "-" + i + ".png");
                img.scale(500, 174);
                images.add(img);
            }
            listOfImageLists.add(images);
        }
    }
    public void populateSpeakerOrder(){
        speakerOrder = new ArrayList<Integer>();
        speakerOrder.add(1);
        speakerOrder.add(1);
        speakerOrder.add(0);
    }
    public void populateImageNumList(){
        imageNumList = new ArrayList<Integer>();
        imageNumList.add(98);
        imageNumList.add(25);
        imageNumList.add(73);
    }
    public void populateExpressionList(){
        expressionList = new ArrayList<String>();
        expressionList.add("heh");
        expressionList.add("angry");
        expressionList.add("happy");
    }
    public void nextDialogue(){
       this.removeObject(currentDialogue);
       currentDialogueIndex++;
       
       int textloc = db.updateDialogueBox(speakerOrder.get(currentDialogueIndex));
       
       if(speakerOrder.get(currentDialogueIndex) == 0){
           fc.setLocation(550,100);
        }
        else{
            fc.setLocation(100,100);
        }
       fc.setEmotion(expressionList.get(currentDialogueIndex));
       currentDialogue = new Dialogue("3-" + (currentDialogueIndex + 1), imageNumList.get(currentDialogueIndex),
                                      listOfImageLists.get(currentDialogueIndex));
       addObject(currentDialogue, textloc, 100);
    }
}
