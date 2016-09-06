package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Servlet implementation class Favorittfrukt
 */
@WebServlet(name = "stemme", urlPatterns = { "/stemme" })
public class Favorittfrukt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	int eple=0;
	int	pare=0;
	int	kiwi=0;
	int	banan = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String valg = request.getParameter("valg");

		
		synchronized (valg) {
			switch (valg) {
			case "Eple":
				eple++;
				break;
			case "Pare":
				pare++;
				break;
			case "Kiwi":
				kiwi++;
				break;
			case "Banan":
				banan++;
				break;

			default:
				break;
			}

		}
		response.setContentType("text/html; charset=ISO-8859-1");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Favorittfrukt resultat</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Favorittfrukt resultat</h1>");

		out.println("<p>Eple:" + eple +"</p>");
		out.println("<p>Pære:" + pare +"</p>");
		out.println("<p>Kiwi:" + kiwi  +"</p>");
		out.println("<p>Banan:" +  banan +"</p>");
		out.println("</body>");
		out.println("</html>");


	}

}
