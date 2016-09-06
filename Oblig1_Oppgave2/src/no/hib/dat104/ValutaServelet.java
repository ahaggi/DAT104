package no.hib.dat104;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.bval.Validate;

/**
 * Servlet implementation class ValutaServelet
 */
@WebServlet("/result")
public class ValutaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValutaServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String source = request.getParameter("source");
        String target = request.getParameter("target");
        String amount = request.getParameter("amount");
        
        
//        {"success":true,
//    		"source":"USD",
//    		"target":"EUR",
//    		"rate":"0.8996300",
//    		"amount":0.9,
//    		"message":""}

       
		String resMelding="";

		if (Regnom.validate(amount) ){
//	        ExchangeRate exchangeRateResultat= ExchangeRateService.getRate(source, target);
			String resultatBelop=Regnom.regn(amount,1.4);
			resMelding= amount + " "+ source +" blir "+ resultatBelop +" "+ target;
		}else{
			resMelding="FeilFeilFeilFeilFeil";
		}
		
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Valutaveksling</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Valutaveksling resultat</h1>");
		out.println("<h3> "+resMelding+"</h3>");
		out.println("<a href=\"index.html\">En gang til</a>");
		out.println("</body>");
		out.println("</html>");

	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
