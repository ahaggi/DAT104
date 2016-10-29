package controller;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EAO.EAO;

import static controller.hjelpeKlasser.UrlMappings.*;

import controller.hjelpeKlasser.logInUtil;
import model.Lecturer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/"+LOGIN_SERVLET)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private EAO EAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		HttpSession session= request.getSession(false);
		session.removeAttribute("errorMsg");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		
		//TODO escape HTML
		Integer id = Integer.valueOf(Username);
		Lecturer l = EAO.findLecturer(id);
		HttpSession session = request.getSession(false);

		if (l != null && l.getPassword().equals(password)) {// hvis den har gyldig brukenavn og passord

			logInUtil.logInAs(request, Username , l); //username = l.getid
			session = request.getSession(false); 
 			
			response.sendRedirect(DASHBOARD_SERVLET);
			
		} else {// hvis brukenavn eller passord ikke fins i databasen
			
			//TODO sjekk at db er tilgenglig

			session.setAttribute("errorMsg", "wrong username or password ");// Eller noe fornuftige beskjed
			response.sendRedirect(LOGIN_SERVLET);
		}
	}

}
