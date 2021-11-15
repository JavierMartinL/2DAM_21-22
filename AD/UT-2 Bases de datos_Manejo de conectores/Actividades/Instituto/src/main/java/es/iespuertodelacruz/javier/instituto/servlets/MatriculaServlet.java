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

import es.iespuertodelacruz.javier.instituto.dao.MatriculaDAO;
import es.iespuertodelacruz.javier.instituto.model.Alumno;
import es.iespuertodelacruz.javier.instituto.model.Asignatura;
import es.iespuertodelacruz.javier.instituto.model.Matricula;
import es.iespuertodelacruz.javier.instituto.utils.GestorDDBB;
import es.iespuertodelacruz.javier.instituto.utils.Global;

/**
 * Servlet implementation class MatriculaServlet
 */
@WebServlet("/Matriculas")
public class MatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatriculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("matricula.jsp").forward(request, response);
		request.getSession().setAttribute(Global.SESSION_MENSAJE, "");
		request.getSession().setAttribute(Global.SESSION_ERROR, "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorDDBB gdb = (GestorDDBB) request.getServletContext().getAttribute(Global.APP_GESTORDDBB);
		request.setCharacterEncoding("utf-8");
		MatriculaDAO matriculaDAO = new MatriculaDAO(gdb);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String submit = request.getParameter("submit");
		
		switch (submit) {
			case "Agregar":
				agregarMatricula(request, response, matriculaDAO, mapper);
				break;
	
			case "Borrar":
				borrarMatricula(request, response, matriculaDAO);
				break;
	
			case "Editar":
				editarMatricula(request, response, matriculaDAO);
				break;
	
			case "Mostrar":
				mostrarMatricula(request, response, matriculaDAO, mapper);
				break;
		}
		
		doGet(request, response);
	}
	
	private void agregarMatricula(HttpServletRequest request, HttpServletResponse response, MatriculaDAO matriculaDAO, ObjectMapper mapper) {

		Matricula matricula = null;
		Alumno alumno = new Alumno();

		String dni = request.getParameter("dni");
		Integer anio = null;
		String asignaturas = request.getParameter("asignaturas");

		try {
			anio = Integer.parseInt(request.getParameter("anio"));
		} catch (Exception e) {
			request.getSession().setAttribute(Global.SESSION_ERROR, "El año debe ser un número");
		}

		if (dni != null && !dni.trim().isEmpty()) {
			alumno.setDni(dni);
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "El DNI no puede estar vacío");
		}

		if (alumno.getDni() != null) {
			if (anio != null && asignaturas != null && !asignaturas.trim().isEmpty()) {
	            ArrayList<Asignatura> asignaturasSave = new ArrayList<>();

				for (String asignatura : asignaturas.split(",")) {
					Asignatura asignaturaObj = new Asignatura();
					asignaturaObj.setNombre(asignatura.trim());
					asignaturasSave.add(asignaturaObj);
				}

			    Matricula matriculaSave = new Matricula();
				matriculaSave.setAlumno(alumno);
				matriculaSave.setYear(anio);
				matriculaSave.setAsignaturas(asignaturasSave);

				matricula = matriculaDAO.save(matriculaSave);
			}
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "El DNI " + dni + " no es valido");
		}

		if (matricula != null) {
			try {
				String jsonMatricula = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matricula);

				request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonMatricula);
			} catch (JsonProcessingException e) {
				request.getSession().setAttribute(Global.SESSION_ERROR, "Error al convertir la matricula a JSON");
			}
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al guardar la matricula");
		}
	}
	
	private void borrarMatricula(HttpServletRequest request, HttpServletResponse response, MatriculaDAO matriculaDAO) {
		boolean borradoOK = false;
		Integer id = null;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			request.getSession().setAttribute(Global.SESSION_ERROR, "El id debe ser un número");
		}

		if (id != null) {
			borradoOK = matriculaDAO.delete(id);
		}

		if (borradoOK) {
			request.getSession().setAttribute(Global.SESSION_MENSAJE, "Matricula borrada correctamente");
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al borrar la matricula con ID: " + id);
		}
	}
	
	private void editarMatricula(HttpServletRequest request, HttpServletResponse response, MatriculaDAO matriculaDAO) {
		boolean updateOK = false;
		Alumno alumno = new Alumno();;

		Integer id = null;
		String dni = request.getParameter("dni");
		Integer anio = null;
		String asignaturas = request.getParameter("asignaturas");

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			request.getSession().setAttribute(Global.SESSION_ERROR, "El id debe ser un número");
		}

		try {
			anio = Integer.parseInt(request.getParameter("anio"));
		} catch (Exception e) {
			request.getSession().setAttribute(Global.SESSION_ERROR, "El año debe ser un número");
		}

		if (id != null) {
			if (dni != null && !dni.trim().isEmpty()) {
				alumno.setDni(dni);
			} else {
				request.getSession().setAttribute(Global.SESSION_ERROR, "El DNI no puede estar vacío");
			}

			if (alumno.getDni() != null) {
				if (anio != null && asignaturas != null && !asignaturas.trim().isEmpty()) {
					ArrayList<Asignatura> asignaturasSave = new ArrayList<>();

					for (String asignatura : asignaturas.split(",")) {
						Asignatura asignaturaObj = new Asignatura();
						asignaturaObj.setNombre(asignatura.trim());
						asignaturasSave.add(asignaturaObj);
					}

					Matricula matriculaUpdate = new Matricula();
					matriculaUpdate.setIdMatricula(id);
					matriculaUpdate.setAlumno(alumno);
					matriculaUpdate.setYear(anio);
					matriculaUpdate.setAsignaturas(asignaturasSave);

					updateOK = matriculaDAO.update(matriculaUpdate);
				}
			} else {
				request.getSession().setAttribute(Global.SESSION_ERROR, "El DNI " + dni + " no es valido");
			}
		}

		if (updateOK) {
			request.getSession().setAttribute(Global.SESSION_MENSAJE, "Matricula actualizada correctamente");
		} else {
			request.getSession().setAttribute(Global.SESSION_ERROR, "Error al editar la matricula");
		}
	}
	
	private void mostrarMatricula(HttpServletRequest request, HttpServletResponse response, MatriculaDAO matriculaDAO, ObjectMapper mapper) {
		String option = request.getParameter("option");

		switch (option) {
			case "todo":
				ArrayList<Matricula> matriculas = (ArrayList<Matricula>) matriculaDAO.findAll();

				if (matriculas != null && !matriculas.isEmpty()) {
					try {
						String jsonMatriculas = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matriculas);

						request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonMatriculas);
					} catch (JsonProcessingException e) {
						request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
					}
				} else {
					request.getSession().setAttribute(Global.SESSION_ERROR, "No hay matriculas");
				}
				break;

			case "id":
				Matricula matricula = null;
				Integer id = null;

				try {
					id = Integer.parseInt(request.getParameter("id"));
				} catch (Exception e) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error con el ID introducido");
				}

				if (id != null) {
					matricula = matriculaDAO.findById(id);

					if (matricula != null) {
						try {
							String jsonMatricula = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matricula);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonMatricula);
						} catch (JsonProcessingException e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "No existe la matricula");
					}
				}

				break;

			case "anio":
				ArrayList<Matricula> matriculasAnio = null;
				Integer anio = null;

				try {
					anio = Integer.parseInt(request.getParameter("anio"));
				} catch (Exception e) {
					request.getSession().setAttribute(Global.SESSION_ERROR, "Error con el año introducido");
				}

				if (anio != null) {
					matriculasAnio = (ArrayList<Matricula>) matriculaDAO.findByYear(anio);

					if (matriculasAnio != null && !matriculasAnio.isEmpty()) {
						try {
							String jsonMatriculas = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matriculasAnio);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonMatriculas);
						} catch (JsonProcessingException e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "No existen matrículas en el año: " + anio);
					}
				}
				break;

			case "dni":
				ArrayList<Matricula> matriculasDNI = null;
				String dni = request.getParameter("dni");

				if (dni != null && !dni.trim().isEmpty()) {
					matriculasDNI = (ArrayList<Matricula>) matriculaDAO.findByDNI(dni);

					if (matriculasDNI != null && !matriculasDNI.isEmpty()) {
						try {
							String jsonMatriculas = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matriculasDNI);

							request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonMatriculas);
						} catch (JsonProcessingException e) {
							request.getSession().setAttribute(Global.SESSION_ERROR, "Error al generar el JSON");
						}
					} else {
						request.getSession().setAttribute(Global.SESSION_ERROR, "No existen matrículas relacionadas con el DNI: " + dni);
					}
				}
				break;
		}

	}

}
