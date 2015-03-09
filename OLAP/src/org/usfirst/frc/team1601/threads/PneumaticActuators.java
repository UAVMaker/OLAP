package org.usfirst.frc.team1601.threads;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/***************************************************************
 * The PneumaticActuators Class controls the actions of the Pneumatics Actuators
 * on the robot.
 * 
 * @author Michael
 ***************************************************************
 */

public class PneumaticActuators {
	private DoubleSolenoid actuator;
	private boolean forward, reverse;

	private PneumaticActuators(DoubleSolenoid sol) {
		actuator = sol;
	}

	public static PneumaticActuators addActuator(DoubleSolenoid sol) {
		return new PneumaticActuators(sol);
	}

	public void run() {
		if (forward)
			setDoubleSolenoidForward(actuator);
		else if (reverse)
			setDoubleSolenoidReverse(actuator);
		else
			setDoubleSolenoidOff(actuator);
	}

	public void setDoubleSolenoidForward(DoubleSolenoid sol) {
		sol.set(Value.kForward);
	}

	public void setDoubleSolenoidReverse(DoubleSolenoid sol) {
		sol.set(Value.kReverse);
	}

	public void setDoubleSolenoidOff(DoubleSolenoid sol) {
		sol.set(Value.kReverse);
	}

	public void buttonForward(boolean full) {
		forward = full;
	}

	public void buttonReverse(boolean rev) {
		reverse = rev;
	}

}
