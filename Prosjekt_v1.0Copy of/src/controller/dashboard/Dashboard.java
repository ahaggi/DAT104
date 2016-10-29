package controller.dashboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.hjelpeKlasser.logInUtil;
import model.Lecturer;

import static controller.hjelpeKlasser.UrlMappings.*;
/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/"+DASHBOARD_SERVLET)
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (logInUtil.isLoggedIn(request)) {
			Lecturer lecturer= (Lecturer) request.getSession().getAttribute("lecturer");
			response.sendRedirect(DASHBOARD_SERVLET);
			
			
		}

	}

}
