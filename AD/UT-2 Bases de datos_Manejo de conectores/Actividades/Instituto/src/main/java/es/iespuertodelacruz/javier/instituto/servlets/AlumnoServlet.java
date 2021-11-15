package es.iespuertodelacruz.javier.instituto.servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iespuertodelacruz.javier.instituto.dao.AlumnoDAO;
import es.iespuertodelacruz.javier.instituto.model.Alumno;
import es.iespuertodelacruz.javier.instituto.utils.GestorDDBB;
import es.iespuertodelacruz.javier.instituto.utils.Global;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlumnoServlet
 */
@WebServlet("/Alumnos")
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("alumno.jsp").forward(request, response);
		request.getSession().setAttribute(Global.SESSION_MENSAJE, "");
		request.getSession().setAttribute(Global.SESSION_ERROR, "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GestorDDBB gdb = (GestorDDBB) request.getServletContext().getAttribute(Global.APP_GESTORDDBB);
		request.setCharacterEncoding("utf-8");
		AlumnoDAO alumnoDAO = new AlumnoDAO(gdb);

		ObjectMapper mapper = new ObjectMapper();

		String submit = request.getParameter("submit");

		switch (submit) {
			case "Agregar":
				agregarAlumno(request, response, alumnoDAO, mapper);
				break;

			case "Borrar":
				borrarAlumno(request, response, alumnoDAO);
				break;

			case "Editar":
				editarAlumno(request, response, alumnoDAO, mapper);
				break;

			case "Mostrar":
				mostrarAlumno(request, response, alumnoDAO, mapper);
				break;
		}
		
		doGet(request, response);
	}

	private void agregarAlumno(HttpServletRequest request, HttpServletResponse response, AlumnoDAO alumnoDAO, ObjectMapper mapper) {

		Alumno alumno = null;

		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String nacimiento = request.getParameter("nacimiento");

		if (nombre != null && !nombre.trim().isEmpty() && dni != null && !dni.trim().isEmpty()) {
			alumno = new Alumno();
			alumno.setDni(dni);
			alumno.setNombre(nombre);

			if (apellidos != null && !apellidos.trim().isEmpty()) {
				alumno.setApellidos(apellidos);
			}

			if (nacimiento != null && !nacimiento.trim().isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = null;

				try {
					fecha = sdf.parse(nacimiento);
				} catch (Exception e) { }

				alumno.setFechaNacimiento(fecha);
			}
		}

		if (alumno != null) {
			alumno = alumnoDAO.save(alumno);

			if (alumno != null) {
				try {
					String jsonAlumno = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alumno);

					request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAlumno);
				} catch (JsonProcessingException e) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
				}
			} else {
				request.getSession().setAttribute(Global.SESSION_ERROR, "Error al guardar el alumno");
			}
		}
	}

    private void borrarAlumno(HttpServletRequest request, HttpServletResponse response, AlumnoDAO alumnoDAO) {

		boolean borrado = false;
		String dni = request.getParameter("dni");

		if (dni != null && !dni.trim().isEmpty()) {
			borrado = alumnoDAO.delete(dni);
		}

		if (borrado) {
			request.getSession().setAttribute(Global.SESSION_MENSAJE, "Borrado el Alumno con DNI: " + dni);
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al borrar el alumno con DNI: " + dni);
		}
    }

    private void editarAlumno(HttpServletRequest request, HttpServletResponse response, AlumnoDAO alumnoDAO, ObjectMapper mapper) {

		Alumno alumno = null;

		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String nacimiento = request.getParameter("nacimiento");

		if (nombre != null && !nombre.trim().isEmpty() && dni != null && !dni.trim().isEmpty()) {
			alumno = new Alumno();
			alumno.setDni(dni);
			alumno.setNombre(nombre);

			if (apellidos != null && !apellidos.trim().isEmpty()) {
				alumno.setApellidos(apellidos);
			}

			if (nacimiento != null && !nacimiento.trim().isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = null;

				try {
					fecha = sdf.parse(nacimiento);
				} catch (Exception e) { }

				alumno.setFechaNacimiento(fecha);
			}
		}

		if (alumno != null) {
			boolean updateOK = alumnoDAO.update(alumno);

			if (updateOK) {
				try {
					String jsonAlumno = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alumno);

					request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAlumno);
				} catch (JsonProcessingException e) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
				}
			} else {
				request.getSession().setAttribute(Global.SESSION_ERROR, "Error al guardar el alumno");
			}
		}
    }

    private void mostrarAlumno(HttpServletRequest request, HttpServletResponse response, AlumnoDAO alumnoDAO, ObjectMapper mapper) {

		String option = request.getParameter("option");

		switch (option) {
			case "todo":
				ArrayList<Alumno> alumnos = (ArrayList<Alumno>) alumnoDAO.findAll();

				if (alumnos != null && !alumnos.isEmpty()) {
					try {
						String jsonAlumnos = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alumnos);

						request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAlumnos);
					} catch (JsonProcessingException e) {
						request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
					}
				} else {
					request.getSession().setAttribute(Global.SESSION_ERROR, "No existe ningun alumno");
				}
				break;

			case "dni":
				String dni = request.getParameter("dni");

				if (dni != null && !dni.trim().isEmpty()) {
					Alumno alumno = alumnoDAO.findById(dni);

					if (alumno != null) {
						try {
							String jsonAlumno = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alumno);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAlumno);
						} catch (JsonProcessingException e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "No existe ningun alumno con el DNI: " + dni);
					}
				}
				break;

			case "nombre":
				String nombre = request.getParameter("nombre");

				if (nombre != null && !nombre.trim().isEmpty()) {
					ArrayList<Alumno> alumnosNombre = (ArrayList<Alumno>) alumnoDAO.findByName(nombre);

					if (alumnosNombre != null && !alumnosNombre.isEmpty()) {
						try {
							String jsonAlumnos = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alumnosNombre);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAlumnos);
						} catch (JsonProcessingException e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "No existe ningun alumno con este nombre");
					}
				}
				break;

			case "asignaturaAnio":
				Integer asignatura = null;
				Integer anio = null;

				try {
					asignatura = Integer.parseInt(request.getParameter("asignatura"));
				} catch (Exception ex) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener la asignatura");
				}

				try {
					anio = Integer.parseInt(request.getParameter("anio"));
				} catch (Exception ex) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error al obtener el año");
				}

				if (asignatura != null && anio != null) {
					ArrayList<Alumno> alumnosAsignaturaAnio = (ArrayList<Alumno>) alumnoDAO.findByAsignaturaAnio(asignatura, anio);

					if (alumnosAsignaturaAnio != null && !alumnosAsignaturaAnio.isEmpty()) {
						try {
							String jsonAlumnos = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alumnosAsignaturaAnio);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonAlumnos);
						} catch (JsonProcessingException e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "No existe ningun alumno en el " + anio + " con la asignatura " + asignatura);
					}
				}
				break;
		}
    }
}