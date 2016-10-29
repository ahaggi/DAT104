package controller.interview;

import static utility.UrlMappings.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EAO.EAO;
import model.Interview;
import model.Survey;
import model.answer.Answer;
import model.answer.TextAnswer;
import model.question.Question;

/**
 * Servlet implementation class InterviewStart
 */
@WebServlet("/" + INTERVIEW_START_SERVLET)
public class InterviewStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterviewStart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session.getAttribute("questionNr") == null) {
			request.setAttribute("questionNr", 0);
			Interview iv = new Interview();
			iv.setSurvey((Survey)session.getAttribute("survey"));
			request.setAttribute("interview", new Interview());
		}
		
		request.getRequestDispatcher(INTERVIEW_START_JSP).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		int questionNr = Integer.parseInt((String)session.getAttribute("questionNr"));
		Interview iv = (Interview) request.getAttribute("interview");
		
		Survey sur = (Survey) request.getAttribute("survey"); //TODO: dobbeltsjekk at attributtnavnet er korrekt
		
		Question que = sur.getQuestion(questionNr);
		
		Answer ans;
		
		if (que.getType().equals("mc")) { //TODO: mulig at vi må sjekke klasse istedet for denne metoden
			ans = que.getAnswers().get(Integer.parseInt(request.getParameter("answer"))); //TODO: sjekk at getAnswers()-funksjonen er korrekt
		} else if (que.getType().equals("txt")) { //TODO: sjekk at getType()-retur stemmer med antatt verdi
			ans = new TextAnswer();
			ans.setText(request.getParameter("answer"));
		}
		
		ans.setQuestion(que);
		ans.setInterview(iv);
		
		iv.addAnswer(ans);
		
		questionNr++;
		
		session.setAttribute("questionNr", questionNr);
		session.setAttribute("interview", iv);
		
		if (questionNr <= sur.getQuestions().size()) {
			EAO eao = new EAO();
			eao.addInterview(iv);
			response.sendRedirect(request.getContextPath() + "/" + INTERVIEW_FINISH_SERVLET);
		} else {
			response.sendRedirect(request.getContextPath() + "/" + INTERVIEW_START_SERVLET);
		}
	}
}
