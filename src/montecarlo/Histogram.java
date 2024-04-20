package montecarlo;

/**
 * Histogram class. Displays a histogram.<p>
 *
 * @version 1.0, Feb 10, 2011
 * @author Ivo Vondrak
 */
public class Histogram {
	/**
	 * Histogram parameters
	 */
	int noOfClasses, noOfObservations;
	double classWidth, low, high;
	int[] counters = new int[50];
	int overflow, underflow;
	
	
	/**
	 * Constructor
	 */
	public Histogram(double low, double high, int noOfClasses) {
		this.low = low;
		this.high = high;
		this.noOfClasses = (noOfClasses <= 50 ? noOfClasses : 50);
		this.noOfObservations = 0;
		this.classWidth = (high-low)/(double) this.noOfClasses;
		for (int i=0; i < this.noOfClasses; i++) {
			this.counters[i] = 0;
			this.overflow = 0;
			this.underflow = 0;
		}
		
	}
	
	/**
	 * Update histogram
	 */
	public void update(double observation) {
		int histClass;
		if (observation < low)
			underflow++;
		else
			if (observation > high)
				overflow++;
			else {
				histClass = (int) ((observation - low)/classWidth);
				if (histClass > noOfClasses)
					histClass = noOfClasses;
				counters[histClass]++;
			}
		noOfObservations++;
	}
	
	/**
	 * Show histogram
	 */
	public void show() {
		int lineLength = 50;
		int barWidth = 3;
		char space = ' ';
		char symbol = '*';
		
		int maxCount = counters[0];
		for (int i = 1; i < noOfClasses; i++)
			if (counters[i] > maxCount)
				maxCount = counters[i];
		System.out.println("Overflow was "+overflow);
		System.out.println("Underflow was "+underflow);
		// measure
		float stars = (float) lineLength/(float) maxCount;
		//first class
		float classLabel = Math.round(low*100f)/100f;
		String label = Float.toString(classLabel);
		for (int i=0; i < (10-label.length()); i++)
			System.out.print(space);
		System.out.println(label+"I");
		//print columns
		for (int i=0; i < noOfClasses; i++) {
			float percentage = Math.round(((float) counters[i]/(float) noOfObservations)*100f)/100f;
			String percentageLabel = Float.valueOf(percentage*100).toString()+"%";
			for (int barLines = 0; barLines < barWidth; barLines++) {
				for (int s=0; s < 10; s++)
					System.out.print(space);
				System.out.print("I ");
				for (int barStars=0; barStars < (int) (stars*counters[i]+0.5); barStars++)
					System.out.print(symbol);
				if (barLines == 1) {
					System.out.print(space);
					System.out.print(percentageLabel);
				}
				System.out.println();
			}
			classLabel += classWidth;
			classLabel = Math.round(classLabel*100f)/100f;
			label = Float.toString(classLabel);
			for (int s=0; s < (10-label.length()); s++)
				System.out.print(space);
			System.out.println(label+"I");
		}		
	}

}
