package somepackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/") Dette g�r ikke hvis vi har web.xml !!!
@WebServlet(name = "Min magiske Servlet", urlPatterns = "/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String greetingForThisServletOnly;
	String greetingForTheEntireApplication;

	@Override
	public void init() throws ServletException {
		
		greetingForThisServletOnly = getServletConfig().getInitParameter("greeting");
		greetingForTheEntireApplication = getServletContext().getInitParameter("greeting");
//		getServletContext().setInitParameter("Kasserer_Passord", "admin");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		
		out.println(greetingForThisServletOnly);
		out.println(greetingForTheEntireApplication);
	}

}
