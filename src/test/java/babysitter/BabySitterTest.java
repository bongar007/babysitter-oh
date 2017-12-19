package babysitter;

import org.junit.Assert;
import org.junit.Test;

public class BabySitterTest {
	
	@Test
	 	public void shouldPayForOneHourBeforeBedtime() {
	 		BabySitter sitter = new BabySitter(16, 17);
	 		int pay = sitter.calculatePay();
	 		Assert.assertEquals("I am expected to get $12", 12, pay);
	 		
	 	}
}
