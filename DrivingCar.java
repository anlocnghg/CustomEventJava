/* Creating custom Source and Event-Listener pair
 * Event-Driven Programming Model
 *  
 * by Loc Nguyen
 * anlocnghg @ CodeProject
 * URL: http://www.umsl.edu/~lhn7c5/
 */

public class DrivingCar {
	public static void main(String[] args) {
		Car myCar = new Car(60, 40, 50);

		SpeedListener listener = new MySpeedListener();
		myCar.addSpeedListener(listener);
		// Add more listeners if you want

		/*// Anonymous inner class
		myCar.addSpeedListener(new SpeedListener() {

			@Override
			public void speedExceeded(SpeedEvent e) {
				// Code
			}

			@Override
			public void speedGoneBelow(SpeedEvent e) {
				// Code
			}
		});*/

		myCar.speedUp(50);
		myCar.speedUp(50);
		myCar.slowDown(70);
		myCar.slowDown(70);
	}

	// Inner class
	private static class MySpeedListener implements SpeedListener {
		@Override
		public void speedExceeded(SpeedEvent e) {
			if (e.getCurrentSpeed() > e.getMaxSpeed()) {
				System.out.println("Alert! You have exceeded " + (e.getCurrentSpeed() - e.getMaxSpeed() + " MPH!"));
			}
		}

		@Override
		public void speedGoneBelow(SpeedEvent e) {
			if (e.getCurrentSpeed() < e.getMinSpeed()) {
				System.out.println("Uhm... you are driving " + e.getCurrentSpeed() + " MPH. Speed up!");
			}
		}
	}
}
