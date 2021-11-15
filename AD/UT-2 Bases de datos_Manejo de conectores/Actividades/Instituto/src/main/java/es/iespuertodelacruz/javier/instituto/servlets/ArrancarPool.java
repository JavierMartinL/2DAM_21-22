package es.iespuertodelacruz.javier.instituto.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import es.iespuertodelacruz.javier.instituto.utils.GestorDDBB;
import es.iespuertodelacruz.javier.instituto.utils.Global;

/**
 * Application Lifecycle Listener implementation class ArrancarPool
 *
 */
@WebListener
public class ArrancarPool implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ArrancarPool() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	GestorDDBB gdb = new GestorDDBB("instituto", "root", null);
        sce.getServletContext().setAttribute(Global.APP_GESTORDDBB, gdb);
    }
	
}
