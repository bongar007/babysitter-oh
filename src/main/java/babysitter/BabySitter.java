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
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){ 
		
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
			
			
			BabySitter pay = new BabySitter(start, end, bedtime);
			
			if(pay.isValidWorkHours(start, end) == true) {
				System.out.println("Your payment for the night is: " + "$" + pay.calculatePay());
			} else {
			System.out.println("Sorry, can't work those hours. Business hours from 5PM - 4AM");
			}
		}
	}	
}
