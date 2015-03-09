package org.usfirst.frc.team1601.robot;


/*********************************************************
 *This class provides useful functions for everyday use. 
 * @author Naresh 
 * 
 * 
 * *******************************************************
 */
public class Functions {
    /**
     * Limits the value parsed through the parameter to 1;
     */
    public static double limitValue(double val) {
        return Functions.limitValue(val, 1.0);
    }
    /**
     * 
     * @param val Variable that is Constantly Changing
     * @param max Maximum Value the variable will be limited to. 
     * @return returns the variable after checking if its within limits
     */
    public static double limitValue(double val, double max) {
        if(val > max) {
            return max;
        } else if(val < -max) {
            return -max;
        } else {
            return val;
        }
    }
    
    public static double squareMaintainSign(double val) {
        double output = val * val;
        
        //was originally regative
        if(val < 0) {
            output = -output;
        }
        
        return output;
    }
    
    public static double power3MaintainSign(double val){
    	double output = val*val*val;
    	return output;
    }
    
    public static double calcLeftDrive(double x, double y) {
        return Functions.limitValue(y + x);
    }
    
    public static double calcRightDrive(double x, double y) {
        return Functions.limitValue(y - x);
    }
    
    
    
}