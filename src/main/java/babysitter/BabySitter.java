package babysitter;

public class BabySitter {

	private static final int BEFORE_BEDTIME_RATE = 12;
	private static final int BETWEEN_BEDTIME_AND_MIDNIGHT_RATE = 8;
	private static final int AFTER_MIDNIGHT_RATE = 16;

	private int startTime;
	private int endTime;
	private int bedTime;

	public BabySitter(int startTime, int endTime, int bedTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.bedTime = bedTime;
	}

	boolean isValidWorkHours(int startTime, int endTime) {
		if (startTime >= 17 && endTime <= 28) {
			return true;
		}
		return false;
	}
	
	int convertAm(int am) {
		if(am > 0 && am <= 4) {
			am += 24; 
		}
		return am;
	}

	int calculatePay() {
		return hoursBeforeBedtime() * BEFORE_BEDTIME_RATE
				+ hoursBetweenBedtimeAndMidnight() * BETWEEN_BEDTIME_AND_MIDNIGHT_RATE
				+ hoursAfterMidnight() * AFTER_MIDNIGHT_RATE;
	}
	

	int hoursBeforeBedtime() {
		if (endTime < bedTime) {
			return endTime - startTime;
		}
		return bedTime - startTime;
	}

	int hoursBetweenBedtimeAndMidnight() {
		if (endTime < bedTime) {
			return 0;
		} else if (endTime < 24) {
			return endTime - bedTime;
		} else {
			return 24 - bedTime;
		}
	}

	int hoursAfterMidnight() {
		if (endTime < 24) {
			return 0;
		} else {
			return endTime - 24;
		}
	}
}
