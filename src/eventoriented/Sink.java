package eventoriented;

/**
 * Sink class. Consumes output.<p>
 *
 * @version 1.0, Feb 13, 2011
 * @author Ivo Vondrak
 */
public class Sink extends SourceAndSinkBase {
	/**
	 * Create transaction
	 */
	public void remove(Transaction transaction) {
		transaction = null;
		count++;
	}
	
	/**
	 * Show status
	 */
	public void show() {
		System.out.println("Number of transactions removed is: " + Integer.valueOf(count).toString());
	}
}
