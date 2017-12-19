package babysitter;

public class BabySitter {
	
	private static final int BEFORE_BEDTIME_RATE = 12;
	private int startTime;
	private int endTime;

	public BabySitter(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	int calculatePay() {
		int hoursWorked = endTime - startTime;
		return hoursWorked * BEFORE_BEDTIME_RATE;
	}
	
	
	
}
