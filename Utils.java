
import greenfoot.*;
/**
 * Write a description of class MouseManagement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utils  
{
    
    public static int random(int low,int high)
    {
       int greenfootVal = Greenfoot.getRandomNumber((high - low) + 1);
       return greenfootVal + low;
    }
   
    
    public static double angleFromDir(Vector2 dir){
        /// greenfoot    quadrants:
        ///    1 | 0
        /// -----|-----
        ///    2 | 3
        if (dir.x == 0)
        {
            if (dir.y >= 0) return 0;
            else return 180;
        }
        int quadrant;
        if (dir.x > 0)
            quadrant = dir.y > 0 ? 0 : 3;
        else
            quadrant = dir.y > 0 ? 1 : 2;
        double inQuadAngle = Math.toDegrees(Math.atan(dir.y / dir.x)) ;

        //float curr = currAngle % 360;
        double simpleAngle = quadrant == 0 || quadrant == 3 ? inQuadAngle : inQuadAngle + 180;
        System.out.println("inquadAngle: " + inQuadAngle + " quad: " + quadrant + " simpleAngle: " + simpleAngle);
        return simpleAngle;   
    }
        
    public static Vector2 dirFromAngle(float angle){
        float inQuadAngle;
        int quad;
        if(angle < 90){
            inQuadAngle = angle;
            quad = 0;
        } else if (angle < 180){
            inQuadAngle = angle - 90;
            quad = 1;
        } else if (angle < 270) {
            inQuadAngle = angle - 180;
            quad = 2;
        } else {
            inQuadAngle = angle - 270;
            quad = 3;
        }
        return new Vector2(0,0);
        
    }

}
