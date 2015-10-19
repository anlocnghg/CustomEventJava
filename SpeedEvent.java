/* Creating custom Source and Event-Listener pair
 * Event-Driven Programming Model
 *  
 * by Loc Nguyen
 * anlocnghg @ CodeProject
 * URL: http://www.umsl.edu/~lhn7c5/
 */

@SuppressWarnings("serial")
public class SpeedEvent extends java.util.EventObject {
	private int maxSpeed;
	private int minSpeed;
	private int currentSpeed;

	public SpeedEvent(Object source, int maxSpeed, int minSpeed, int currentSpeed) {
		super(source);
		this.maxSpeed = maxSpeed;
		this.minSpeed = minSpeed;
		this.currentSpeed = currentSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getMinSpeed() {
		return minSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

}
