
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dialogue1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue1 extends AsteroidWorld
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
    public Dialogue1()
    {
       super(5, 650, 480);
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

       img = new GreenfootImage("Dialogue1Background.png");
       populateStoryImage(img, 650, 480);
       GreenfootImage playerDialogueBox = new GreenfootImage("PlayerDialogue.png");
       db = new DialogueBox(400, 250, 100,speakerOrder.get(currentDialogueIndex));
       addObject(db, 400,100);
       button = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Read", 100, 50);      
       addObject(button, getWidth() - 55, getHeight() - 30);
       dialogueButton = new Button(Color.BLUE, Color.BLUE.darker(), Color.WHITE, "Continue", 150, 50);      
       addObject(dialogueButton, getWidth() - 100, getHeight() - 250);
       currentDialogue = new Dialogue("1-" + (currentDialogueIndex + 1), imageNumList.get(currentDialogueIndex),
                                      listOfImageLists.get(currentDialogueIndex));
       addObject(currentDialogue, 400, 100);
       
       fc = new Facecam();
       fc.setEmotion(expressionList.get(currentDialogueIndex));
       addObject(fc, 550, 100);
    }
    public void processImages(int maxDialogueNumber){
        for(int dialogueNumber = 1; dialogueNumber < maxDialogueNumber + 1; dialogueNumber++){
            ArrayList<GreenfootImage> images = new ArrayList<GreenfootImage>();
            for(int i=0; i < imageNumList.get(dialogueNumber - 1); i++) {
                GreenfootImage img = new GreenfootImage("Dialogue1-" + dialogueNumber +
                                                        "/Dialogue1-" + dialogueNumber + "-" + i + ".png");
                img.scale(500, 174);
                images.add(img);
            }
            listOfImageLists.add(images);
        }
    }
    public void populateSpeakerOrder(){
        speakerOrder = new ArrayList<Integer>();
        speakerOrder.add(0);
        speakerOrder.add(1);
        speakerOrder.add(1);
        speakerOrder.add(0);
        speakerOrder.add(1);
        speakerOrder.add(1);
    }
    public void populateImageNumList(){
        imageNumList = new ArrayList<Integer>();
        imageNumList.add(61);
        imageNumList.add(57);
        imageNumList.add(6);
        imageNumList.add(56);
        imageNumList.add(47);
        imageNumList.add(133);
    }
    public void populateExpressionList(){
        expressionList = new ArrayList<String>();
        expressionList.add("scared");
        expressionList.add("heh");
        expressionList.add("angry");
        expressionList.add("sad");
        expressionList.add("sadYell");
        expressionList.add("angry");
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
       currentDialogue = new Dialogue("1-" + (currentDialogueIndex + 1), imageNumList.get(currentDialogueIndex),
                                      listOfImageLists.get(currentDialogueIndex));
       addObject(currentDialogue, textloc, 100);
    }
}
