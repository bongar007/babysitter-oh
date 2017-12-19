package babysitter;

import org.junit.Assert;
import org.junit.Test;

public class BabySitterTest {
	
	@Test
	 	public void shouldPayForOneHourBeforeBedtime() {
	 		BabySitter sitter = new BabySitter(17, 18, 20);
	 		int pay = sitter.calculatePay();
	 		Assert.assertEquals("I am expected to get $12", 12, pay);
	 		
	 	}
	
	@Test
 	public void shouldPayForTwoHoursBeforeBedtime() {
 		BabySitter sitter = new BabySitter(17, 19, 20);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $24", 24, pay);
 		
 	}
	
	@Test
 	public void shouldPayForOneHourAfterBedtime() {
 		BabySitter sitter = new BabySitter(20, 21, 20);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $8", 8, pay);
 		
 	}
	
	@Test
 	public void shouldPayForTwoHoursAfterBedtime() {
 		BabySitter sitter = new BabySitter(20, 22, 20);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $16", 16, pay);
 		
 	}
	
	@Test
 	public void shouldPayForOneHourAfterMidnight() {
 		BabySitter sitter = new BabySitter(25, 26, 20);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $16", 16, pay);
 		
 	}
	
	@Test
 	public void shouldPayForTwoHoursAfterMidnight() {
 		BabySitter sitter = new BabySitter(26, 28, 20);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $32", 32, pay);
	}
	
	@Test
	public void should4PmBeNotaValidStartTime() {
		BabySitter sitter = new BabySitter(16, 29, 20);
		boolean notValid = sitter.isValidWorkHours(16);
		Assert.assertEquals("Cannot start at 4 PM" , false, notValid);
	}
	
	@Test
	public void should6PmBeAValidStartTime() {
		BabySitter sitter = new BabySitter(17, 28, 20);
		boolean valid = sitter.isValidWorkHours(17);
		Assert.assertEquals("Ok to work between 5Pm and 4Am" , true, valid);
	}
	
	@Test
	public void hoursAfterMidnightMethodShouldReturnOne () {
		BabySitter sitter = new BabySitter(24, 25, 20);
		int hour = sitter.hoursAfterMidnight();
		Assert.assertEquals(1, hour);
	}
	
	@Test
	public void hoursBetweenBedtimeAndMidnightMethodShouldReturnOne () {
		BabySitter sitter = new BabySitter(20, 21, 20);
		int hour = sitter.hoursBetweenBedtimeAndMidnight();
		Assert.assertEquals(1, hour);
	}
	
	@Test
	public void hoursBeforeBedtimeShouldReturnOne () {
		BabySitter sitter = new BabySitter(17, 18, 20);
		int hour = sitter.hoursBeforeBedtime();
		Assert.assertEquals(1, hour);
	}
}
