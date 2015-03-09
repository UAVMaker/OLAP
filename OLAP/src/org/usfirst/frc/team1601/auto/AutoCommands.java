package org.usfirst.frc.team1601.auto;

import org.usfirst.frc.team1601.robot.Hardware;
import org.usfirst.frc.team1601.threads.DriveAlgorithms;
import org.usfirst.frc.team1601.threads.PneumaticController;
import org.usfirst.frc.team1601.threads.WheelsOnTote;

public class AutoCommands {
	DriveAlgorithms drive = new DriveAlgorithms();
	WheelsOnTote wheels = new WheelsOnTote();
	
public void driveStraight(){
	drive.kajDrive(1, 0);
	output();
	
}
public void stopDriving(){
	drive.kajDrive(0, 0);
	output();

}
public void wheelsOn(){
	wheels.setWheelsIncremental(1);
	outputWheels();
	
}
public void wheelsOff(){
	wheels.stopWheels();
	outputWheels();
	
}
public void elevate(){
PneumaticController.lf.buttonForward(true);
PneumaticController.rf.buttonForward(true);
PneumaticController.lr.buttonForward(true);
PneumaticController.rr.buttonForward(true);

}
public void deelevate(){
PneumaticController.lf.buttonReverse(true);
PneumaticController.rf.buttonReverse(true);
PneumaticController.lr.buttonReverse(true);
PneumaticController.rr.buttonReverse(true);

}

private void outputWheels(){
	Hardware.left_wheel.set(wheels.getLeftWheelSpeed());
	Hardware.right_wheel.set(wheels.getRightWheelSpeed());
}

private void output(){
	Hardware.lf.set(-drive.getLeftSpeed());
	Hardware.lr.set(-drive.getLeftSpeed());
	Hardware.rf.set(drive.getRightSpeed());
	Hardware.rr.set(drive.getRightSpeed());
}
public void turnLeft() {
drive.kajDrive(0, -1);
	
}
}
