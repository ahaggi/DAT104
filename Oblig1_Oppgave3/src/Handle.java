

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.bval.Validate;

import com.sun.glass.ui.Pixels.Format;

/**
 * Servlet implementation class HilseServlet
 */
@WebServlet("/Handle")
public class Handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	String serverinfo;
	
	
	
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		serverinfo =  getServletContext().getServerInfo();
	}
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String valg = request.getParameter("valg");
		String tempInndata = request.getParameter("temp");
		String res="";
		
		
		if (Regnom.validate(tempInndata, valg)){
			 res=Regnom.regn(tempInndata, valg);
		}else{
			res="FeilFeilFeilFeilFeil";
		}
		
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Handle</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Tempraturen omregning resulatat</h1>");
		out.println("<h3> "+res+"</h3>");
		out.println("<p>Info om serveren: " + serverinfo + ".</p>");
		out.println("<a href=\"index.html\">En gang til</a>");
		out.println("</body>");
		out.println("</html>");
	}

	



}
