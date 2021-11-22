package es.iespuertodelacruz.javier.javierexamen1.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iespuertodelacruz.javier.javierexamen1.dao.EmpleadoDAO;
import es.iespuertodelacruz.javier.javierexamen1.model.Empleado;
import es.iespuertodelacruz.javier.javierexamen1.utils.GestorDDBB;
import es.iespuertodelacruz.javier.javierexamen1.utils.Global;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestorDDBB gdb = (GestorDDBB) request.getServletContext().getAttribute(Global.APP_GESTORDDBB);
		request.setCharacterEncoding("utf-8");
		EmpleadoDAO empleadoDAO = new EmpleadoDAO(gdb);

		ObjectMapper mapper = new ObjectMapper();
		
		String form = request.getParameter("submit");
		
		switch (form) {
		case "Crear":
			crearEmpleado(request, response, empleadoDAO, mapper);
			request.getRequestDispatcher("crearempleado.jsp").forward(request, response);
			break;
			
		case "Buscar":
			buscarEmpleado(request, response, empleadoDAO, mapper);
			request.getRequestDispatcher("buscarempleado.jsp").forward(request, response);
			break;
		
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
	}
	
	private void crearEmpleado(HttpServletRequest request, HttpServletResponse response, EmpleadoDAO empleadoDAO, ObjectMapper mapper) {
		Integer idEmpleado = null;
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String fechaContrato = request.getParameter("fechacontrato");
		Integer idJefe = null;
		String municipio = request.getParameter("municipio");
		String calle = request.getParameter("calle");
		Integer numero = null;
		
		try {
			idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
			idJefe = Integer.parseInt(request.getParameter("jefe"));
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (Exception ex) { }
		
		if (validarInputs(idEmpleado, nombre, apellidos, idJefe, municipio, calle, numero)) {
			Empleado empleado = null;
			
			if (fechaContrato != null && !fechaContrato.trim().isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = null;
				try {
					fecha = sdf.parse(fechaContrato);
				} catch (Exception e) { }
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = null;
			
			try {
				fecha = (Date) sdf.parse(fechaContrato);
			} catch (Exception e) { }
			
			empleado = empleadoDAO.save(new Empleado(
					idEmpleado, 
					nombre, 
					apellidos, 
					fecha, 
					numero, 
					calle, 
					municipio, 
					empleadoDAO.findById(idJefe)));
			
			if (empleado != null) {
				try {
					String jsonEmpleado = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empleado);

					request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonEmpleado);
				} catch (JsonProcessingException e) {
					request.getSession().setAttribute(Global.SESSION_MENSAJE, "Error al generar el JSON");
				}
			} else {
				request.getSession().setAttribute(Global.SESSION_MENSAJE, "Error con los datos introducidos ");
			}
		}
	}
	
	private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response, EmpleadoDAO empleadoDAO, ObjectMapper mapper) {
		System.out.println("Entro");
		Integer idEmpleado = null;
		Long fechaInferior = null;
		Long fechaSuperior = null;
		String nombre = request.getParameter("nombre");
		
		try {
			idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
		} catch (Exception e) { }
		
		try {
			fechaInferior = Long.parseLong(request.getParameter("fechainferior"));
			fechaInferior = Long.parseLong(request.getParameter("fechasuperior"));
		} catch (Exception e) { }
		
		if (idEmpleado  != null) {
			Empleado empleado = empleadoDAO.findById(idEmpleado);
			
			if (empleado != null) {
				try {
					String jsonEmpleado = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empleado);

					request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonEmpleado);
				} catch (JsonProcessingException e) {
					request.getSession().setAttribute(Global.SESSION_MENSAJE, "Error al generar el JSON");
				}
			} else {
				request.getSession().setAttribute(Global.SESSION_MENSAJE, "No existe ningun empleado con el ID: " + idEmpleado);
			}
		} else if (nombre != null && !nombre.trim().isEmpty()) {
		} else if (fechaInferior != null && fechaSuperior != null) {
		} else {
			ArrayList<Empleado> empleados = (ArrayList<Empleado>) empleadoDAO.findAll();

			if (empleados != null && !empleados.isEmpty()) {
				try {
					String jsonEmpleados = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empleados);

					request.getSession().setAttribute(Global.SESSION_MENSAJE, jsonEmpleados);
				} catch (JsonProcessingException e) {
					request.getSession().setAttribute(Global.SESSION_MENSAJE, "Error al generar el JSON");
				}
			} else {
				request.getSession().setAttribute(Global.SESSION_MENSAJE, "No existe ningun Empleado");
			}
		}
		
	}

	private boolean validarInputs(Integer idEmpleado, String nombre, String apellidos, Integer idJefe, String municipio, String calle, Integer numero) {
		boolean inputsOk = true;
		
		if (idEmpleado == null) 
			inputsOk = false;
		
		if (nombre == null || nombre.trim().isEmpty()) 
			inputsOk = false;
		
		if (apellidos == null || apellidos.trim().isEmpty()) 
			inputsOk = false;
		
		if (idJefe == null) 
			inputsOk = false;
		
		if (municipio == null || municipio.trim().isEmpty()) 
			inputsOk = false;
		
		if (calle == null || calle.trim().isEmpty()) 
			inputsOk = false;
		
		if (numero == null) 
			inputsOk = false;
		
		return inputsOk;
	}
}
