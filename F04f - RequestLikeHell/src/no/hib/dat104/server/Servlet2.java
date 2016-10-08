package no.hib.dat104.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int antallBesokSide2 = 0;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer antallBesokTotalt = (Integer) getServletContext().getAttribute("besokTotalt");

		if (request.getParameter("count") != null) {
			
			// Oppdater og lagrer instansvariabelen for antall besøk til denne siden (=side1)
			synchronized (this) {
				antallBesokSide2++;
			}
			getServletContext().setAttribute("antallBesokSide2", antallBesokSide2);

			// Henter, oppdater og lagrer app-scope-attributten for antall besøk totalt
			synchronized (getServletContext()) {
        	antallBesokTotalt = (Integer) getServletContext().getAttribute("besokTotalt");
			antallBesokTotalt++;
			getServletContext().setAttribute("besokTotalt", antallBesokTotalt);
			}
		}
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("Antall besøk side 1 : " + hentFraContext("antallBesokSide1"));
		out.println("Antall besøk side 2 : " + antallBesokSide2);
		out.println("Antall besøk totalt : " + antallBesokTotalt);
	}

	private int hentFraContext(String attributtNavn) {
		return (Integer) getServletContext().getAttribute(attributtNavn);
	}

}
