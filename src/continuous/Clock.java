package continuous;

/**
 * Clock class. Clock of a simulation.<p>
 *
 * @version 1.0, Feb 06, 2011
 * @author Ivo Vondrak
 */


public class Clock {
	/**
	 * Current time
	 */
	float now;
	/**
	 * Resolution
	 */
	float step;
	
	/**
	 * Constructor
	 */
	public Clock(float step) {
		super();
		this.now = 0.0f;
		this.step = step;
	}
	
	/**
	 * Shift a time
	 */
	public void tick() {
		now += step;
	}
	
	/**
	 * Get resolution step
	 * 
	 */
	public float step() {
		return step;
	}
	
	/**
	 * Get time
	 */
	public float time() {
		return now;
	}
}
