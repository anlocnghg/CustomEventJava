/* Creating custom Source and Event-Listener pair
 * Event-Driven Programming Model
 *  
 * by Loc Nguyen
 * anlocnghg @ CodeProject
 * URL: http://www.umsl.edu/~lhn7c5/
 */


public interface SpeedListener extends java.util.EventListener {
	public void speedExceeded(SpeedEvent e);

	public void speedGoneBelow(SpeedEvent e);
}
