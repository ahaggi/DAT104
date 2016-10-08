package no.hib.dat104.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Oppstartslytter implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  {
        sce.getServletContext().setAttribute("antallBesokSide1", 0);
        sce.getServletContext().setAttribute("antallBesokSide2", 0);
        sce.getServletContext().setAttribute("besokTotalt", 0);
        
    }
	
}
