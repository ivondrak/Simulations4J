/**
 * SimulationApp class. Create app simulation robot inaccuracy.<p>
 *
 * @version 1.0, Feb 14, 2011
 * @author Ivo Vondrak
 */
public class SimulationApp extends SimulationFramework {
	/**
	 * Arrivals distribution
	 */
	Exponential arrivals;
	/**
	 * Service distribution
	 */
	Exponential service;

	/**
	 * Constructor
	 */
	public SimulationApp() {
		super(1000);
		arrivals = new Exponential(0.8);
		service = new Exponential(1.0);
		spentTime = new Histogram(0,25,5);
		monitor.agenda().scheduleEvent(new EventNotice(clock,0,EventType.hello,null));
	}
	
	
	/**
	 * Show results
	 */
	public void show() {
		System.out.println("********** Single queue single service simulation **********");
		super.show();
	}
	
	/**
	 * Return arrivals
	 */
	public Generator arrivals() {
		return arrivals;
	}
	
	/**
	 * Return service
	 */
	public Generator service() {
		return service;
	}	
	
}
