/**
 * SimulationApp class. Create app simulation mass oscillation.<p>
 *
 * @version 1.0, Feb 06, 2011
 * @author Ivo Vondrak
 */
public class SimulationApp extends SimulationFramework {
	char speed = '+';
	char deviation = '*';
	char force = 'o';
	
	/**
	 * Variables
	 */
	Variable dxt, xt;
	
	/**
	 * Constructor
	 */
	public SimulationApp() {
		super(0.01f,2f,0f,2f,-12f,12f,100,50);
		dxt = new Variable(clock, 0f);
		xt = new Variable(clock, 0f);
	}
	
	/**
	 * Show results
	 */
	public void show() {
		System.out.println("********** Oscilation of the mass **********");
		System.out.println();
		System.out.print(speed);System.out.println(" for the speed");
		System.out.print(deviation);System.out.println(" for the deviation");
		System.out.print(force);System.out.println(" for the disturbing force");
		super.show();
	}
	
	/**
	 * Update variables
	 */
	public void update() {
		float f;
		if (clock.time() < 0.5)
			f = 0f;
		else
			f = 100f;
		dxt.setDerivative(f-2f*dxt.value()-100f*xt.value());
		xt.setDerivative(dxt.value());
		dxt.update();
		xt.update();
		graph.update(clock.time(), dxt.value(), speed);
		graph.update(clock.time(), xt.value(), deviation);
		graph.update(clock.time(), f/20f, force);
	}
}
