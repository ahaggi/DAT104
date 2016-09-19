package lph.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lph.dataaccess.StudentEAO;
import lph.model.Student;

@WebServlet("/JpaTestServlet")
public class JpaTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private StudentEAO studentEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Student> alleStudenter = studentEAO.alleStudenterTotalt();
		
		PrintWriter out = response.getWriter();
		out.println("<table> "
				+ "   <tr>"
				+ "	    <th>ID</th>"
				+ "	    <th>Navn</th>"
				+ "	    <th>Klassekode</th>"
				+ "	  </tr>");
		

		for (Student s : alleStudenter) {
			
			out.println("<tr>");
			out.println("<td>"+ s.getId()+ "</td> ");
			out.println("<td>"+ s.getNavn()+ "</td>");
			out.println("<td>"+ s.getKlasse().getKode()+ "</td> ");
			out.println("</tr>");

		}
		out.println( "</table>");

	}
	
	
	
	
	
	 
}
