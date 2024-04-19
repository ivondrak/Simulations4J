// Variable

/**
 * Variable class. Keeps value of the simulation variable.<p>
 *
 * @version 1.0, Feb 06, 2011
 * @author Ivo Vondrak
 */
public class Variable {
	/**
	 * Simulation clock
	 */
	protected Clock clock;
	/**
	 * Value of the variable
	 */
	protected float value;
	
	/**
	 * Derivative of the variable
	 */
	protected float derivative;
	
	/**
	 * Constructor
	 */
	public Variable(Clock clock, float value) {
		this.clock = clock;
		this.value = value;
	}
	
	/**
	 * Set derivative value
	 */
	public void setDerivative(float derivative) {
		this.derivative = derivative;
	}
	
	/**
	 * Get value of variable
	 */
	public float value() {
		return value;
	}
	
	/**
	 * Update value of variable based on Euler's method
	 */
	public void update() {
		value += derivative*clock.step();
	}

}
