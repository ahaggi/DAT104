package controller.interview;

 
import java.io.IOException;

import javax.ejb.EJB;
 import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EAO.EAO;
import model.*;
import utility.*;
import static utility.UrlMappings.*;

 /**
 * Servlet implementation class InterviewHome
 */
@WebServlet("/"+INTERVIEW_HOME_SERVLET)
public class InterviewHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	@EJB
	private EAO EAO;
	
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_parameter = request.getParameter("surveyId");
		int id = Validator.toInt(id_parameter); // OBS kan retunere id =-1 hvis id_parameter er ikke en tall
		Survey survey= EAO.findSurvey(id);
		HttpSession session = request.getSession(true);
		
		if (survey!=null) {
			session.setAttribute("survey", survey);
			request.getRequestDispatcher(INTERVIEW_HOME_JSP).forward(request, response);
		}else{
			session.setAttribute("errorMsg", "some thig went wrong,,,"); //TODO skulle gitt en spesifisert beskjed om hva som er feil... er det fristen gikk ut eller survey==null
																		//			response.sendRedirect(EXCEP_SERVLET);
			request.getRequestDispatcher(INTERVIEW_HOME_JSP).forward(request, response);
			session.removeAttribute("errorMsg");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);			
 		Survey survey=(Survey) session.getAttribute("survey");
				
		if (survey!=null && survey.isValidToStart()) {
			
			response.sendRedirect(INTERVIEW_START_SERVLET);
			
		} else {
			response.sendRedirect(INTERVIEW_HOME_SERVLET );

		}
		
		
		
		
		
		
		
 	}

}
