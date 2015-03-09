package org.usfirst.frc.team1601.threads;

import org.usfirst.frc.team1601.robot.Functions;

import edu.wpi.first.wpilibj.Timer;

public class ArmFunctions {
	private double leftArm, rightArm, i;
	public void expandAtControlledRate(double rate){
		setLeftArm(rate);
		setRightArm(rate);
	}
	public void expandIncremental(double speed){
		i++;
		i = Functions.limitValue(i, speed);
		Timer.delay(.05);
		setLeftArm(i);
		setRightArm(i);
		
	}
	public void hitLimitSwitch(){
		setLeftArm(-.2);
		setRightArm(-.2);
		Timer.delay(.5);
		this.stopArmsInPosition();
	}
	public void contractAtControlledRate(double rate){
		setLeftArm(rate);
		setRightArm(rate);
	}
	
	public void contractIncrementally(double speed){
		i--;
		i = Functions.limitValue(i, speed);
		Timer.delay(.05);
		setLeftArm(i);
		setRightArm(i);
	}
	
	
	public void stopArmsInPosition(){
		setLeftArm(0);
		setRightArm(0);
		i=0;
	}
	public void setLeftArm(double speed){
		leftArm = speed;
	}
	
	public void setRightArm(double speed){
		rightArm = speed;
	}
	public double getLeftArm(){
		return leftArm;
	}
	public double getRightArm(){
		return rightArm;
	}
}
