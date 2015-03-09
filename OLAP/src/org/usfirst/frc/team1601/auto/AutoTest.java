package org.usfirst.frc.team1601.auto;

import edu.wpi.first.wpilibj.Timer;

public class AutoTest extends Thread{

AutoCommands auto = new AutoCommands();

public void run(){
	auto.driveStraight();
	auto.wheelsOn();
	Timer.delay(1.5);
	auto.stopDriving();
	auto.wheelsOff();
	auto.elevate();
	Timer.delay(2);
	auto.turnLeft();
	Timer.delay(1.75);
	auto.driveStraight();
	Timer.delay(1);
	auto.stopDriving();
	Timer.delay(8);
}

}
