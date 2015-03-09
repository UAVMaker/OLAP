package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Debugger;
import org.usfirst.frc.team1601.robot.Hardware;

public class Wheels extends Thread {
	WheelsOnTote wheels = new WheelsOnTote();
	private final double SPEED = 1;

	public void run() {
		Debugger.println("Wheels are Operational");
		if (Hardware.joy2.getRightBumper()) {
			wheels.setWheelsIncremental(SPEED);
		} else if (Hardware.joy2.getLeftBumper()) {
			wheels.setWheelsDecremental(-SPEED);
		} else {
			wheels.stopWheels();
		}

		Hardware.left_wheel.set(wheels.getLeftWheelSpeed());
		Hardware.right_wheel.set(wheels.getRightWheelSpeed());
	}
}
