package es.iespuertodelacruz.javier.javierexamen1.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import es.iespuertodelacruz.javier.javierexamen1.utils.GestorDDBB;
import es.iespuertodelacruz.javier.javierexamen1.utils.Global;

/**
 * Application Lifecycle Listener implementation class IniciarPoolConexiones
 *
 */
@WebListener
public class IniciarPoolConexiones implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public IniciarPoolConexiones() {
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
    	GestorDDBB gdb = new GestorDDBB("empresa", "root", "1q2w3e4r");
        sce.getServletContext().setAttribute(Global.APP_GESTORDDBB, gdb);        
    }
	
}
