package es.iespuertodelacruz.javier.northwind.servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import es.iespuertodelacruz.javier.northwind.entities.Employee;
import es.iespuertodelacruz.javier.northwind.entities.User;
import es.iespuertodelacruz.javier.northwind.repositories.CustomerRepository;
import es.iespuertodelacruz.javier.northwind.repositories.EmployeeRepository;
import es.iespuertodelacruz.javier.northwind.repositories.UserRepository;
import es.iespuertodelacruz.javier.northwind.utils.Global;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/Login", "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute(Global.SESSION_EMPLOYEE);
		String redirect = "/login.jsp";
		
		if (employee != null) {
			redirect = "/employee/customer";
		}
		response.sendRedirect(request.getServletContext().getContextPath() + redirect);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute(Global.SESSION_EMPLOYEE);
		String redirect = "/login.jsp";
		
		if (employee != null) {
			redirect = "/employee/customer";
		} else {
			String paramUser = request.getParameter("user");
			String paramPassword = request.getParameter("password");
			
			EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute(Global.APP_ENTITY_MANAGE_FACTORY);
			UserRepository usuarioR = new UserRepository(emf);
			
			User usuario = usuarioR.findByName(paramUser);
			
			if(usuario != null) {
				
				boolean okLogin = BCrypt.checkpw(paramPassword,usuario.getPassword());
				
				if( okLogin) {
					EmployeeRepository employeeR = new EmployeeRepository(emf); 
					employee = employeeR.findById(usuario.getUserID());
					request.getSession().setAttribute(Global.SESSION_EMPLOYEE, employee);
					redirect="/employee/customer";
				}
				
			}
		}
		response.sendRedirect(request.getServletContext().getContextPath() + redirect);
	}

}
