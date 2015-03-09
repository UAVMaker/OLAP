package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Debugger;
import org.usfirst.frc.team1601.robot.Hardware;

public class DriveController extends Thread{
	DriveAlgorithms drive = new DriveAlgorithms();
	boolean tank = false;
	double left = Hardware.joy1.getLeftY();
	double right = Hardware.joy1.getRightY();
	double CurrAngle;
	double desireAngle =0;
	double Kp = 1;
	double Ki = 0;
	double Kd =0;
	double tolerance =5;
public void run(){
	Debugger.println("Drive Controller Active");
	CurrAngle = Hardware.gyro.getAngle();
	
	
	
		if (tank) {
			drive.tankDrive(left, right);
		} else if (Hardware.joy1.getBlueButton()) {
			desireAngle = 90;
			drive.gyroDrive(CurrAngle, desireAngle, Kp, Ki, Kd, tolerance);
		} else if (Hardware.joy1.getGreenButton()) {
			desireAngle = 180;
			drive.gyroDrive(CurrAngle, desireAngle, Kp, Ki, Kd, tolerance);
		} else if (Hardware.joy1.getRedButton()) {
			desireAngle = 270;
			drive.gyroDrive(CurrAngle, desireAngle, Kp, Ki, Kd, tolerance);
		} else if (Hardware.joy1.getYellowButton()) {
			desireAngle = 330;
			drive.gyroDrive(CurrAngle, desireAngle, Kp, Ki, Kd, tolerance);
		} else if (Hardware.joy1.getStartButton()) {
			desireAngle = 360;
			drive.gyroDrive(CurrAngle, desireAngle, Kp, Ki, Kd, tolerance);
		} else {
			drive.kajDrive(left, right);
		}
		
		Hardware.lf.set(-drive.getLeftSpeed());
		Hardware.lr.set(-drive.getLeftSpeed());
		Hardware.rf.set(drive.getRightSpeed());
		Hardware.rr.set(drive.getRightSpeed());
	
	
	
	
	
}
}
