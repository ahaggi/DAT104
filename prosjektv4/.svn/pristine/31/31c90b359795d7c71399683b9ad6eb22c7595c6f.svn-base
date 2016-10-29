/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.Validator;

/**
 * @author Hawkon
 *
 */
public class ValidatorTest {

	private Validator va;
	private String trueUN;
	private String truePW;
	private String falseUN;
	private String falsePW;
	private String trueInput;
	private String falseInput;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		va = new Validator();
		trueUN = "Håkon";
		truePW = "dennorskebank123";
		trueInput = "Hei, dette er en prøve. Dette er alternativene:";
		falseUN = "123";
		falsePW = "hal1";
		falseInput = "";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		va = null;
		trueUN = null;
		truePW = null;
		trueInput = null;
		falseUN = null;
		falsePW = null;
		falseInput = null;
	}

	@Test
	public void testIsValidUsername() {
		assertTrue(va.isValidUserName(trueUN).compareTo(trueUN) == 0);
	}

	@Test
	public void testIsInvalidUsername() {
		assertFalse(va.isValidUserName(falseUN).compareTo(falseUN) == 0);
	}

	@Test
	public void testIsValidPassword() {
		assertTrue(va.isValidPassword(truePW).compareTo(truePW) == 0);
	}

	@Test
	public void testIsInvalidPassword() {
		assertFalse(va.isValidPassword(falsePW).compareTo(falsePW) == 0);
	}

	@Test
	public void testIsValidInput() {
		assertTrue(va.isValidInput(trueInput).compareTo(trueInput) == 0);
	}

	@Test
	public void testIsInvalidInput() {
		assertFalse(va.isValidInput(falseInput).compareTo(falseInput) == 0);
	}

}
