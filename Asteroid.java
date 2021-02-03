import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Vector2 movPerAct;
    private int turnsPerMov;
    private int turnCnt;
    private GreenfootImage img;
    public Vector2 nextPos;
    public Vector2 currPos;
    private float size;
    public Asteroid(int width, int height, Vector2 dir, float speed){
        img = new GreenfootImage("rock.png");
        img.scale(width,height);
        setImage(img);
        movPerAct = Vector2.mult(dir,speed);
        //TODO handle mov magnitudes < 1
        //float mag = movPerAct 
        /*if(movPerAct.getMagnitude() < 1.1f){
            turnsPerMov = (int)(1 / movPerAct.getMagnitu);
            movSpd = 1;
        }*/
        Vector2 sizeVector = new Vector2(width, height);
        size = sizeVector.getMagnitude();
        
        
        /*if(speed < 1) {

        } else {
            movSpd = speed;
            turnsPerMov = 1;
        }*/
    }
    public void act() 
    {
        /*
        nextPos = Vector2.moveAtAngle(new Vector2(getX(), getY()), movAngle, 3);
        setLocation((int)nextPos.x, (int)nextPos.y);*/
        /*
        if(turnCnt + 1 == turnsPerMov) {
            currPos = new Vector2(getX(), getY());
            setLocation((int)(currPos.x + (movDir.x * movSpd)), (int)(currPos.y + (movDir.y * movSpd)));
            turnCnt = 0;
        } else {
            turnCnt += 1;
        }*/
        currPos = new Vector2(getX(), getY());
        Vector2 nextPos;
        if(Utils.offscreenX(getWorld(), movPerAct.x, currPos) 
            || Utils.offscreenY(getWorld(), movPerAct.y, currPos)){
            getWorld().removeObject(this);
            return;
        }else{
            nextPos = new Vector2(currPos.x + movPerAct.x, currPos.y + movPerAct.y);
        }
        /*Vector2 leadingEdge = new Vector2(nextPos.x + size, nextPos.y + size);
        if(leadingEdge.x < 700 && leadingEdge.x > 0 && leadingEdge.y > 0 && leadingEdge.y < 700)
        System.out.println("color at " + leadingEdge.toString() + " is " + getWorld().getColorAt((int)leadingEdge.x, (int)leadingEdge.y));
        */
        
        setLocation((int) nextPos.x, (int) nextPos.y);
        
    }   
}
