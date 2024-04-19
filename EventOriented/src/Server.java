/**
 * Server class. Server of transactions.<p>
 *
 * @version 1.0, Feb 13, 2011
 * @author Ivo Vondrak
 */
public class Server {
	/**
	 * Simulation clock
	 */
	Clock clock;
	/**
	 * Start time
	 */
	float startTime;	
	/**
	 * In use
	 */
	boolean inUse;	
	/**
	 * State
	 */
	enum State {idle, busy};
	State state;
	/**
	 * Time of last change
	 */
	float timeOfLastChange;
	/**
	 * Use integral
	 */
	float useIntegral;
	
	/**
	 * Constructor
	 */
	public Server(Clock clock) {
		this.clock = clock;
		startTime = clock.time();
		state = State.idle;		
		timeOfLastChange = 0f;
		useIntegral = 0f;
	}
	
	/**
	 * Seize the server
	 */
	public void seize() {
		if (state == State.busy)
			System.out.println("Server is busy!");
		else {
			state = State.busy;
			timeOfLastChange = clock.time();
		}
	}
	
	/**
	 * Release the server
	 */
	public void release() {
		if (state == State.idle)
			System.out.println("Server is idle!");
		else {
			useIntegral += clock.time() - timeOfLastChange;
			state = State.idle;
			timeOfLastChange = clock.time();
		}
	}
	
	/**
	 * Availability of the server
	 */
	public boolean isAvailable() {
		if (state == State.idle)
			return true;
		else 
			return false;
	}
	
	/**
	 * Utilization of the server
	 */
	public float utilization() {
		if (clock.time() > 0)
			return (useIntegral/(clock.time()-startTime)*100);
		else {
			return 0f;
		}
	}
	
	/**
	 * Show server status
	 */
	public void show() {
		float temp = Math.round(this.utilization()*100f)/100f;
		System.out.println("Utilization of the server is: "+new Float(temp).toString()+"%");
	}	
}
