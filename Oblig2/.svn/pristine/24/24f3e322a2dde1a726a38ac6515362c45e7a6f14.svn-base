package Kontroll;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EAO.EAO;
import modell.*;
import static modell.UrlMappings.*;

/**
 * Servlet implementation class LogginnServlet
 */
@WebServlet("/" + PAAMELDING_SERVLET)
public class PaameeldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EAO EAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(PAAMELDINGS_JSP).forward(request, response);
		HttpSession session = request.getSession(false);
		if (session != null)
			session.removeAttribute("ps");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		boolean altOK = true;
		Personer p = null;

		/**
		 * OBS Vi kan ikke lage en EAO objekt inni i POJO, Så vi sender en
		 * ferdig lagt objekt til POJO "DEPENDENCY INJECTION"
		 */
		PersonSkjema ps = new PersonSkjema();
		ps.fyllPaaAttributter(request, EAO);

		altOK = ps.erAllInputGyldig() && erLagtTilDB(ps, p); //OBS isValidmobil vil bli utført 2 fullstendige ganger, inni 1.erAllgyldig (ikke sync),og den 2.erLagtTilDB(sync)

		if (altOK) {
			InnloggingUtil.loggInnSom(request, p.getmobil());
			session = request.getSession(false); // Hvorfor MÅ vi kalle på session på nytt her?
			session.setAttribute("p", p);

			request.getRequestDispatcher(PAAMELDINGS_BEKREFTELSE_JSP).forward(request, response);
			session.removeAttribute("ps");
		} else {
			session.setAttribute("ps", ps);
			response.sendRedirect(PAAMELDING_SERVLET);

		}
	}

	public synchronized boolean erLagtTilDB(PersonSkjema ps, Personer p) {

		if (!ps.ErRegisterertFraFoer(EAO)) {
			p = new Personer(ps);
			EAO.leggTilPerson(p);
			return true;
		} else {
			return false;
		}

	}

}
