package utility;

import org.apache.commons.lang.StringEscapeUtils;



/**
 * 
 * @author Peter
 * 
 * Class for validation logic.
 * Escape SQL Injection
 * Escape HTML injection
 * Check various parameters and constraints.
 */

public class Validator {

	/**
	 * Escapes SQL injection and HTML injection,
	 * Ensures the length of the password is within limits.
	 * 
	 * Username should be unique
	 * 
	 * 
	 * 
	 * @param the username
	 * @return the valid string useName or null
	 */
	public static String isValidUserName(String useName){
		
		escapeHTML(useName);
		escapeSQL(useName);

		stringMatcher(useName);
		stringSizeUseName(useName);

		return useName;
	}

	/**
	 * Escapes SQL injection and HTML injection,
	 * Ensures the length of the password is within limits.
	 * 
	 * @param the password
	 * @return the valid string password or null
	 */
	public static String isValidPassword(String password) {

		escapeHTML(password);
		escapeSQL(password);

		stringMatcher(password);
		stringSizePassword(password);

		return password;

	}
	
	/**
	 * Escapes SQL and HTML injection. 
	 * Ensures the input has a minimum and maximum length of data.
	 * 
	 * Doesn't give an error message if it encounters illegal input.
	 * 
	 * @param the string
	 * @return the valid string text or null
	 */
	public static String isValidInput(String text) {

		escapeHTML(text);
		escapeSQL(text);

		stringSizeText(text);

		return text;
	}
	
	
	
	/**
	 * Escapes HTML injection.
	 *
	 * Doesn't give an error message if it encounters illegal input.
	 * 
	 * @param String unsafeString
	 * @return the valid string or null
	 */
	private static String escapeHTML(String unsafeString) {
		StringEscapeUtils.escapeHtml(unsafeString);
		return unsafeString;
	}
	
	/**
	 * Escapes Sql injection.
	 *
	 * Doesn't give an error message if it encounters illegal input.
	 * 
	 * @param String unsafeString
	 * @return the valid string or null
	 */
	private static String escapeSQL(String unsafeString){
		StringEscapeUtils.escapeSql(unsafeString);
		return unsafeString;
	}
	
	
	/**
	 * Ensures the input matches the allowed characters.
	 *
	 * Doesn't give an error message if it encounters illegal input.
	 * 
	 * 
	 * @param String unsafeString
	 * @return the valid string or null
	 */
	private static String stringMatcher(String unsafeString){
		if (! unsafeString.matches("[\\b]+[å]+[ø]+[æ]")  ) {
			   unsafeString = null;
			}
		return unsafeString;
		
	}
	
	
	/**
	 * Ensures the input data for text fields are of a minimum and maximum size.
	 *
	 * Doesn't give an error message if it encounters illegal input.
	 * 
	 * 
	 * @param String unsafeString
	 * @return the valid string or null
	 */
	private static String stringSizeText(String unsafeString){
		if (!unsafeString.matches(".{1,250}")) {
			unsafeString = null;
		}
		return unsafeString;
	}
	
	/**
	 * Ensures the input data for Username is of a minimum and maximum size.
	 *
	 * Doesn't give an error message if it encounters illegal input.
	 * 
	 * 
	 * @param String unsafeString
	 * @return the valid string or null
	 */
	private static String stringSizeUseName(String unsafeString){
		if (!unsafeString.matches(".{4,20}")) {
			unsafeString = null;
		}
		return unsafeString;
	}
	
	/**
	 * Ensures the input data for password is of a minimum and maximum size.
	 *
	 * ONLY USE ON USER INPUT!!
	 * 
	 * Doesn't give an error message if it encounters illegal input.
	 * 
	 * @param String unsafeString
	 * @return the valid string or null
	 */
	private static String stringSizePassword(String unsafeString){
		if (!unsafeString.matches(".{8,20}")) {
			unsafeString = null;
		}
		return unsafeString;
	}

	/**
	 * parse a string value to an integer or return -1
	 * @param x input as string
	 * @return The value of x, or -1
	 */
	public static int toInt(String x){
		int num;
		try {
			num= Integer.valueOf(x);
		} catch (Exception e) {
			num=-1;
 		}
		return num;
		
	}

	// TODO flere metoder i Validator?
	
}
