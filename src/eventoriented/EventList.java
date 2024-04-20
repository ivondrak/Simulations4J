package eventoriented;

/**
 * EventList class. List of events.<p>
 *
 * @version 1.0, Feb 14, 2011
 * @author Ivo Vondrak
 */
public class EventList {
	/**
	 * First event in a list
	 */
	EventNotice firstEvent;
	/**
	 * Length of a list
	 */
	int length;
	
	/**
	 * Constructor
	 */
	public EventList() {
		firstEvent = null;
		length = 0;
	}
	
	/**
	 * Get first event
	 */
	public EventNotice firstEvent() {
		return firstEvent;
	}
	
	/**
	 * Set first event
	 */
	public void firstEvent(EventNotice event) {
		firstEvent = event;
	}
	
	/**
	 * Get length
	 */
	public int length() {
		return length;
	}
	
	/**
	 * Set length
	 */
	public void length(int length) {
		this.length = length;
	}
}
