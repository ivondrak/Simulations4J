package continuous;

/**
 * Monitor class. Monitoring the execution of the simulation.<p>
 *
 * @version 1.0, Feb 06, 2011
 * @author Ivo Vondrak
 */


public class Monitor {
	/**
	 * Simulation clock
	 */
	Clock clock;
	/**
	 * Length of the simulation
	 */
	float length;
	
	/**
	 * Constructor
	 */
	public Monitor(Clock clock, float length) {
		this.clock = clock;
		this.length = length;
	}
	
	/**
	 * Return if the simulation should continue
	 */
	public boolean moreTime() {
		// It must be more available then time step
		if (length-clock.time() > clock.step())
			return true;
		else
			return false;			
	}

}
