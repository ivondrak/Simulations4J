/**
 * Discrete class. Generator of dicrete uniform distribution.<p>
 *
 * @version 1.0, Feb 10, 2011
 * @author Ivo Vondrak
 */
public class Discrete extends Generator{
	/**
	 * Interval values
	 */
	int low, high;
	
	/**
	 * Constructor
	 */
	public Discrete(int low, int high) {
		this.low = low;
		this.high = high;
	}
	
	/**
	 * Generate uniform discrete values
	 */
	public double generate() {
		int temp = (int) ((high-low+1)*super.generate()+low);
		return (double) temp;
	}

}
