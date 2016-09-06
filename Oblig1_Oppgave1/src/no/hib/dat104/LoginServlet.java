package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/register")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
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
