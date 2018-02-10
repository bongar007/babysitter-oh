package babysitter;

import java.util.Scanner;
import java.util.stream.IntStream;

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

	boolean isValidWorkHours() {
		return (startTime >= 17 && startTime < 28) && (endTime <= 28 && endTime > 17);
	}

	boolean isValidUserEntry() {
		final int[] invalids = IntStream.rangeClosed(5, 16).toArray();
		
		boolean startBeforeEnd = startTime < endTime;
		boolean startDuringValidHour = IntStream.of(invalids).noneMatch(x -> x == startTime);
		boolean endDuringValidHour = IntStream.of(invalids).noneMatch(x -> x == endTime);
		boolean bedTimeDuringValidHour = IntStream.of(invalids).noneMatch(x -> x == bedTime);
		
		return startBeforeEnd && startDuringValidHour && endDuringValidHour && bedTimeDuringValidHour;
	}

	int convertAm(int am) {
		return (am <= 4) ? am + 24 : am;
	}

	int calculatePay() {
		int result = 0;
		
		if (!isValidWorkHours()) {
			return 0;
		}
		
		for (int i = startTime; i < endTime; i++) {
			if (i < bedTime && i < 24) {
				result += BEFORE_BEDTIME_RATE;
			} else if (i >= bedTime && i < 24) {
				result += BETWEEN_BEDTIME_AND_MIDNIGHT_RATE;
			} else {
				result += AFTER_MIDNIGHT_RATE;
			}
		}
		
		return result;
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

			if ((pay.isValidWorkHours()) && pay.isValidUserEntry()) {
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
