/**
 * Agenda class. Agenda to be executed.<p>
 *
 * @version 1.0, Feb 14, 2011
 * @author Ivo Vondrak
 */
public class Agenda {
	/**
	 * Simulation clock
	 */
	Clock clock;
	/**
	 * List of events
	 */
	EventList agenda;
	/**
	 * Current event
	 */
	EventNotice currentEvent;
	
	/**
	 * Constructor
	 */
	public Agenda(Clock clock) {
		this.clock = clock;
		agenda = new EventList();
	}
	
	/**
	 * Insert new event
	 */
	public void insert(EventNotice event, EventNotice before, EventNotice after) {
		before.nextEvent(event);
		event.nextEvent(after);
	}
	
	/**
	 * Schedule event
	 */
	public void scheduleEvent(EventNotice event) {
		EventNotice that, prev, next;
		that = event;
		that.nextEvent(null);
		agenda.length(agenda.length()+1);
		if (agenda.firstEvent() == null)
			agenda.firstEvent(event);
		else {
			if (that.eventTime() < agenda.firstEvent().eventTime()) {
				that.nextEvent(agenda.firstEvent());
				agenda.firstEvent(that);
				clock.timeOfNextEvent(that.eventTime());
			}
			else {
				next = agenda.firstEvent();
				prev = null;
				while (that.eventTime() >= next.eventTime() && next.nextEvent() != null) {
					prev = next;
					next = next.nextEvent();
				}
				if (next.nextEvent() == null && that.eventTime() >= next.eventTime())
					this.insert(that,next,null);
				else
					this.insert(that, prev, next);
			}
			agenda.length(agenda.length()+1);
		}	
	}
	
	/**
	 * Get next event
	 */
	public void getNextEvent() {
		int longNumber = Integer.MAX_VALUE;
		EventNotice current;
		current = null;
		if (agenda.firstEvent() == null)
			System.out.println("ERROR! Can't remove any item from empty event list!");
		else {
			current = agenda.firstEvent();
			agenda.firstEvent(agenda.firstEvent().nextEvent());
			agenda.length(agenda.length()-1);
			clock.time(current.eventTime());
			if (agenda.firstEvent() == null)
				clock.timeOfNextEvent(longNumber);
			else
				clock.timeOfNextEvent(agenda.firstEvent().eventTime());
			currentEvent = current;
		}
	}
	
	/**
	 * Flush out event
	 */
	public void flushOutEvent() {
		currentEvent = null;
	}
	
	/**
	 * Return kond of event
	 */
	public EventType kindOfEvent() {
		return currentEvent.event();
	}
	
	/**
	 * Get transaction
	 */
	public Transaction transaction() {
		return currentEvent.transaction();
	}
	
	/**
	 * Is empty
	 */
	public boolean isEmpty() {
		return agenda.length() <= 0;
	}
}
