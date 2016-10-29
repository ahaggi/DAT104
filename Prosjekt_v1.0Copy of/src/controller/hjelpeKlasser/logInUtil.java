package controller.hjelpeKlasser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Lecturer;

public class logInUtil {
	

	public static void logInAs(HttpServletRequest request, String userName, Lecturer l) {

		logout(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setAttribute("userName", userName); 
		sesjon.setAttribute("lecturer", l); 
	}


	public static boolean isLoggedIn(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("userName") != null) && (session.getAttribute("lecturer") != null) ;
	}


	public static void logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}


}
