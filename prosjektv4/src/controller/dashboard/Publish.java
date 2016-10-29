package controller.dashboard;

import static utility.UrlMappings.LOGIN_JSP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EAO.EAO;
import controller.hjelpeKlasser.logInUtil;

/**
 * Servlet implementation class Publish
 */
@WebServlet("/Publish")
public class Publish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Publish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(logInUtil.isLoggedIn(request)){
			
		}
		else{
			response.sendRedirect(LOGIN_JSP);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(logInUtil.isLoggedIn(request)){
		int surveyID = Integer.parseInt((String) request.getAttribute("surveyId"));
		EAO lol = new EAO();
//		lol.findSurvey(surveyID).setPublished(true);
		}
		else{
			response.sendRedirect(LOGIN_JSP);
		}
		
	}

}
