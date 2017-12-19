package babysitter;

public class BabySitter {
	
	private static final int BEFORE_BEDTIME_RATE = 12;
	private static final int BETWEEN_BEDTIME_AND_MIDNIGHT_RATE = 8;
	private static final int AFTER_MIDNIGHT_RATE = 16;
	private static final int BEDTIME = 20;

	private int startTime;
	private int endTime;

	public BabySitter(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	boolean isValidWorkHours(int num) {
		if(startTime >= 17 && endTime <= 28) {
			return true;
		}
		return false;
	}

	int calculatePay() {
		int hoursWorked = endTime - startTime;
		if(startTime >= 17 && endTime <= BEDTIME) {
			return BEFORE_BEDTIME_RATE * hoursWorked;
		} else if(startTime >= BEDTIME && endTime <= 24) {
			return hoursWorked * BETWEEN_BEDTIME_AND_MIDNIGHT_RATE;
		} else {
			return hoursWorked * AFTER_MIDNIGHT_RATE;
		}
	}
}
