package WIP;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTuner {
	double p = 0, i = 0, d = 0, f = 0;
	
	String name;
	public PIDTuner(String n){
	
		name = n;
		SmartDashboard.putNumber("p-" + name, p);
		SmartDashboard.putNumber("i-" + name, i);
		SmartDashboard.putNumber("d-" + name, d);
		SmartDashboard.putNumber("f-" + name, f);
	}
	
	public double getP(){
		return p;
	}
	public double getI(){
		return i;
	}
	public double getD(){
		return d;
	}
	public double getF(){
		return f;
	}
	public void dash(){
		p = SmartDashboard.getNumber("p-" + name);
		d = SmartDashboard.getNumber("d-" + name);
		i = SmartDashboard.getNumber("i-" + name);
		f = SmartDashboard.getNumber("f-" + name);
	}
}