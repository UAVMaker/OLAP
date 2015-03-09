package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Debugger;
import org.usfirst.frc.team1601.robot.Hardware;

public class ArmController extends Thread {

	ArmFunctions arm = new ArmFunctions();
	double armAxis = Hardware.joy2.getTrigger();

	boolean leftLimit = Hardware.limit_left_arm.get();
	boolean rightLimit = Hardware.limit_right_arm.get();

	public void run() {
		Debugger.println("Arm Controller Active");

		if (armAxis > .1) {
			arm.expandIncremental(armAxis);

		} else if (armAxis < -.1) {
			arm.contractIncrementally(armAxis);
		} else if (leftLimit) {
			arm.hitLimitSwitch();
		} else if (rightLimit) {
			arm.hitLimitSwitch();
		} else {
			arm.stopArmsInPosition();
		}

		Hardware.left_arm.set(arm.getLeftArm());
		Hardware.right_arm.set(arm.getRightArm());
	}
}
