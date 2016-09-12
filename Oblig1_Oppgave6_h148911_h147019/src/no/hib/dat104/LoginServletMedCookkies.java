package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServletMedCookkies
 */
@WebServlet("/")
public class LoginServletMedCookkies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String fornavn="";
        String etternavn="";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                    fornavn = cookie.getName();
                    etternavn = cookie.getValue();
            }
        }

		response.setContentType("text/html; charset=ISO-8859-1");

		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>LogginMedCookie</title>");
		
		out.println("</head>");
		out.println("<body>");
		
		out.println("<form name=\"form\"  action=\"\"  method=\"post\" >");
		out.println("<fieldset>");
		
		out.println("<legend>LogginMedCookie</legend>");
		
		out.println("<p>Fornavn: <input type=\"text\" name=\"fornavn\" value=\"" + fornavn+ "\" required/></p>");
		out.println("<p>Etternavn: <input type=\"text\" name=\"etternavn\" value=\"" + etternavn+ "\" required/></p>");
		out.println("<p><input type=\"submit\" value=\"Send data\"  /></p>");
	  
		out.println("</fieldset>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");

	
	
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fornavn = escapeHtml(request.getParameter("fornavn"));
		String etternavn = escapeHtml(request.getParameter("etternavn"));

	        Cookie nycookie = new Cookie(fornavn, etternavn);
	        nycookie.setMaxAge(60 * 60 * 24 * 365);
	        response.addCookie(nycookie);

		response.sendRedirect("");

	
	
	}
	private String escapeHtml(String str) {
		str = str.replaceAll("<",""); 
		str = str.replaceAll(" ",""); 
		str = str.replaceAll(">","");
		str = str.replaceAll("'","");
		str = str.replaceAll("\"","");
		str = str.replaceAll("=","");
		str = str.replaceAll("/","");
		str = str.replaceAll("å","&#229");
		str = str.replaceAll("Å","&#197");
		str = str.replaceAll("ø","&#248");
		str = str.replaceAll("Ø","&#216");
		str = str.replaceAll("æ","&#230");
		str = str.replaceAll("Æ","&#198");
		   
		   
		   
  		return str;
	}

}
