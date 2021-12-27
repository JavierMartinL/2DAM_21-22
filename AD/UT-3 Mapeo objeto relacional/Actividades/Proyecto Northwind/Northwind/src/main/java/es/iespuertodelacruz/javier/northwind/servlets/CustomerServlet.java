package es.iespuertodelacruz.javier.northwind.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.javier.northwind.entities.Customer;
import es.iespuertodelacruz.javier.northwind.entities.Order;
import es.iespuertodelacruz.javier.northwind.entities.OrderDetail;
import es.iespuertodelacruz.javier.northwind.repositories.CustomerRepository;
import es.iespuertodelacruz.javier.northwind.repositories.OrderDetailRepository;
import es.iespuertodelacruz.javier.northwind.repositories.OrderRepository;
import es.iespuertodelacruz.javier.northwind.utils.Global;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet({ "/employee/Customer", "/employee/customer" })
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute(Global.APP_ENTITY_MANAGE_FACTORY);
		request.getSession().setAttribute(Global.SESSION_NEW_DETAILS_ORDER, null);
		CustomerRepository customerR = new CustomerRepository(emf);
		OrderRepository orderR = new OrderRepository(emf);
		
		String customerId = request.getParameter("customerId");
		
		if (customerId != null && !customerId.trim().isEmpty()) {
			Customer customer = customerR.findById(customerId);
			
			if (customer != null) {
				List<Order> orders = orderR.findByCustomer(customerId);
				request.getSession().setAttribute(Global.SESSION_CUSTOMER, customer);
				request.getSession().setAttribute(Global.SESSION_ORDERS_CUSTOMER, orders);
				response.sendRedirect(request.getServletContext().getContextPath() + "/employee/customer.jsp");
			} else {
				response.sendRedirect(request.getServletContext().getContextPath() + "/employee/home.jsp");
			}
		} else {
			request.getSession().setAttribute(Global.SESSION_LIST_CUSTOMER, customerR.findAll());
			response.sendRedirect(request.getServletContext().getContextPath() + "/employee/home.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
