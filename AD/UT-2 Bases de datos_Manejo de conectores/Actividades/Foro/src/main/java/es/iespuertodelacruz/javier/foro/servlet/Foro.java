package es.iespuertodelacruz.javier.foro.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.javier.foro.model.Mensaje;
import es.iespuertodelacruz.javier.foro.utils.Global;
import es.iespuertodelacruz.javier.foro.utils.ManejarFichero;

/**
 * Servlet implementation class Foro
 */
public class Foro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Foro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletCont = request.getServletContext();
		
		// Comprobar que existe el vector de mensajes
		controlarUsuarios(servletCont);
		// Comprobar que existe el arraylist de usuarios 
		controlarMensajes(servletCont);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletCont = request.getServletContext();
		
		// Recoger parametros en UTF-8
		request.setCharacterEncoding("UTF-8");
		String mensaje = request.getParameter("mensaje");
		
		// Si el usuario no tiene guardado el nombre en la session le asignamos el nuevo nombre
		String nombreUsuario = (String) request.getSession().getAttribute(Global.NOMBRE_USUARIO_SESSION);
		if (nombreUsuario == null) {
			String nombre = request.getParameter("nombre");
			if (nombre != null && !nombre.equals("")) {
				nombreUsuario = nombre;
				request.getSession().setAttribute(Global.NOMBRE_USUARIO_SESSION, nombre);
			}
		}
		
		// Comprobar que el campo mensaje llega y no esta vacio
		if (mensaje != null && !mensaje.equals("")) {
			
			Vector<Mensaje> mensajes = controlarMensajes(servletCont);
			ArrayList<String> usuariosConectados = controlarUsuarios(servletCont);
			
			// Controlamos que los textos introducidos no tengan salto de linea
			mensaje = mensaje.replaceAll("\n", "");
			mensaje = mensaje.replaceAll("\r", "");
			
			
			// Guardar el mensaje del usuario
			mensajes.add(new Mensaje(nombreUsuario, mensaje));
			
			// Guardar el usuario
			if (!usuariosConectados.contains(nombreUsuario)) {
				usuariosConectados.add(nombreUsuario);
			}
		}
		
		response.sendRedirect("/Foro");
	}
	
	/**
	 * Comprobar si el Vector de Mensajes no es nulo 
	 * @param servletCont acceso al ServletContext()
	 * @return Vector de Mensaje con todos los mensajes
	 */
	private Vector<Mensaje> controlarMensajes(ServletContext servletCont) {
		Vector<Mensaje> mensajes = (Vector<Mensaje>) servletCont.getAttribute(Global.MENSAJES_VECTOR);
		if (mensajes == null) {
			mensajes = new Vector<Mensaje>();
			servletCont.setAttribute(Global.MENSAJES_VECTOR, mensajes);
		}
		return mensajes;
	}
	
	/**
	 * Comprobar si el ArrayList de Usuarios Conectados no es nulo
	 * @param servletCont acceso al ServletContext()
	 * @return ArrayList de String con todos los usuarios conectos
	 */
	private ArrayList<String> controlarUsuarios(ServletContext servletCont) {
		ArrayList<String> usuariosConectados = (ArrayList<String>) servletCont.getAttribute(Global.USUARIOS_CONECTADOS);
		if (usuariosConectados == null) {
			usuariosConectados = new ArrayList<String>();
			servletCont.setAttribute(Global.USUARIOS_CONECTADOS, usuariosConectados);
		}
		return usuariosConectados;
	}

}
