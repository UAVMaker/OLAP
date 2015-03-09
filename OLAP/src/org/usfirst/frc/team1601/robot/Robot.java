
package org.usfirst.frc.team1601.robot;

import org.usfirst.frc.team1601.auto.AutoTest;
import org.usfirst.frc.team1601.threads.ArmController;
import org.usfirst.frc.team1601.threads.DriveController;
import org.usfirst.frc.team1601.threads.PneumaticController;
import org.usfirst.frc.team1601.threads.Sensors;
import org.usfirst.frc.team1601.threads.Wheels;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	Hardware hardware = Hardware.getInstance();
	PneumaticController elevator = new PneumaticController();
	DriveController drive = new DriveController();
	ArmController arms = new ArmController();
	Wheels wheel = new Wheels();
	AutoTest test = new AutoTest();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	Debugger.defaultOn();
    	Debugger.println("Starting Robot in RobotInit().");
    	Sensors.lastTime = System.currentTimeMillis();
    }
    public void autonomousInit(){
    	test.start();
    }

    public void teleopInit(){
    	
    	arms.start();
    	drive.start();
    	elevator.start();
    	test.interrupt();// just in case
    	wheel.start();
    	
    }
    
    public void disabledInit(){
    
    	arms.interrupt();
    	drive.interrupt();
    	elevator.interrupt();
    	test.interrupt();
    	wheel.interrupt();
    }
    
}
