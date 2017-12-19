package babysitter;

public class BabySitter {
	
	private static final int BEFORE_BEDTIME_RATE = 12;
	private static final int AFTER_BEDTIME_RATE = 8;
	private int startTime;
	private int endTime;

	public BabySitter(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	int calculatePay() {
		int hoursWorked = endTime - startTime;
		if(startTime >= 20 && endTime <= 24) {
			return AFTER_BEDTIME_RATE * hoursWorked;
		} else {
		return hoursWorked * BEFORE_BEDTIME_RATE;
	
		}
	}
}
