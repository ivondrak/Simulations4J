/**
 * SimulationFramework class. Generic simulation framework.<p>
 *
 * @version 1.0, Feb 11, 2011
 * @author Ivo Vondrak
 */
public abstract class SimulationFramework {
	/**
	 * Simulation sample
	 */
	double sample;
	/**
	 * Simulation monitor
	 */
	public Monitor monitor;
	/**
	 * Resulting histogram
	 */
	public Histogram histogram;
	
	/**
	 * Constructor
	 */
	public SimulationFramework(int numOfSamples, double low, double high, int numOfClasses) {
		this.sample = 0.0;
		monitor = new Monitor(numOfSamples);
		histogram = new Histogram(low, high, numOfClasses);
	}
	
	/**
	 * Run the simulation
	 */
	public void run() {
		do {
			this.generate();
			this.update();
		}
		while (monitor.anotherSample());
		this.show();
	}

	/**
	 * Update variables
	 */
	abstract public void generate();
	
	/**
	 * Update variables
	 */
	public void update() {
		histogram.update(sample);
	}
	
	/**
	 * Show results
	 */
	public void show() {
		histogram.show();
	}
}
