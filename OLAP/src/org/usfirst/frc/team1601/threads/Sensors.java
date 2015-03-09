package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Hardware;

public class Sensors extends Thread{
	public static double currentTime, sum,lastTime;
	RotationalSpeedCalculator rpm = new RotationalSpeedCalculator(Hardware.leftDriveBase,250, 100);
public void run(){
	System.out.println("Rpm: "+ rpm());

}
public double accelDistance(){
	// MEASUREMENTS
	   float x = (float)Hardware.accelerometer.getX();  // you know how to do that
	   float y = (float)Hardware.accelerometer.getY();
	   float z = (float)Hardware.accelerometer.getZ();

	  // MATH
	   float a = (float) Math.sqrt(x*x + y*y + z*z); // add as a vector
	   currentTime = System.currentTimeMillis();
	   sum = 0.5 * a * (currentTime - lastTime) * (currentTime - lastTime) / 1e6;  // 1e6 is correction to convert millis to seconds
	   lastTime = currentTime;  // remember time for next round
	   return sum;
}

public double pdbCurrentAtPort(int port){
	return Hardware.pdb.getCurrent(port);
}
public double rpm(){
	rpm.update();
	return rpm.getSpeed();
}


}
