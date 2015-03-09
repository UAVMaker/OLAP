package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Debugger;
import org.usfirst.frc.team1601.robot.Hardware;

import edu.wpi.first.wpilibj.Timer;

public class PneumaticController extends Thread {
	public static PneumaticActuators lf = PneumaticActuators
			.addActuator(Hardware.lf_Actuator);
	public static PneumaticActuators lr = PneumaticActuators
			.addActuator(Hardware.lr_Actuator);
	public static PneumaticActuators rf = PneumaticActuators
			.addActuator(Hardware.rf_Actuator);
	public static PneumaticActuators rr = PneumaticActuators
			.addActuator(Hardware.rr_Actuator);
	private boolean forward;
	private boolean reverse;
	private boolean toteFound;

	public void run() {
		Debugger.println("Pneumatics Active");
		Hardware.airTank.setClosedLoopControl(true);
		forward = Hardware.joy2.getRightBumper();
		reverse = Hardware.joy2.getLeftBumper();
		/*
		 * These two lines take care of the left Front Actuator.
		 */
		lf.buttonForward(forward);
		lf.buttonReverse(reverse);
		/*
		 * These two lines take care of the left Rear Actuator.
		 */
		lr.buttonForward(forward);
		lr.buttonReverse(reverse);
		/*
		 * These two lines take care of the right Front Actuator.
		 */
		rf.buttonForward(forward);
		rf.buttonReverse(reverse);
		/*
		 * These two lines take care of the right Rear Actuator.
		 */
		rr.buttonForward(forward);
		rr.buttonReverse(reverse);

		/*
		 * The exciting part running a the class.
		 */
		if (toteFound) {
			automatedLift();
		} else {
			lf.run();
			lr.run();
			rf.run();
			rr.run();
		}

	}

	private void automatedLift() {
		lf.buttonForward(true);
		lr.buttonForward(true);
		rf.buttonForward(true);
		rr.buttonForward(true);
		Timer.delay(1.5);
	}

}
