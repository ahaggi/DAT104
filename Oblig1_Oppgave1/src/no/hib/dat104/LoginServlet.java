package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String fornavn = request.getParameter("fornavn");
        String etternavn = request.getParameter("etternavn");
        
        //System.out.println(fornavn + " " + etternavn);
        
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

}
