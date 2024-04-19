/**
 * Monitor class. Monitoring the execution of the simulation.<p>
 *
 * @version 1.0, Feb 13, 2011
 * @author Ivo Vondrak
 */

public class Monitor {
	/**
	 * Simukation clock
	 */
	Clock clock;
	/**
	 * Length of the simulation
	 */
	int sampleSize;
	int samplesTaken;
	/**
	 * Reference to agenda
	 */
	Agenda agenda;
	
	/**
	 * Constructor
	 */
	public Monitor(Clock clock, int sampleSize) {
		this.clock = clock;
		this.sampleSize = sampleSize;
		this.samplesTaken = 0;
		this.agenda = new Agenda(clock);
	}
	
	/**
	 * Return true if next event is available
	 */
	public boolean moreEvents() {
		// It must be more available
		if (agenda.isEmpty())
			return false;
		else
			return true;			
	}

	/**
	 * Return true if samples taken is lower than size of the samples set
	 */
	public boolean moreSamples() {
		// It must be more available
		if (samplesTaken < sampleSize)
			return true;
		else
			return false;			
	}	
	
	/**
	 * Update with a new sample
	 */
	public void update() {
		samplesTaken++;
	}
	
	/**
	 * Get number of samples taken
	 */
	public int samplesTaken() {
		return samplesTaken;
	}
	
	/**
	 * Get agenda
	 */
	public Agenda agenda() {
		return agenda;
	}
	
	/**
	 * Show monitor status
	 */
	public void show() {
		System.out.println("Number of samples taken is:"+new Integer(samplesTaken).toString());
	}	
	
}