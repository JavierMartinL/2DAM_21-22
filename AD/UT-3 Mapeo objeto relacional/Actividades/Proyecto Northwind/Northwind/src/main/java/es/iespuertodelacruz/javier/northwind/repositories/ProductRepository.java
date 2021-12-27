package es.iespuertodelacruz.javier.northwind.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.javier.northwind.entities.Product;

public class ProductRepository implements JPACRUD<Product, Integer> {

	private EntityManagerFactory emf;

	public ProductRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Product> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Product> lista = em.createNamedQuery("Product.findAll", Product.class)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Product findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Product product = em.find(Product.class, id);
		em.getTransaction().commit();
		em.close();
		return product;
	}

	@Override
	public Product save(Product obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
