package es.iespuertodelacruz.javier.northwind.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.javier.northwind.entities.Customer;

public class CustomerRepository implements JPACRUD<Customer, String> {

	private EntityManagerFactory emf;
	
	public CustomerRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Customer> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Customer> lista = em.createNamedQuery("Customer.findAll", Customer.class)
			.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Customer findById(String id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, id);
		em.getTransaction().commit();
		em.close();
		return customer;
	}

	@Override
	public Customer save(Customer obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
