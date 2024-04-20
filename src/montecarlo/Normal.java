package montecarlo;

/**
 * Normal class. Generator of normal distribution.<p>
 *
 * @version 1.0, Feb 10, 2011
 * @author Ivo Vondrak
 */
public class Normal extends Generator{
	/**
	 * Parameter values
	 */
	double mean, sigma;
	
	/**
	 * Constructor
	 */
	public Normal(double mean, double sigma) {
		this.mean = mean;
		this.sigma = sigma;
	}
	
	/**
	 * Generate normally distributed values
	 */
	public double generate() {
		double temp, firstRND, secondRND;
		do {
			firstRND = -Math.log(super.generate());
			secondRND = -Math.log(super.generate());
		}
		while (2.0*firstRND < Math.pow(secondRND-1, 2.0));
		if (super.generate() < 0.5)
			secondRND = -secondRND;
		temp = sigma*secondRND+mean;
		return temp;
	}

}
