package es.iespuertodelacruz.javier.northwind.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.javier.northwind.entities.Customer;
import es.iespuertodelacruz.javier.northwind.entities.Employee;
import es.iespuertodelacruz.javier.northwind.entities.Order;
import es.iespuertodelacruz.javier.northwind.entities.OrderDetail;
import es.iespuertodelacruz.javier.northwind.entities.Product;
import es.iespuertodelacruz.javier.northwind.repositories.OrderDetailRepository;
import es.iespuertodelacruz.javier.northwind.repositories.OrderRepository;
import es.iespuertodelacruz.javier.northwind.repositories.ProductRepository;
import es.iespuertodelacruz.javier.northwind.repositories.ShipperRepository;
import es.iespuertodelacruz.javier.northwind.utils.Global;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet({"/employee/Order", "/employee/order"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute(Global.APP_ENTITY_MANAGE_FACTORY);
		Customer customer = (Customer) request.getSession().getAttribute(Global.SESSION_CUSTOMER);
		
		OrderRepository orderR = new OrderRepository(emf);
		OrderDetailRepository orderDetailR = new OrderDetailRepository(emf);
		ProductRepository productRepository = new ProductRepository(emf);
		String strOrderId = request.getParameter("orderId");
		String strNewOrder = request.getParameter("newOrder");
		
		if (strOrderId != null && !strOrderId.trim().isEmpty()) {
			try {
				Integer orderId = Integer.parseInt(strOrderId);
				Order order = orderR.findById(orderId);
				
				if (order != null) {
					List<OrderDetail> orderDetails = orderDetailR.findByOrder(orderId);
					request.getSession().setAttribute(Global.SESSION_ORDER, order);
					request.getSession().setAttribute(Global.SESSION_DETAILS_ORDER, orderDetails);
					response.sendRedirect(request.getServletContext().getContextPath() + "/employee/order.jsp");
				} else {
					response.sendRedirect(request.getServletContext().getContextPath() + "/employee/customer");
				}
			} catch (Exception e) {}
		} else if (strNewOrder != null && !strNewOrder.trim().isEmpty() ) {
			List<Product> productos = productRepository.findAll();
			request.getSession().setAttribute(Global.SESSION_LIST_PRODUCT, productos);
			response.sendRedirect(request.getServletContext().getContextPath() + "/employee/newOrder.jsp");
		} else {
			response.sendRedirect(request.getServletContext().getContextPath() + "/employee/customer");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute(Global.APP_ENTITY_MANAGE_FACTORY);
		ArrayList<OrderDetail> nuevoPedido = (ArrayList<OrderDetail>) request.getSession().getAttribute(Global.SESSION_NEW_DETAILS_ORDER);
		String action = request.getParameter("submit");
		
		if (action != null && !action.trim().isEmpty()) {
			if (action.equals("Agregar")) {
				ProductRepository productR = new ProductRepository(emf);
				
				if (nuevoPedido == null) {
					nuevoPedido = new ArrayList<OrderDetail>();
				} 
				
				int id = Integer.parseInt(request.getParameter("productId"));
				int cantidad = 0;
				try {
					cantidad = Integer.parseInt(request.getParameter("cantidad"));
				} catch (Exception e) {}
				
				Product product = productR.findById(id);
				
				if (product != null) {
					
					OrderDetail orderDetail = null;
					int pos = 0;
					
					for (int i= 0; i < nuevoPedido.size(); i++) {
						if (nuevoPedido.get(i).getProduct().getProductID() == id) {
							orderDetail = (OrderDetail) nuevoPedido.get(i);
							pos = i;
						}
					}
					
					if (orderDetail == null) {
						orderDetail = new OrderDetail();
						orderDetail.setProduct(product);
						orderDetail.setUnitPrice(product.getUnitPrice());
						orderDetail.setQuantity(cantidad);
						orderDetail.setDiscount(0);
						nuevoPedido.add(orderDetail);
					} else {
						nuevoPedido.get(pos).setQuantity(orderDetail.getQuantity() + cantidad);
					}
					
					if (nuevoPedido.get(pos).getQuantity() <= 0) {
						nuevoPedido.remove(orderDetail);
					}
					
				}				
				request.getSession().setAttribute(Global.SESSION_NEW_DETAILS_ORDER, nuevoPedido);
				response.sendRedirect(request.getServletContext().getContextPath() + "/employee/newOrder.jsp");
			} else if (action.equals("Realizar Pedido")) {
				Customer customer = (Customer) request.getSession().getAttribute(Global.SESSION_CUSTOMER);
				Employee employee = (Employee) request.getSession().getAttribute(Global.SESSION_EMPLOYEE);
				if (nuevoPedido != null) {
					OrderRepository orderR = new OrderRepository(emf);
					ShipperRepository shipperR = new ShipperRepository(emf);
					Order order = new Order();
					order.setCustomer(customer);
					order.setEmployee(employee);
					order.setOrderDate(new Date());
					order.setRequiredDate(new Date());
					order.setShipper(shipperR.findById(3));
					order.setFreight(12.1);
					order.setShipName("Nuevo Pedido");
					order.setShipAddress(customer.getAddress());
					order.setShipCity(customer.getCity());
					order.setShipRegion(customer.getRegion());
					order.setShipPostalCode(customer.getPostalCode());
					order.setShipCountry(customer.getCountry());
					order.setOrderDetails(nuevoPedido);
					
					orderR.save(order);
				}
				response.sendRedirect(request.getServletContext().getContextPath() + "/employee/customer?customerId=" + customer.getCustomerID());
			}
		} else {
			response.sendRedirect(request.getServletContext().getContextPath() + "/employee/customer");
		}
	}

}
