package controller.dashboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static controller.hjelpeKlasser.UrlMappings.*;
/**
 * Servlet implementation class CreateSurvey
 */
@WebServlet("/"+CREATE_SURVEY_SERVLET)
public class CreateSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(CREATE_SURVEY_JSP).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String navn = request.getParameter("navn");
		String description = request.getParameter("description");
		String repeatable = request.getParameter("repeatable");
		String traversable = request.getParameter("traversable");

		
		response.sendRedirect(CREATE_SURVEY_SERVLET);
 
	}

}
