package es.iespuertodelacruz.javier.foro.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import es.iespuertodelacruz.javier.foro.utils.Global;

/**
 * Application Lifecycle Listener implementation class ControlUsuarioSession
 *
 */
public class ControlUsuarioSession implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ControlUsuarioSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
    	
    	ArrayList<String> usuariosConectados = (ArrayList<String>) se.getSession().getServletContext().getAttribute(Global.USUARIOS_CONECTADOS);
    	String nombreUsuario = (String) se.getSession().getAttribute(Global.NOMBRE_USUARIO_SESSION);
    	
    	if (usuariosConectados.contains(nombreUsuario)) {
    		usuariosConectados.remove(nombreUsuario);
    		se.getSession().setAttribute(Global.NOMBRE_USUARIO_SESSION, null);
    	}
    }
	
}
