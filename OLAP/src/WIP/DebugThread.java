package WIP;

import org.usfirst.frc.team1601.robot.Hardware;
import org.usfirst.frc.team1601.threads.QSPID;

public class DebugThread extends Thread {
	PIDTuner pid = new PIDTuner("Gyro");
	QSPID gyro = new QSPID(1, 0, 0, 0);

	public void run() {
		pid.dash();
		gyro.setConstants(pid.getP(), pid.getI(), pid.getD());
		if (Hardware.joy1.getRedButton()) {
			Hardware.lf.set(-gyro.calcPID(Hardware.gyro.getAngle()));
			Hardware.lr.set(-gyro.calcPID(Hardware.gyro.getAngle()));
			Hardware.rf.set(gyro.calcPID(Hardware.gyro.getAngle()));
			Hardware.rr.set(gyro.calcPID(Hardware.gyro.getAngle()));

		} else {
			Hardware.lf.set(0);
			Hardware.lr.set(0);
			Hardware.rf.set(0);
			Hardware.rr.set(0);
		}

	}
}
