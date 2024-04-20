package eventoriented;

/**
 * Clock class. Clock of a simulation.<p>
 *
 * @version 1.0, Feb 13, 2011
 * @author Ivo Vondrak
 */
public class Clock {
	/**
	 * Current time
	 */
	float now;
	/**
	 * Time of next event
	 */
	float timeOfNextEvent;
	
	/**
	 * Constructor
	 */
	public Clock(float now) {
		super();
		this.now = now;
		this.timeOfNextEvent = Float.MAX_VALUE;
	}
	
	/**
	 * Set time of new event
	 */
	public void timeOfNextEvent(float timeOfNextEvent) {
		this.timeOfNextEvent = timeOfNextEvent;
	}
	
	/**
	 * Get time of next event
	 * 
	 */
	public float timeOfNextEvent() {
		return timeOfNextEvent;
	}
	
	/**
	 * Get time
	 */
	public float time() {
		return now;
	}
	
	/**
	 * Set time
	 */
	public void time(float now) {
		this.now = now;
	}
	
	/**
	 * Show time
	 */
	public void show() {
		float temp = Math.round(now*100f)/100f;
		System.out.println("Clock time is: " + Float.toString(temp));
	}
}
