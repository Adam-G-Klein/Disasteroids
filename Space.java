
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
    private int startingCannonballs = 10;
    private boolean debugMode = true;
    private int spawnRate = 10;
    public int score;
    private float streakTimer = 0;
    private ScoreBoard sb;
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(8, 600, 600);
        //addObject(new MiningParticles(), 250, 350);
        //addObject(new CannonParticles(), 350, 250);
    }
    
    public void act(){
        handleStreakEmotion();
        /*
        if(num == 5)
            setEmotion("panik");
        if(num == 10)
            setEmotion("sadYell");
        if(num == 15)
            setEmotion("angry");
        if(num == 20)
            setEmotion("glasses");
            */
            
        int randVal = Utils.random(0,1000);
        if(randVal > (1000 - ((score / 20) + 10))) //init is 990, goes down as score goes up
            spawnAsteroid();
        if(Greenfoot.mouseClicked(null)){
            if(cbc.getCannonballs() > 0){
                spawnCannonParticles();
                //spawnMiningParticles();
                // Proof of concept that shooting a cannonball removes one ammo;
                updateCBC(-1);
                //spawnAsteroidBlowupParticles();
                //spawnAsteroidCrackingParticles();
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
        //setEmotion("goodYell");    
    }
    //private void spawnAsteroidBlowupParticles(){
    //   addObject(new AsteroidBlowupParticles(0), 200, 200); 
    //}
    //private void spawnAsteroidCrackingParticles(){
    //   addObject(new AsteroidCrackingParticles(0), 400, 400); 
    //}
    
    private void spawnAsteroid(){
        float angle = getSpawnAngle();
        Vector2 unit = getSpawnUnit(angle);
        Vector2 spawnPos = getSpawnPos(unit);
        Vector2 movDir = getMovDir(spawnPos);
        Vector2 sizeAndSpeed = getSizeAndSpeed();
        //System.out.println("unit: " + unit.toString() + " spawnPos: " + spawnPos.toString() + " movDir: " + movDir.toString());
        addObject(new Asteroid((int)sizeAndSpeed.x, movDir, sizeAndSpeed.y), (int) spawnPos.x, (int) spawnPos.y);
    }
    
    private Vector2 getSizeAndSpeed(){
        int seed = Utils.random(1,6);
        float size = seed * 20;
        float speed = 1f / (seed * 1000);
        Vector2 ret = new Vector2(size, speed);
        return ret;
    }
    
    private Vector2 getSpawnPos(Vector2 unit){
        return new Vector2((unit.x * 500) + 350, (unit.y * 500) + 350);   
    }
    
    private Vector2 getMovDir(Vector2 spawnPos){
        return Vector2.sub(new Vector2(350,350), spawnPos);
    }
    
    private float getSpawnAngle(){
        int randAng = Utils.random(0,365);
        return randAng;
    }
    
    private Vector2 getSpawnUnit(float angle){
        return Utils.dirFromAngle(angle);
    }
    // For now you can set happy, sad, scared, panik, surprised, dizzy,
    // angry, goodYell, sadYell, heh, glasses
    public void emotionEvent(String event){
        ec.event(event);
    }
    public void populate(){
        System.out.println("populating space");

        removeAllObjects();
        playerHealth = 3;
        startingCannonballs = 10;
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
}
