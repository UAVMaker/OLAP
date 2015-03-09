package WIP;

import org.usfirst.frc.team1601.robot.Hardware;

public class PIDThread extends Thread{
	
public void run(){
	PIDDistance pid = new PIDDistance(Hardware.leftDriveBase, 6);
	System.out.println("Distance"+ pid.pidGet());
	
}
}
