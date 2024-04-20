package montecarlo;

/**
 * SimulationApp class. Create app simulation robot inaccuracy.<p>
 *
 * @version 1.0, Feb 11, 2011
 * @author Ivo Vondrak
 */
public class SimulationApp extends SimulationFramework {
	/**
	 * Probability distributions
	 */
	Uniform coordF, coordZ, coordY;
	Normal inAccF, inAccZ, inAccY;
	
	double pi = 3.14159;
	
	/**
	 * Constructor
	 */
	public SimulationApp() {
		super(100,0.0,20.0,5);
		coordF = new Uniform(0,3*pi/2);
		coordZ = new Uniform(1,1.6);
		coordY = new Uniform(0.5,1.0);
		inAccF = new Normal(0,pi/500.0);
		inAccZ = new Normal(0,0.005);
		inAccY = new Normal(0.0,0.002);
	}
	
	/**
	 * Generate sample
	 */
	public void generate() {
		double f = coordF.generate();
		double z = coordZ.generate();
		double y = coordY.generate();
		
		double df = inAccF.generate();
		double dz = inAccZ.generate();
		double dy = inAccY.generate();
		
		//absolute coordinates
		double x0 = -Math.sin(f) * y;
		double y0 =  Math.cos(f) * y;
		double z0 =  z;
		double absX  = -Math.sin(f + df) * (y + dy);
		double absY  =  Math.cos(f + df) * (y + dy);
		double absZ  =  z + dz;

		  // Compute inaccuracy
		 sample = Math.sqrt(Math.pow(x0-absX,2) + Math.pow(y0-absY,2) + Math.pow(z0-absZ,2)) * 1000.0;
	}
	
	/**
	 * Show results
	 */
	public void show() {
		System.out.println("********** Innacuracy of the Robot in [mm] **********");
		super.show();
	}
	
}
