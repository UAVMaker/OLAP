package org.usfirst.frc.team1601.robot;
/**********************************************************************************
 * Author(s): Mike / Naresh
 *
 * This class is used to initialized all our objects. This will be a singleton class.
 * 
 * 	
 */

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

/**
 * 
 * @author Darvin
 *	This Class contains the Hardware. All Hardware is initialialized at the startup.
 */
public  class Hardware {
	
private Hardware(){}
/**
 * Provides an instance of the Hardware Class. 
 * @return Hardware class is initialized for print.
 */
public static Hardware getInstance(){
	return new Hardware();
}


/**
 * These are our CANTalon Objects controlling our drive. We plan to attach encoders to the CANTalon for Closed Loop Control.
 * TODO: Program Encoders 
 */
public static final CANTalon lf = new CANTalon(0);
public static final CANTalon lr = new CANTalon(1);
public static final CANTalon rf = new CANTalon(2);
public static final CANTalon rr = new CANTalon(3);
/**
 * Here is the Talon objects used for our intake tote System. 
 * 
 */
public static final Talon left_wheel = new Talon(0);
public static final Talon right_wheel = new Talon(1);
public static final Talon left_arm = new Talon(2);
public static final Talon right_arm = new Talon(3);
/**
 * This is the Gyro object we use for PIDControl of the Robot. 
 */
public static final Gyro gyro = new Gyro(0);
/**
 * Compressor is used to supply air to our 3 storage tanks onboard the Robot. 
 */
public static final Compressor airTank = new Compressor(0);
/**
 * These objects are the actuators we use to lift totes up and Down.
 * TODO: Lift Things Up and Put Them Down
 */
public static final DoubleSolenoid lf_Actuator = new DoubleSolenoid(0,1);
public static final DoubleSolenoid lr_Actuator = new DoubleSolenoid(2,3);
public static final DoubleSolenoid rf_Actuator = new DoubleSolenoid(4,5);
public static final DoubleSolenoid rr_Actuator = new DoubleSolenoid(6,7);
/**
 * Limit Switches are Digital Input Devices used to limit the travel of the arms and 
 * let the drive know the totes in position to lift. 
 */
public static final DigitalInput limit_left_arm = new DigitalInput(0);
public static final DigitalInput limit_right_arm = new DigitalInput(1);
public static final DigitalInput tote_Detector = new DigitalInput(2);
/**
 * Joystick Objects used to control the robot.
 */
public static final LogitechF310Gamepad joy1 = new  LogitechF310Gamepad(0);
public static final LogitechF310Gamepad joy2 = new  LogitechF310Gamepad(1);
/**
 * Power Distribution Panel used for the Current Monitoring of all the channels
 */
public static final PowerDistributionPanel pdb = new PowerDistributionPanel();
/**
 * BuiltInAccelerometer used to indicate if we are on the step.
 */
public static final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
/**
 * Camera Server Used to broadcast an Image from the usb camera.
 */
public static final CameraServer cam = CameraServer.getInstance();
{	cam.setQuality(50);
	cam.startAutomaticCapture("cam0");
	}
public static final Encoder leftDriveBase = new Encoder(0,1, true, EncodingType.k4X); 
public static final Encoder rightDriveBase = new Encoder(2,3, true, EncodingType.k4X);
{leftDriveBase.reset();
rightDriveBase.reset();
	}

}