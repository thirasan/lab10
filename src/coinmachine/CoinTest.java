package coinmachine;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinTest {

	@Test
	public void testEqualsObject() {
		Coin a = new Coin(5,"Bath");
		Coin b = new Coin(5,"Bath");
		assertTrue(a.equals(b));
	}

}
