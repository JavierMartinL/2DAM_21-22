package es.iespuertodelacruz.javier.tcjavier.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.javier.tcjavier.utils.ManejoFichero;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManejoFichero mf;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        mf = new ManejoFichero();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// mostrar la pagina index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreFichero = request.getParameter("nombre");
		
		if ((nombreFichero != null && !nombreFichero.trim().isEmpty())) {
			String texto = request.getParameter("texto");
			if (texto != null) {
				
				boolean guardado = mf.guardar(nombreFichero, texto);
								
				request.getSession().setAttribute("nombreFichero", nombreFichero);
				request.getSession().setAttribute("texto", texto);
				request.getSession().setAttribute("guardado", guardado);
			}
		} else {
			nombreFichero = request.getParameter("nombreCargar");
			String texto = mf.leer(nombreFichero);
			
			request.getSession().setAttribute("nombreFichero", nombreFichero);
			request.getSession().setAttribute("texto", texto);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
