/**
 * Source class. Generates input transactions.<p>
 *
 * @version 1.0, Feb 13, 2011
 * @author Ivo Vondrak
 */
public class Source extends SourceAndSinkBase {
	/**
	 * Create transaction
	 */
	public Transaction create(Clock clock) {
		Transaction thisOne;
		count++;
		thisOne = new Transaction(clock);
		thisOne.nextInLine(null);
		return thisOne;
	}
	
	/**
	 * Show status
	 */
	public void show() {
		System.out.println("Number of transactions created is: "+new Integer(count).toString());
	}
}
