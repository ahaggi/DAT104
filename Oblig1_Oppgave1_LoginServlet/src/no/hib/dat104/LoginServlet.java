package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fornavn = escapeHtml(request.getParameter("fornavn"));
        String etternavn = escapeHtml(request.getParameter("etternavn"));
        
        
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Hallo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Loggin result</h1> <br>");

        out.println("<h3>Logged in form "+request.getRequestURL()+"</h3> <br>");
        out.println("<p>Username " + fornavn  +"</p> <br>");
        out.println("<p>Username " + etternavn  +"</p>");
        out.println("</body>");
        out.println("</html>");
        
    }
	private String escapeHtml(String str) {
		str = str.replaceAll("<","&lt;"); 
		str = str.replaceAll(">","&gt;");
		str = str.replaceAll("'","&#39;");
		str = str.replaceAll("\"","&#34;");
		str = str.replaceAll("=","&#61;");
		str = str.replaceAll("/","&#47;");
  		return str;
	}

}
