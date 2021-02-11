import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class EmotionController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidSpawner extends Actor
{
    private World w;
    private int score;
    private float currentMetric = 0f;
    private float desiredMetric = 0f;
    private float initialMetric = 5f;
    
    private List<Asteroid> asteroids = new ArrayList<Asteroid>();
    public AsteroidSpawner(World w){
        this.w = w;
    }

    public void updateValues(int score){
        this.score = score;
        desiredMetric = (score / 5) + initialMetric;
    }
    
    
    public void removeAsteroid(Asteroid ast){
        System.out.println("removing ast, len: " + asteroids.size());
        asteroids.remove(ast);
        System.out.println("removed ast, len: " + asteroids.size());
    }
    private float calcMetric(){
        return asteroids.size();
    }

    public void act(){
        int randVal;
        currentMetric = calcMetric();
        if(currentMetric < desiredMetric){
            randVal = Utils.random(0, 100);
            if(randVal > 80) { //init is 990, goes down as score goes up
                System.out.println("current metric: " + currentMetric + " desired metric: " + desiredMetric);
                spawnAsteroid();
            }
        }
    }

    private void spawnAsteroid(){
        float angle = getSpawnAngle();
        Vector2 unit = getSpawnUnit(angle);
        Vector2 spawnPos = getSpawnPos(unit);
        Vector2 movDir = getMovDir(spawnPos);
        Vector2 sizeAndSpeed = getSizeAndSpeed();
        Asteroid ast = new Asteroid((int)sizeAndSpeed.x, movDir, sizeAndSpeed.y);
        asteroids.add(ast);
        w.addObject(ast, (int) spawnPos.x, (int) spawnPos.y);
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
}
