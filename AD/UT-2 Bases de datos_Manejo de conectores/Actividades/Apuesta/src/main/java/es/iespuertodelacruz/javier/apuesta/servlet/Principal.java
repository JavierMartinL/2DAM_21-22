package es.iespuertodelacruz.javier.apuesta.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.javier.apuesta.model.Secreto;
import es.iespuertodelacruz.javier.apuesta.utils.ManejoFichero;

/**
 * Servlet implementation class Principal
 */
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Principal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Recoger el nick del usuario en sesion
		String nickSession = (String) request.getSession().getAttribute("nickSession");

		if (nickSession == null) {
			// Si es nulo debe crear un nick
			request.getRequestDispatcher("crearusuario.jsp").forward(request, response);
		} else {
			// Si No es nulo puede jugar
			request.getRequestDispatcher("jugar.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Recoger el nick del usuario en sesion
		String nickSession = (String) request.getSession().getAttribute("nickSession");

		// Si el nick es nulo debo comprobar que me llega uno por parametro
		if (nickSession == null) {
			// Recoger el parametro
			String nickParameter = request.getParameter("nick");

			if (nickParameter == null || nickParameter.trim().isEmpty()) {
				// Si es nulo o esta vacio debe introducir de nuevo el nick
				request.getRequestDispatcher("crearusuario.jsp").forward(request, response);
			} else {
				// Guardar el nuevo nick y creamos la lista de apuesta en session y enviar a jugar.jsp
				nickSession = nickParameter;

				TreeMap<Long, Integer> apuestas = new TreeMap<Long, Integer>();

				request.getSession().setAttribute("nickSession", nickSession);
				request.getSession().setAttribute("apuestas", apuestas);
				request.getRequestDispatcher("jugar.jsp").forward(request, response);
			}
		} else
			gestionarApuesta(request, response);

	}

	private void gestionarApuesta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recoger la apuesta del usuario
		Integer apuestaParameter = Integer.parseInt(request.getParameter("apuesta"));

		if (apuestaParameter != null) {
			// Recoger el numero secreto por si ha cambiado, el ultimo secreto y la lista de apuestas del usuario
			Secreto secreto = (Secreto) request.getServletContext().getAttribute("secreto");
			Secreto ultimoGanador = (Secreto) request.getServletContext().getAttribute("ultimoGanador");
			TreeMap<Long, Integer> apuestas = (TreeMap<Long, Integer>) request.getSession().getAttribute("apuestas");
			
			// Borrar las apuestas mas antiguas que el secreto
			long tiempoCreacionSecreto = secreto.getHoraCreacion();
			apuestas.keySet().removeIf(tiempoApuesta -> tiempoApuesta <= tiempoCreacionSecreto);

			// Guardar la nueva apuesta
			apuestas.put((new Date()).getTime(), apuestaParameter);
			
			// Si acertamos el secreto
			if (apuestaParameter == secreto.getNumero()) {
				// Recoger nick del usuario y el momento en el que acerto
				String nickSession = (String) request.getSession().getAttribute("nickSession");
				Date hora = new Date();
				long segundoEnAcertar = (hora.getTime() - tiempoCreacionSecreto) / 1000;
				
				// Actualizamos el ultimoGanador y lo enviamos a la vista jugar.jsp
				ultimoGanador = secreto;
				ultimoGanador.setNickGanador(nickSession);
				ultimoGanador.setCantTiempoAcierto(segundoEnAcertar);
				
				request.getServletContext().setAttribute("ultimoGanador", ultimoGanador);
				request.getServletContext().setAttribute("horaAcierto", hora);
				
				// Guardar el nuevo ganador en el fichero
				ManejoFichero mf = (ManejoFichero) request.getServletContext().getAttribute("manejoFichero");
				mf.guardarTexto(ultimoGanador.toString());

				// Mostrar una clasificacion con los mejores tiempos
				cargarClasificacion(request, response);
				request.getRequestDispatcher("jugar.jsp").forward(request, response);
				
				// Creamo un nuevo secreto para la nueva partida
				secreto = new Secreto((int) (Math.random() * 10000), hora.getTime());
				request.getServletContext().setAttribute("secreto", secreto);
				request.getServletContext().setAttribute("horaCreacion", hora);
			} else {
				request.getRequestDispatcher("jugar.jsp").forward(request, response);
			}
			
		}

	}
	
	private void cargarClasificacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// Recoger los datos guardados en el fichero
		ManejoFichero mf = (ManejoFichero) request.getServletContext().getAttribute("manejoFichero");
		String texto = mf.leerTodo();
		
		ArrayList<Secreto> ganadores = new ArrayList<>();
		
		String[] lineasFichero = texto.split("\n");
		
		for (String linea : lineasFichero) {
			String[] datos = linea.split(";");
			if (datos.length == 3) {
				ganadores.add(new Secreto(datos[0], Integer.parseInt(datos[1]), Long.parseLong(datos[2])));
			}
		}
		
		// Recogo los 10 mejores tiempos
		ganadores = (ArrayList<Secreto>) ganadores.stream().sorted(Comparator.comparing(Secreto::getCantTiempoAcierto)).limit(10).collect(Collectors.toList());
		
		request.getServletContext().setAttribute("ganadores", ganadores);
		
	}

}
