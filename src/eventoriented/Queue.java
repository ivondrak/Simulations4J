package eventoriented;

/**
 * Queue class. Queue of waiting transactions.<p>
 *
 * @version 1.0, Feb 14, 2011
 * @author Ivo Vondrak
 */
public class Queue {
	/**
	 * Simulation clock
	 */
	Clock clock;
	/**
	 * Transaction references
	 */
	Transaction first, last;
	/**
	 * Length of a queue
	 */
	int length, maxLength;
	/**
	 * Time of last change
	 */
	float timeOfLastChange;
	/**
	 * Integral length
	 */
	float lengthIntegral;
	/**
	 * Start time
	 */
	float startTime;
	/**
	 * Entries and departures
	 */
	int numOfEntries, numOfDepartures;
	
	/**
	 * Constructor
	 */
	public Queue(Clock clock) {
		this.clock = clock;
		startTime = clock.time();
		first = null;
		last = null;
		length = 0;
		maxLength = 0;
		timeOfLastChange = 0f;
		lengthIntegral = 0f;
		numOfEntries = 0;
		numOfDepartures = 0;
	}
	
	/**
	 * Get length
	 */
	public int length() {
		return length;
	}
	
	/**
	 * Queue mean length
	 */
	public float meanQueueLength() {
		if (clock.time() > 0)
			return lengthIntegral/(clock.time()-startTime);
		else
			return 0f;
	}
	
	/**
	 * Queue mean delay
	 */
	public float meanQueueDelay() {
		if (clock.time() > 0)
			return lengthIntegral/(float) numOfDepartures;
		else
			return 0f;
	}	

	/**
	 * Queue max length
	 */
	public int maxQueueLength() {
		return maxLength;
	}	
	
	/**
	 * File into queue
	 */
	public void fileInto(Transaction transaction) {
		numOfEntries++;
		length++;
		lengthIntegral += (length-1)*(clock.time()-timeOfLastChange);
		timeOfLastChange = clock.time();
		if (length > maxLength)
			maxLength = length;
		if ((length-1) == 0)
			first = transaction;
		else
			last.nextInLine(transaction);
		transaction.nextInLine(null);
		last = transaction;
	}
	
	/**
	 * Take first from queue
	 */
	public Transaction takeFirst() {
		Transaction transaction;
		if (length <= 0) {
			System.out.println("Can't remove item from an empty queue!");
			return null;
		}
		else {
			numOfDepartures++;
			length--;
			lengthIntegral += (length+1)*(clock.time()-timeOfLastChange);
			timeOfLastChange = clock.time();
			transaction = first;
			first = first.nextInLine();
			transaction.nextInLine(null);
			if (length == 0)
				last = null;
			return transaction;
		}
	}
	
	/**
	 * Show status of the queue
	 */
	public void show() {
		int max = this.maxQueueLength();
		float mean = Math.round(this.meanQueueLength()*100f)/100f;
		float delay = Math.round(this.meanQueueDelay()*100f)/100f;
		System.out.println("Queue report:");
		System.out.println(Integer.valueOf(numOfEntries).toString()+" items entered!");
		System.out.println(Integer.valueOf(numOfDepartures).toString()+" items left!");
		System.out.println("Its current length is: "+Integer.valueOf(length).toString());
		System.out.println("Mean length is: "+Float.valueOf(mean).toString());
		System.out.println("Max length is: "+Integer.valueOf(max).toString());
		System.out.println("Mean delay is: "+Float.valueOf(delay).toString());
	}
	
}
