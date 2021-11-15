package es.iespuertodelacruz.javier.instituto.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iespuertodelacruz.javier.instituto.dao.AsignaturaDAO;
import es.iespuertodelacruz.javier.instituto.model.Asignatura;
import es.iespuertodelacruz.javier.instituto.utils.GestorDDBB;
import es.iespuertodelacruz.javier.instituto.utils.Global;

/**
 * Servlet implementation class AsignaturaServlet
 */
@WebServlet("/Asignaturas")
public class AsignaturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignaturaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("asignatura.jsp").forward(request, response);
		request.getSession().setAttribute(Global.SESSION_MENSAJE, "");
		request.getSession().setAttribute(Global.SESSION_ERROR, "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorDDBB gdb = (GestorDDBB) request.getServletContext().getAttribute(Global.APP_GESTORDDBB);
		request.setCharacterEncoding("utf-8");
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gdb);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String submit = request.getParameter("submit");
		
		switch (submit) {
			case "Agregar":
				agregarAsignatura(request, response, asignaturaDAO, mapper);
				break;
	
			case "Borrar":
				borrarAsignatura(request, response, asignaturaDAO);
				break;
	
			case "Editar":
				editarAsignatura(request, response, asignaturaDAO, mapper);
				break;
	
			case "Mostrar":
				mostrarAsignatura(request, response, asignaturaDAO, mapper);
				break;
		}
		
		doGet(request, response);
	}
	
	private void agregarAsignatura(HttpServletRequest request, HttpServletResponse response, AsignaturaDAO asignaturaDAO, ObjectMapper mapper) {

		Asignatura asignatura = null;

		String nombre = request.getParameter("nombre");
		String curso = request.getParameter("curso");

		if (nombre != null && !nombre.trim().isEmpty() && curso != null && !curso.trim().isEmpty()) {
			asignatura = asignaturaDAO.save(new Asignatura(nombre, curso));
		}

		if (asignatura != null) {
			try {
				String jsonAsignatura = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(asignatura);

				request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAsignatura);
			} catch (JsonProcessingException e) {
				request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
			}
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al guardar la asignatura");
		}

	}
	
	private void borrarAsignatura(HttpServletRequest request, HttpServletResponse response, AsignaturaDAO asignaturaDAO) {
		boolean borradoOK = false;
		Integer id = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception ex) {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener el ID");
		}

		if (id != null) {
			borradoOK = asignaturaDAO.delete(id);
		}

		if (borradoOK) {
			request.getSession().setAttribute(Global.SESSION_MENSAJE, "Borrada correctamente la Asignatura con ID: " + id);
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al borrar la Asignatura con ID: " + id);
		}
	}
	
	private void editarAsignatura(HttpServletRequest request, HttpServletResponse response, AsignaturaDAO asignaturaDAO, ObjectMapper mapper) {
		Asignatura asignatura = null;
		Integer id = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception ex){
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener el ID");
		}

		if (id != null) {
			String nombre = request.getParameter("nombre");
			String curso = request.getParameter("curso");

			if (nombre != null && !nombre.trim().isEmpty() && curso != null && !curso.trim().isEmpty()) {
				asignatura = new Asignatura(id, nombre, curso);
			}
		}

		if (asignatura != null) {
			boolean editadoOK = asignaturaDAO.update(asignatura);
			if (editadoOK) {
				try {
					String jsonAsignatura = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(asignatura);

					request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAsignatura);
				} catch (JsonProcessingException e) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
				}
			} else {
				request.getSession().setAttribute(Global.SESSION_ERROR, "Error al editar la asignatura");
			}
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al editar la asignatura");
		}
	}
	
	private void mostrarAsignatura(HttpServletRequest request, HttpServletResponse response, AsignaturaDAO asignaturaDAO, ObjectMapper mapper) {
		String option = request.getParameter("option");

		switch (option) {
			case "todo":
				ArrayList<Asignatura> asignaturas = (ArrayList<Asignatura>) asignaturaDAO.findAll();

				if (asignaturas != null && !asignaturas.isEmpty()) {
					try {
						String jsonAsignaturas = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(asignaturas);

						request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAsignaturas);
					} catch (JsonProcessingException e) {
						request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
					}
				} else {
					request.getSession().setAttribute(Global.SESSION_ERROR, "No existen ninguna asignatura");
				}
				break;

			case "id":
				Asignatura asignatura = null;
				Integer id = null;

				try {
					id = Integer.parseInt(request.getParameter("id"));
				} catch (Exception ex) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener el ID");
				}

				if (id != null) {
					asignatura = asignaturaDAO.findById(id);

					if (asignatura != null) {
						try {
							String jsonAsignatura = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(asignatura);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAsignatura);
						} catch (Exception e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener la asignatura");
					}
				}
				break;

			case "nombre":
				String nombre = request.getParameter("nombre");

				if (nombre != null && !nombre.trim().isEmpty()) {
					Asignatura asignaturaNombre = asignaturaDAO.findByName(nombre);

					if (asignaturaNombre != null) {
						try {
							String jsonAsignaturas = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(asignaturaNombre);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAsignaturas);
						} catch (Exception e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener la asignatura");
					}
				} else {
					request.getSession().setAttribute(Global.SESSION_ERROR, "No existe ninguna Asignatura en este Nombre: " + nombre);
				}
				break;

			case "curso":
				String curso = request.getParameter("curso");
				
				if (curso != null && !curso.trim().isEmpty()) {
					ArrayList<Asignatura> asignaturasCurso = (ArrayList<Asignatura>) asignaturaDAO.findByCurso(curso);

					if (asignaturasCurso != null && !asignaturasCurso.isEmpty()) {
						try {
							String jsonAsignaturas = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(asignaturasCurso);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAsignaturas);
						} catch (Exception e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener las asignaturas");
					}
				} else {
					request.getSession().setAttribute(Global.SESSION_ERROR, "No existe ninguna Asignatura en este Curso");
				}
				break;
		}
	}

}
