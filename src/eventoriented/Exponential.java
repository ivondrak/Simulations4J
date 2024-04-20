package eventoriented;

/**
 * Discrete class. Generator of exponential distribution.<p>
 *
 * @version 1.0, Feb 10, 2011
 * @author Ivo Vondrak
 */
public class Exponential extends Generator{
	/**
	 * Lambda value
	 */
	double lambda;
	
	/**
	 * Constructor
	 */
	public Exponential(double lambda) {
		this.lambda = lambda;
	}
	
	/**
	 * Generate expontially distributed values
	 */
	public double generate() {
		return -Math.log(super.generate())/lambda;
	}

}
