package no.hib.dat104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Stemmeskjema
 */
@WebServlet("/stemmeskjema")
public class Stemmeskjema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static String FILEPATH="/WEB-INF/option.txt";
	static HashMap<String, Integer> fruktMap;
	int antallFrukt=0;

	@Override
	public void init() throws ServletException {
		 
		try {
			List<String> fruktListeiFilen = readOptionsFromFile(FILEPATH);
			fruktMap  = new HashMap<String, Integer>();
			
			for (String frukt : fruktListeiFilen) {
				fruktMap.put(frukt, 0);
				antallFrukt++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	private List<String> readOptionsFromFile(String filePath)throws IOException {
		List<String> options = new ArrayList<String>();
		InputStream optionsStream = getServletContext().getResourceAsStream(filePath);
		BufferedReader optionsReader = new BufferedReader(new InputStreamReader(optionsStream));
		String option = optionsReader.readLine();
		while (option != null) {
			options.add(option);
			option = optionsReader.readLine();
		}
		optionsReader.close();
		return options;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		response.setContentType("text/html; charset=ISO-8859-1");

		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Frukt</title>");
		out.println("</head>");
		out.println("<bodyonload=\"check()\">");
		out.println("<form action=\"stemme\" method=\"post\">");
		out.println("<fieldset>");
		out.println("<legend>Favorittfrukt</legend>");
		out.println("<p>");
		for (String fruktnavn:fruktMap.keySet()) {
			out.println(" <input type=\"radio\" name=\"valg\" value=\"" + fruktnavn +  "\"  onclick=\"check()\"/>"+fruktnavn +"<br>");
 		}

		out.println("</p>");
		
		out.println("<input type=\"submit\" value=\"stem\" id='stem'  disabled=\"disabled\"/>");
		out.println("</fieldset>");
		out.println("</form>");

		out.println(" <script>	function check() {	var radios = document.getElementsByName('valg'); var flag=0; for (var i = 0; i < radios.length && flag==0; i++) {if (radios[i].checked)	 flag=1;}document.getElementById('stem').disabled=(flag==0)?true:false;}</script>");
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
