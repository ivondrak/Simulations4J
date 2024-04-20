package eventoriented;
/**
 * Binary class. Generator of binary distribution.<p>
 *
 * @version 1.0, Feb 10, 2011
 * @author Ivo Vondrak
 */
public class Binary extends Generator {
	/**
	 * Percentage of true values
	 */
	double percentTrue;
	
	/**
	 * Constructor
	 */
	public Binary(double percentTrue) {
		this.percentTrue = percentTrue;
	}
	
	/**
	 * Generate binary value
	 */
	public double generate() {
		if (super.generate()<=percentTrue)
			return 1;
		else
			return 0;
	}
}
