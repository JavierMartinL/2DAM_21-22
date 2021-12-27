package es.iespuertodelacruz.javier.northwind.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.javier.northwind.entities.Customer;
import es.iespuertodelacruz.javier.northwind.entities.Order;
import es.iespuertodelacruz.javier.northwind.entities.OrderDetail;
import es.iespuertodelacruz.javier.northwind.entities.Product;

public class OrderRepository implements JPACRUD<Order, Integer> {

	private EntityManagerFactory emf;

	public OrderRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Order> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Order> lista = em.createNamedQuery("Order.findAll", Order.class)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}
	
	public List<Order> findByCustomer(String customerId) {
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT o FROM Order o WHERE o.customer = :customerId";
		em.getTransaction().begin();
		List<Order> lista = em.createQuery(sql, Order.class)
				.setParameter("customerId", em.find(Customer.class, customerId))
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Order findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Order order = em.find(Order.class, id);
		em.getTransaction().commit();
		em.close();
		return order;
	}
	
	public void findByProducto(Integer productId) {
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT o FROM Order o WHERE o.orderID in "
				+ "(SELECT od.order FROM OrderDetail od WHERE od.product = :productoId)";
		em.getTransaction().begin();
		em.createQuery(sql, Order.class)
				.setParameter("productoId", em.find(Product.class, productId))
				.getResultList()
				.stream()
				.forEach(System.out::println);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void findByProductoJoin(Integer productId) {
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT o FROM Order o "
				+ "right join OrderDetail od "
				+ "on o.orderID = od.order "
				+ "WHERE od.product = :productoId";
		em.getTransaction().begin();
		System.out.println("HOLA");
		em.createQuery(sql, Order.class)
				.setParameter("productoId", em.find(Product.class, productId))
				.getResultList()
				.stream()
				.forEach(System.out::println);
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Order save(Order obj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		
		for (OrderDetail orderDetail: obj.getOrderDetails()) {
			orderDetail.setOrder(obj);
			em.persist(orderDetail);
		}
		
		em.getTransaction().commit();
		em.close();
		return null;
	}

	@Override
	public Order update(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
