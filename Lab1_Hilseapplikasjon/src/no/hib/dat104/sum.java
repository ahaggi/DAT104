package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HilseServlet
 */
@WebServlet("/sum")
public class sum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(
			HttpServletRequest req, HttpServletResponse res)
					throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");

		String n1=req.getParameter("n1");
		String n2=req.getParameter("n2");

		int result=Integer.parseInt(n1)+Integer.parseInt(n2);		
		out.println("Sum of two numbers " +result);
		out.close();
	}

}
