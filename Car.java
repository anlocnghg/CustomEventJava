/* Creating custom Source and Event-Listener pair
 * Event-Driven Programming Model
 *  
 * by Loc Nguyen
 * anlocnghg @ CodeProject
 * URL: http://www.umsl.edu/~lhn7c5/
 */


import java.util.*;

public class Car {
	private int maxSpeed = 60; // miles per hour
	private int minSpeed = 40;
	private int currentSpeed = 50;
	private ArrayList<SpeedListener> speedListenerList = new ArrayList<SpeedListener>();

	public void speedUp(int increment) {
		this.currentSpeed += increment;
		if (this.currentSpeed > this.maxSpeed) {
			// fire SpeedEvent
			processSpeedEvent(new SpeedEvent(this, this.maxSpeed, this.minSpeed, this.currentSpeed));
		}		
	}

	public void slowDown(int decrement) {
		this.currentSpeed -= decrement;
		if (this.currentSpeed < this.minSpeed) {
			// fire SpeedEvent
			processSpeedEvent(new SpeedEvent(this, this.maxSpeed, this.minSpeed, this.currentSpeed));
		}		
	}

	// Fire an event
	@SuppressWarnings("unchecked")
	private void processSpeedEvent(SpeedEvent speedEvent) {
		ArrayList<SpeedListener> tempSpeedListenerList;

		synchronized (this) {
			if (speedListenerList.size() == 0)
				return;
			tempSpeedListenerList = (ArrayList<SpeedListener>) speedListenerList.clone();
		}

		for (SpeedListener listener : tempSpeedListenerList) {
			listener.speedExceeded(speedEvent);
			listener.speedGoneBelow(speedEvent);
		}
	}

	// Register an event listener
	public synchronized void addSpeedListener(SpeedListener listener) {
		if (!speedListenerList.contains(listener)) {
			speedListenerList.add(listener);
		}
	}

	// Remove an event listener
	public synchronized void removeSpeedListener(SpeedListener listener) {
		if (speedListenerList.contains(listener)) {
			speedListenerList.remove(listener);
		}
	}

	public Car(int maxSpeed, int minSpeed, int currentSpeed) {
		super();
		this.maxSpeed = maxSpeed;
		this.minSpeed = minSpeed;
		this.currentSpeed = currentSpeed;
	}

	public Car() {

	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMinSpeed() {
		return minSpeed;
	}

	public void setMinSpeed(int minSpeed) {
		this.minSpeed = minSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

}
