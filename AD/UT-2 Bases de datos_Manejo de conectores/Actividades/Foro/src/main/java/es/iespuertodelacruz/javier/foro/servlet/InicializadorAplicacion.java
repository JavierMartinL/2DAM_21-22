package es.iespuertodelacruz.javier.foro.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.iespuertodelacruz.javier.foro.model.Mensaje;
import es.iespuertodelacruz.javier.foro.utils.Global;
import es.iespuertodelacruz.javier.foro.utils.HiloGuardarFichero;
import es.iespuertodelacruz.javier.foro.utils.ManejarFichero;

/**
 * Application Lifecycle Listener implementation class InicializadorAplicacion
 *
 */
public class InicializadorAplicacion implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializadorAplicacion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	Thread thread = (Thread) sce.getServletContext().getAttribute(Global.GUARDAR_FICHERO_HILO);
    	thread.interrupt();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	String pathToWeb = sce.getServletContext().getRealPath(File.separator);
    	String ruta = pathToWeb + File.separator + "WEB-INF" + File.separator + "mensajes.txt";
    	
    	ManejarFichero mf = new ManejarFichero(ruta);
    	
    	try {
			Vector<Mensaje> mensajes = mf.leerTodo();
			long ultimoHashCode = mensajes.hashCode();
			
			sce.getServletContext().setAttribute(Global.MENSAJES_VECTOR, mensajes);
			sce.getServletContext().setAttribute(Global.ULTIMO_HASH_CODE, ultimoHashCode);
			
			HiloGuardarFichero hgf = new HiloGuardarFichero(mf, mensajes, ultimoHashCode);
			Thread thread = new Thread(hgf);
			thread.start();
			
			sce.getServletContext().setAttribute(Global.GUARDAR_FICHERO_HILO, thread);
		} catch (IOException e) { }
    	
    }
	
}
