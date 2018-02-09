package babysitter;

import java.util.Scanner;

public class BabySitter {

	private static final int BEFORE_BEDTIME_RATE = 12;
	private static final int BETWEEN_BEDTIME_AND_MIDNIGHT_RATE = 8;
	private static final int AFTER_MIDNIGHT_RATE = 16;

	private int startTime;
	private int endTime;
	private int bedTime;

	public BabySitter(int startTime, int endTime, int bedTime) {
		this.startTime = convertAm(startTime);
		this.endTime = convertAm(endTime);
		this.bedTime = convertAm(bedTime);
	}

	int convertAm(int am) {
		return am >= 4 ? am + 24 : am;
	}

	boolean isValidWorkHours(int starTime, int endTime) {
		if ((startTime >= 17 && startTime < 28)
				&& (endTime <= 28 && endTime > 17)) {
			return true;
		}
		return false;
	}

	// boolean invalidUserEntry(int startTime, int endTime, int bedTime) {
	// boolean invalidTracker = false;
	// int[] invalids = new int[] { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
	// try (Scanner sc = new Scanner(System.in)) {
	// for (int i = 0; i < invalids.length; i++) {
	// if (invalids[i] == sc.nextInt()) {
	// invalidTracker = true;
	// }
	// invalidTracker = false;
	// }
	// }
	// return invalidTracker;
	//
	// }

	int hoursBeforeBedtime() {
		if (startTime >= 17 && endTime <= bedTime) {
			return endTime - startTime;
		} else {
			return 0;
		}
	}

	int hoursBetweenBedtimeAndMidnight() {
		if (startTime <= bedTime && endTime > bedTime && endTime <= 24) {
			return endTime - bedTime;
		} else
			return 0;
	}
	
//	int hoursBetweenBedtimeAndMidnight() {
//		if((startTime <= bedTime && endTime >= 24)&&(startTime <= bedTime && endTime <= 24)) {
//			return 24 - bedTime;
//		} else if (startTime > bedTime && endTime < 24) {
//			return endTime - startTime;
//		} else if(endTime < 24 && startTime < bedTime) {
//			return endTime - bedTime;
//		} else if(startTime > bedTime && endTime > 24) {
//			return 24 - startTime;
//		}
//			return 0;
//	}

	int hoursAfterMidnight() {
		if (startTime >= 24 && endTime > 24) {
			return endTime - startTime;
		} else if (endTime > 24) {
			return endTime - 24;
		} else {
			return 0;
		}

	}

	public int calculatePay() {
		return hoursBeforeBedtime() * BEFORE_BEDTIME_RATE
				+ hoursBetweenBedtimeAndMidnight() * BETWEEN_BEDTIME_AND_MIDNIGHT_RATE
				+ hoursAfterMidnight() * AFTER_MIDNIGHT_RATE;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Hello, I am your baby sitter for tonight!");
			System.out.println();
			System.out.println("My hours are between 5PM and 4AM");
			System.out.println();
			System.out.println("From 5Pm until your desired bedtime, I charge $12/hr");
			System.out.println("From bedtime until 12Am, it's $8/hr");
			System.out.println("And midnight until 4Am, it's $16/hr");
			System.out.println();

			System.out.println("Please enter the start time (In 24 hour format please):");
			int start = sc.nextInt();
			System.out.println();
			System.out.println("Please enter the end time (In 24 hour format please):");
			int end = sc.nextInt();
			System.out.println();
			System.out.println("Please add the desired bedtime(In 24 hour format please):");
			int bedtime = sc.nextInt();
			System.out.println("Thank you!");
			System.out.println();

			BabySitter pay = new BabySitter(start, end, bedtime);

			if (pay.isValidWorkHours(start, end) == true) {
				System.out.println("Your payment for the night is: " + "$" + pay.calculatePay());
			} else {
				System.out.println(
						"Sorry, either you have entered invalid format or I can't work those hours. Business hours from 5PM - 4AM");
				System.out.println();
				System.out.println(
						"*********************************************************************************************");
				System.out.println();
				System.out.println("Try again:");
				System.out.println();
				main(args);
			}
		}
	}
}
