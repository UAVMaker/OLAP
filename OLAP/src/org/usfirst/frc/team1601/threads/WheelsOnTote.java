package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Functions;

import edu.wpi.first.wpilibj.Timer;

public class WheelsOnTote {
	/*
	 * Tote Song The Wheels on the tote go round and round, round and round,
	 * round and round; The Wheels on the tote go round and round, all through
	 * the robot; The Wheels never stop when theres a totes, THERES A TOTE!!
	 * THERES A TOTE!!
	 */

	private double leftWheel, i = 0;
	private double rightWheel;

	// Think about customizing the bangbang controller for the current draw
	public void wheelsSpeed(double speed) {
		leftWheel = speed;
		rightWheel = speed;
	}

	public void setWheelsIncremental(double max) {
		i++;
		i = Functions.limitValue(i, max);
		Timer.delay(.05);
		leftWheel = i;
		rightWheel = i;
	}

	public void setWheelsDecremental(double max) {
		i--;
		i = Functions.limitValue(i, max);
		Timer.delay(.05);
		leftWheel = i;
		rightWheel = i;
	}

	public void stopWheels() {
		i = 0;
		leftWheel = 0;
		rightWheel = 0;
	}

	public double getLeftWheelSpeed() {
		return leftWheel;
	}

	public double getRightWheelSpeed() {
		return rightWheel;
	}

	public void setRightWheel(double speed) {
		rightWheel = speed;
	}

	public void setLeftWheel(double speed) {
		leftWheel = speed;
	}
}
