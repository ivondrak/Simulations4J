/**
 * Monitor class. Monitoring the execution of the simulation.<p>
 *
 * @version 1.0, Feb 11, 2011
 * @author Ivo Vondrak
 */

public class Monitor {
	/**
	 * Length of the simulation
	 */
	int numOfSamples
	;
	
	/**
	 * Constructor
	 */
	public Monitor(int numOfSamples) {
		this.numOfSamples = numOfSamples;
	}
	
	/**
	 * Return if the simulation should continue
	 */
	public boolean anotherSample() {
		// It must be more available then time step
		numOfSamples--;
		if (numOfSamples > 0)
			return true;
		else
			return false;			
	}

}