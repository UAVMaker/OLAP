package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Functions;

import edu.wpi.first.wpilibj.Gyro;

public class DriveAlgorithms {

	private double max;
	private double deadBand = 0.09;
	private double leftSpeed = 0;
	private double rightSpeed = 0;
	public QSPID pid;
	public void tankDrive(double left, double right) {
		this.tankDrive(left, right, false);
	}

	public void tankDrive(double left, double right, boolean squareInput) {
		if (squareInput) {
			if (left >= deadBand) {
				left = (left * left);
			} else if (left >= (-deadBand)) {

				left = -(left * left);
			}
			if (right >= 0.0) {
				right = (right * right);
			} else {
				right = -(right * right);
			}

		}
		setLeftSpeed(left);
		setRightSpeed(right);

	}
	public void gyroDrive(double CurrAngle, double desireAngle, double Kp, double Ki, double Kd, double tolerance){
		double left, right;
		
		pid.setConstants(Kp, Ki, Kd);
		pid.setDoneRange(tolerance);
		pid.setMaxOutput(.2);
		pid.setDesiredValue(desireAngle);
		left = pid.calcPID(CurrAngle);
		right = pid.calcPID(CurrAngle);
		setLeftSpeed(left);
		setRightSpeed(right);
	}

	public void kajDrive(double moveValue, double rotateValue) {
		kajDrive(moveValue, rotateValue, false);
	}

	public void kajDrive(double moveValue, double rotateValue,
			boolean squaredInputs) {

		if (squaredInputs) {
			// square the inputs (while preserving the sign) to increase fine
			// control while permitting full power
			if (moveValue >= deadBand) {
				moveValue = (moveValue * moveValue);
			} else if (moveValue <= -deadBand) {
				moveValue = -(moveValue * moveValue);
			} else {
				moveValue = 0.0;
			}
			if (rotateValue >= deadBand) {
				rotateValue = (rotateValue * rotateValue);
			} else if (rotateValue <= -deadBand) {
				rotateValue = -(rotateValue * rotateValue);
			} else {
				rotateValue = 0.0;
			}
		}

		double leftMotorSpeed;
		double rightMotorSpeed;
		if (moveValue > 0.0) {
			if (rotateValue > 0.0) {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} else {
			if (rotateValue > 0.0) {
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} else {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}
		setLeftSpeed(leftMotorSpeed);
		setRightSpeed(rightMotorSpeed);
	}

	public void logDrive(double linear, double curve) {
		double m_sensitivity = 0.5;
		if (curve < 0) {
			double value = Math.log(-curve);
			double ratio = (value - m_sensitivity) / (value + m_sensitivity);
			if (ratio == 0) {
				ratio = .0000000001;
			}
			leftSpeed = linear / ratio;
			rightSpeed = linear;
		} else if (curve > 0) {
			double value = Math.log(curve);
			double ratio = (value - m_sensitivity) / (value + m_sensitivity);
			if (ratio == 0) {
				ratio = .0000000001;
			}
			leftSpeed = linear;
			rightSpeed = linear / ratio;
		} else {
			leftSpeed = linear;
			rightSpeed = linear;
		}
		this.setLeftSpeed(leftSpeed);
		this.setRightSpeed(rightSpeed);
	}

	public void setMaxSpeed(double maximum) {
		max = maximum;
	}

	public void setLeftSpeed(double speed) {
		speed = Functions.limitValue(speed, max);
		leftSpeed = speed;
	}

	public void setRightSpeed(double speed) {
		speed = Functions.limitValue(speed, max);
		rightSpeed = speed;
	}

	public double getRightSpeed() {
		return rightSpeed;
	}

	public double getLeftSpeed() {
		return leftSpeed;
	}
}
