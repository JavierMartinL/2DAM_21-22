package es.iespuertodelacruz.javier.northwind.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.javier.northwind.entities.Order;
import es.iespuertodelacruz.javier.northwind.entities.OrderDetail;

public class OrderDetailRepository implements JPACRUD<OrderDetail, Integer> {

	private EntityManagerFactory emf;

	public OrderDetailRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<OrderDetail> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<OrderDetail> lista = em.createNamedQuery("OrderDetail.findAll", OrderDetail.class)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}
	
	public List<OrderDetail> findByOrder(Integer orderId) {
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT o FROM OrderDetail o WHERE o.order = :orderId";
		em.getTransaction().begin();
		List<OrderDetail> lista = em.createQuery(sql, OrderDetail.class)
				.setParameter("orderId", em.find(Order.class, orderId))
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public OrderDetail findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		OrderDetail orderDetail = em.find(OrderDetail.class, id);
		em.getTransaction().commit();
		em.close();
		return orderDetail;
	}

	@Override
	public OrderDetail save(OrderDetail obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail update(OrderDetail obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
