package inclass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CurrencyConverterTest {
	
	private CurrencyConverter cc;
	
	@Before
	public void setup() {
		cc = new CurrencyConverter();
	}
	
	/** 0. Test at valutaveksling er korrekt */
	@Test
	public void valutevekslingErKorrekt() {
		ExchangeRateService ers = new ExchangeRateServiceStub();
		cc.setExchangeRateService(ers);
		assertEquals(800, cc.convertAmount(100, "USD", "NOK"), Double.MIN_VALUE);
	}

	/** 1.	Test at veksling fra en valuta til seg selv gir samme bel�p ut som inn */
	@Test
	public void sammeUtSomInn() {
		double someAmount = 1234;
		String someCurrCode = "NOK";
		assertEquals(someAmount, cc.convertAmount(someAmount, someCurrCode, someCurrCode), Double.MIN_VALUE);
	}

	/** 2.	Test at et bel�p p� 0 gir 0 ut n�r man veksler fra en valuta til en annen */
	@Test
	public void nullGirNull() {
		assertEquals(0, cc.convertAmount(0, "NOK", "USD"), Double.MIN_VALUE);
	}
	
	/** 3.	Ugyldig valutakode skal gi 0 som svar, ikke kaste unntak. Test at dette fungerer. */
	@Test
	public void ugydligKodeGirNull() {
		assertEquals(0, cc.convertAmount(1234, "NOK", "ABC"), Double.MIN_VALUE);
	}
}
