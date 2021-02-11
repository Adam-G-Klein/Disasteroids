
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends AsteroidWorld
{

    /**
     * Constructor for objects of class Space.
     * 
     */
    private GreenfootImage img;
    private static Facecam fc;
    private Ship ship;
    private CannonballCounter cbc;
    private EmotionController ec;
    private Cannon cannon;
    public int playerHealth = 3;
    private int startingCannonballs = 3;
    private boolean debugMode = false;
    private int spawnRate = 10;
    public int score;
    private float streakTimer = 0;
    private ScoreBoard sb;
    private AsteroidSpawner as;
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(8, 600, 600);
        //addObject(new MiningParticles(), 250, 350);
        //addObject(new CannonParticles(), 350, 250);
    }
    
    public void act(){
        handleStreakEmotion();
        as.updateValues(score);
        if(Greenfoot.mouseClicked(null)){
            if(cbc.getCannonballs() > 0){
                spawnCannonParticles();
                updateCBC(-1);
            }
        }
    }
    private void handleStreakEmotion(){
        if(streakTimer >= 4) {
            emotionEvent("Asteroid");
            streakTimer = 0;
        }
        if(streakTimer >= 0) streakTimer -= 0.01f;

    }
    private void spawnCannonParticles(){
        ArrayList<Actor> cannons = new ArrayList<Actor>();
        for (Object obj : getObjects(Cannon.class)) {
            cannons.add((Actor)obj);
        }
        Cannon cannon = (Cannon)cannons.get(0);
        ArrayList<Double> cannonPos = new ArrayList<Double>();
        cannonPos = cannon.GetPosition();
        int rotation = cannon.GetRotation();
        int xOffset = (int)(300 + 100 * cannonPos.get(0));
        int yOffset = (int)(300 + 100 * cannonPos.get(1));
        addObject(new Cannonball(this, rotation, xOffset, yOffset), xOffset, yOffset);
        addObject(new CannonParticles(rotation), xOffset, yOffset);
        Greenfoot.playSound("CannonBallFired.wav");
        //setEmotion("goodYell");    
    }
    private void spawnMiningParticles(){
        Vector2 shipPos = ship.getPosition();
        float shipRot = ship.getBeamAngle();
        Vector2 displacement = Utils.dirFromAngle(shipRot);
        addObject(new MiningParticles((int)shipRot), (int)(300 + 100 * displacement.x),
                                         (int)(300 + 100 * displacement.y));
    }
    //private void spawnAsteroidBlowupParticles(){
    //   addObject(new AsteroidBlowupParticles(0), 200, 200); 
    //}
    //private void spawnAsteroidCrackingParticles(){
    //   addObject(new AsteroidCrackingParticles(0), 400, 400); 
    //}
    
    
    // For now you can set happy, sad, scared, panik, surprised, dizzy,
    // angry, goodYell, sadYell, heh, glasses
    public void emotionEvent(String event){
        ec.event(event);
    }
    public void populate(){
        System.out.println("populating space");

        removeAllObjects();
        playerHealth = 3;
        img = new GreenfootImage("background.jpg");
        img.scale(700,700);
        setBackground(img);
        ship = new Ship(this);
        cannon = new Cannon();
        addObject(cannon, 300, 300);
        addObject(ship, 300, 300);
        addObject(new FacecamFrame(), 525,55);
        sb = new ScoreBoard();
        addObject(sb, 525,155);
        cbc = new CannonballCounter(startingCannonballs);
        addObject(cbc, 525,125);
        as = new AsteroidSpawner(this);
        addObject(as, -15, -15);
        fc = new Facecam();
        addObject(fc, 525,67);
        addObject(new FacecamHelmet(), 525,57);
        ec = new EmotionController(fc);
        setPaintOrder(CircleCollider.class, MiningParticles.class, Ship.class, AsteroidCrackingParticles.class, AsteroidBlowupParticles.class, 
                      Facecam.class, FacecamHelmet.class, FacecamFrame.class, Cannon.class, Asteroid.class);
    }
    public void playerDamaged(){
        ec.addToDamage(1);
        streakTimer = 0;
        if (playerHealth == 3){
            playerHealth -= 1;
            ship.setImage("Spaceship-Damaged-Once.png");
        }
        else if(playerHealth == 2){
            playerHealth -= 1;
            ship.setImage("Spaceship-Damaged-Twice.png");
        }
        else{
            if(debugMode) return;
            nextLevel();
        }
    }
    
    public void addToScore(int val){
        score += val;
        streakTimer += val;
        updateScoreboard(10);
    }
    public void updateCBC(int amount){
        cbc.updateCannonballs(amount);
    }
    public void updateScoreboard(int amount){
        sb.updateScore(amount);
    }
    public Ship getShip(){
        return ship;
    }
    public void removeAsteroid(Asteroid ast){
        removeObject(ast);
        as.removeAsteroid(ast);
    }
}
