package WIP;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;

public class PIDDistance implements PIDSource{
	Encoder encoder;
	double diameter;
	public PIDDistance(Encoder e, double d){
		encoder = e;
		diameter = d;
	}
	public double pidGet() {
		return encoder.getDistance()*diameter*Math.PI/250;
	}
}