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
 	public void shouldReturnZeroIfStartimeIsBefore5Pm() {
 		BabySitter sitter = new BabySitter(14, 18, 20);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("Cannot start before 5Pm", 0, pay);
 		
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
	
	
	// Testing cross calculations between methods ////////////////////////
	
	@Test
 	public void shouldPayFor11HoursOfWork() {
 		BabySitter sitter = new BabySitter(17, 4, 20);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $132", 132, pay);
	}
	
	@Test
 	public void shouldAddOneHourBeforeBedtimeAndAfter() {
 		BabySitter sitter = new BabySitter(17, 19, 18);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $20", 20, pay);
	}
	
	@Test
 	public void shouldReturnTwoHoursOfPayBetween11And1() {
 		BabySitter sitter = new BabySitter(23, 1, 24);
 		int pay = sitter.calculatePay();
 		Assert.assertEquals("I am expected to get $28", 28, pay);
	}
	
	//////////////////////////////////////////////////////////////////
	
	@Test
	public void should4PmBeNotaValidStartTime() {
		BabySitter sitter = new BabySitter(16, 29, 20);
		boolean notValid = sitter.isValidWorkHours(16, 18);
		Assert.assertEquals("Cannot start at 4 PM" , false, notValid);
	}
	
	@Test
	public void should6PmBeAValidStartTime() {
		BabySitter sitter = new BabySitter(17, 28, 20);
		boolean valid = sitter.isValidWorkHours(17, 28);
		Assert.assertEquals("Ok to work between 5Pm and 4Am" , true, valid);
	}
	
	@Test
	public void hoursBetween4PmAnd5AmShouldBeInvalid() {
		BabySitter sitter = new BabySitter(16, 29, 20);
		boolean notValid = sitter.isValidWorkHours(16, 29);
		Assert.assertEquals("Hours outside of business hours are not valid", false, notValid);		
	}
	
	/////////////// Converter tests /////////////////////
	
	@Test
	public void amConverterShouldReturn26 () {
		BabySitter sitter = new BabySitter(17, 18, 20);
		int converted = sitter.convertAm(2);
		Assert.assertEquals(26, converted);
	}
	
	@Test
	public void amConverterShouldReturn5 () {
		BabySitter sitter = new BabySitter(17, 18, 20);
		int converted = sitter.convertAm(5);
		Assert.assertEquals(5, converted);
	}
	
	@Test
	public void amConverterShouldReturn24 () {
		BabySitter sitter = new BabySitter(17, 24, 20);
		int converted = sitter.convertAm(24);
		Assert.assertEquals(24, converted);
	}
	
	////////////// invalid User Entry check //////////
	
//	@Test
//	public void invalidUserEntryMethodShouldReturnTrue () {
//		BabySitter sitter = new BabySitter(5, 11, 8);
//		boolean invalid = sitter.invalidUserEntry(5, 11, 8);
//		Assert.assertEquals(true, invalid);
//	}
}
