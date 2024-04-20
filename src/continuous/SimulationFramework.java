package continuous;
/**
 * SimulationFramework class. Generic simulation framework.<p>
 *
 * @version 1.0, Feb 06, 2011
 * @author Ivo Vondrak
 */

public abstract class SimulationFramework {
	/**
	 * Simulation clock
	 */
	public Clock clock;
	/**
	 * Simulation monitor
	 */
	public Monitor monitor;
	/**
	 * Resulting graph
	 */
	public Graph graph;
	
	/**
	 * Constructor
	 */
	public SimulationFramework(float step, float length, float minXValue, float maxXValue, float minYValue, float maxYValue, int maxXCoord, int maxYCoord) {
		clock = new Clock(step);
		monitor = new Monitor(clock, length);
		graph = new Graph(minXValue, maxXValue, minYValue, maxYValue, maxXCoord, maxYCoord);
	}
	
	/**
	 * Run the simulation
	 */
	public void run() {
		do {
			clock.tick();
			this.update();
		}
		while (monitor.moreTime());
		this.show();
	}

	/**
	 * Update variables
	 */
	abstract public void update();
	
	/**
	 * Show results
	 */
	public void show() {
		graph.show();
	}
}
