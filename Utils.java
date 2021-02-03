
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
        float xVal = (float) Math.cos(Math.toRadians(angle));
        float yVal = (float) Math.sin(Math.toRadians(angle));
        return new Vector2(xVal, yVal);
    }

}
