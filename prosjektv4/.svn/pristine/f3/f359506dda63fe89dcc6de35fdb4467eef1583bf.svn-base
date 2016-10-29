package utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import EAO.EAO;
import model.Lecturer;

/**
 * Authenticator klasse for å snakke sjekke med databasen. Klasen håndterer
 * login logut og om lecturer er innlogget
 *
 */
public class Authenticator {

	/**
	 * Loggin a user if the provided details are corret
	 * 
	 * @param The
	 *            HttpServletRequest
	 * @param Username
	 *            as String
	 * @param Password
	 *            as string
	 * 
	 * @returns boolean if the user has been logged in or not.
	 */
	public boolean login(HttpServletRequest request, String username, String password) {
		Validator val = new Validator();
		EAO eao = new EAO();
		PassordUtil pUtil = new PassordUtil(); 
		String name;
		String pass;
		Lecturer l;

		// Prevent HTML and SQL injection attacks
		// Valider Brukernavn og passord
		name = val.isValidUserName(username);
		pass = val.isValidPassword(password);
		
		// name eller pas må ikke være null
		if (name != null || pass != null) {
			// Strings should be safe.
			l = eao.findLecturer(name);

			// Sjekk om brukeren eksisterer i db -> l er et objekt
			if (l != null) {
				// Sjekk om passord er riktig
				// hash passordet
				
				// samenlign med lagrede hashen
				if (pUtil.sjekkPassord(pass, l.getPassword())){
					// user name and password ok.
						// Logg in
					logout(request);
					HttpSession sesjon = request.getSession(true);
					sesjon.setAttribute("userName", name); 
					sesjon.setAttribute("lecturer", l); 
					// loget in ok
					return true;
				}
			}
		}
		//noe gikkk galt
		return false;
	}

	/**
	 * Logs out a user
	 * 
	 */
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	/**
	 * Checks if the user is logged inn and authenticated
	 * @param request
	 * @return boolean: if the user is logged in or not
	 */
	public boolean isAuthenticated(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("userName") != null) && (session.getAttribute("lecturer") != null) ;
	}
}
