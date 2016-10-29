package controller.dashboard;
import static utility.UrlMappings.DASHBOARD_JSP;
import static utility.UrlMappings.LOGIN_JSP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EAO.EAO;
import controller.hjelpeKlasser.logInUtil;
import model.Lecturer;
import model.LecturerADT;
import model.Survey;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
			HttpSession session = request.getSession();
			String SurveyID = request.getParameter("SurveyId");
			int surveyId = Integer.parseInt(SurveyID);
			EAO temp = new EAO();
			String surveyName = temp.findSurvey(surveyId).getName();
			temp.deleteSurvey(surveyId);
			session.setAttribute("SurveyDelete", surveyName+" Deleted");
			response.sendRedirect(DASHBOARD_JSP);
		}
		else{
			response.sendRedirect(LOGIN_JSP);
		}
	}

}
