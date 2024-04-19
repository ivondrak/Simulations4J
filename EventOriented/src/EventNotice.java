/**
 * EventNotice class. Event notices.<p>
 *
 * @version 1.0, Feb 14, 2011
 * @author Ivo Vondrak
 */

enum EventType {hello,start,finish,bye}

public class EventNotice {
	/**
	 * Event time
	 */
	float eventTime;
	/**
	 * Event type
	 */
	EventType event;
	/**
	 * Transaction
	 */
	Transaction transaction;
	/**
	 * Next event
	 */
	EventNotice nextEvent;
	
	/**
	 * Constructor
	 */
	public EventNotice(Clock clock, float time, EventType event, Transaction transaction) {
		this.eventTime = clock.time()+time;
		this.event = event;
		this.transaction = transaction;
	}
	
	/**
	 * Get event time
	 */
	public float eventTime() {
		return eventTime;
	}
	
	/**
	 * Get transaction
	 */
	public Transaction transaction() {
		return transaction;
	}
	
	/**
	 * Get type of event
	 */
	public EventType event() {
		return event;
	}
	
	/**
	 * Get next event
	 */
	public EventNotice nextEvent() {
		return nextEvent;
	}
	
	/**
	 * Set next event
	 */
	public void nextEvent(EventNotice event) {
		this.nextEvent = event;
	}
}
