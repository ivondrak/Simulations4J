/**
 * Transaction class. Transaction to be executed in time.<p>
 *
 * @version 1.0, Feb 13, 2011
 * @author Ivo Vondrak
 */

public class Transaction {
	/**
	 * Simulation clock
	 */
	Clock clock;
	/**
	 * Birth time
	 */
	float birthTime;

	/**
	 * Reference to next transaction
	 */
	Transaction nextInLine;
	
	/**
	 * Constructor
	 */
	public Transaction(Clock clock) {
		this.clock = clock;
		this.birthTime = clock.time();
	}
	
	/**
	 * Return flow time
	 */
	public float flowTime(Clock clock) {
		return clock.time() - birthTime;
	}

	/**
	 * Return birth time
	 */
	public float birthTimes() {
		return birthTime;			
	}	
	
	
	/**
	 * Get next transaction
	 */
	public Transaction nextInLine() {
		return nextInLine;
	}
	
	/**
	 * Set next transaction
	 */
	public void nextInLine(Transaction transaction) {
		nextInLine = transaction;
	}	
	
}