/**
 * Discrete class. Generator of uniform distribution.<p>
 *
 * @version 1.0, Feb 10, 2011
 * @author Ivo Vondrak
 */
public class Uniform extends Generator{
	/**
	 * Interval values
	 */
	double low, high;
	
	/**
	 * Constructor
	 */
	public Uniform(double low, double high) {
		this.low = low;
		this.high = high;
	}
	
	/**
	 * Generate uniformly distributed values
	 */
	public double generate() {
		return (high-low+1)*super.generate()+low;
	}

}
