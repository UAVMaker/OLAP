package org.usfirst.frc.team1601.threads;

import edu.wpi.first.wpilibj.CounterBase;

public class RotationalSpeedCalculator {
	private CounterBase e;
	private int tickPerRevolution;
	private int prevTicks;
	private long prevTime;
	private int cycleCountDown;
	private int cyclesToWait;
	private double speed;

	public RotationalSpeedCalculator(CounterBase encoder,
			int encoderTicksPerRev, int cyclesBetweenCalcs) {
		this.e = encoder;
		this.tickPerRevolution = encoderTicksPerRev;
		this.cyclesToWait = cyclesBetweenCalcs;
		this.prevTicks = e.get();
		this.prevTime = System.currentTimeMillis();
		this.cycleCountDown = 0;
		this.speed = 0;
	}

	public void update() {
		if (cycleCountDown <= 0) {
			this.cycleCountDown = this.cyclesToWait;

			int currentTicks = this.e.get();
			long currTime = System.currentTimeMillis();

			int tickChange = currentTicks - this.prevTicks;
			long timeChange = currTime - this.prevTime;

			double revs = (double) tickChange / this.tickPerRevolution;
			double time = currTime / 1000 / 60.0;
			this.speed = revs / time;
			this.prevTicks = currentTicks;
			this.prevTime = currTime;
		} else {
			this.cycleCountDown--;
		}

	}

	public double getSpeed() {
		return this.speed;
	}
}