/**
 * SimulationFramework class. Generic simulation framework.<p>
 *
 * @version 1.0, Feb 11, 2011
 * @author Ivo Vondrak
 */
public abstract class SimulationFramework {
	/**
	 * Clock
	 */
	Clock clock;
	/**
	 * Simulation monitor
	 */
	Monitor monitor;
	/**
	 * Source
	 */
	Source source;
	/**
	 * Sink
	 */
	Sink sink;
	/**
	 * Queue
	 */
	Queue queue;
	/**
	 * Server
	 */
	Server server;
	/**
	 * Spend time histogram
	 */
	Histogram spentTime;
	
	/**
	 * Constructor
	 */
	public SimulationFramework(int numOfSamples) {
		clock = new Clock(0);
		monitor = new Monitor(clock, numOfSamples);
		source = new Source();
		sink = new Sink();
		queue = new Queue(clock);
		server = new Server(clock);		
	}
	
	/**
	 * Get arrival generator
	 */
	abstract Generator arrivals();
	
	/**
	 * Get service generator
	 */
	abstract Generator service();
	
	/**
	 * Run the simulation
	 */
	public void run() {
		while (monitor.moreSamples() && monitor.moreEvents()) {
			monitor.agenda().getNextEvent();
			this.execute();
			monitor.agenda().flushOutEvent();
		}
		this.show();
	}

	/**
	 * Execute simulation
	 */
	public void execute() {
	   switch (monitor.agenda.kindOfEvent()) {
	       case hello : hello(); break;
	       case start : start(); break;
	       case finish: finish( monitor.agenda.transaction()); break;
	       case bye   : bye( monitor.agenda.transaction()); break;
	      }
	}

	/**
	 * Hello event
	 */
	public void hello() {
		Transaction client;
		float time = (float) this.arrivals().generate();
		monitor.agenda().scheduleEvent(new EventNotice(clock, time, EventType.hello, null));
		client = source.create(clock);
		queue.fileInto(client);
		monitor.agenda().scheduleEvent(new EventNotice(clock, 0f,EventType.start,null));
	}
	
	/**
	 * Start event
	 */
	public void start() {
		Transaction client;
		float time = (float) this.service().generate();
		if (server.isAvailable() && queue.length() > 0) {
			server.seize();
			client = queue.takeFirst();
			monitor.agenda().scheduleEvent(new EventNotice(clock,time,EventType.finish,client));
		}
	}	
	
	/**
	 * Finish event
	 */
	public void finish(Transaction client) {
		server.release();
		monitor.agenda().scheduleEvent(new EventNotice(clock,0f,EventType.bye,client));
		monitor.agenda().scheduleEvent(new EventNotice(clock,0f,EventType.start,null));
	}
	
	/**
	 * Bye event
	 */
	public void bye(Transaction client) {
		spentTime.update(client.flowTime(clock));
		sink.remove(client);
		monitor.update();
	}	
	
	/**
	 * Show results
	 */
	public void show() {
	    monitor.show();
	    source.show();
	    sink.show();
	    queue.show();
	    server.show();
	    System.out.println("Histogram of time spent in the queue");
	    spentTime.show();
	}
}
