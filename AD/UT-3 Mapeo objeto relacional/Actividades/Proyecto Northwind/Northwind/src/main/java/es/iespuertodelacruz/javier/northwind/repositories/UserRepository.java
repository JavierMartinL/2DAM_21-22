package es.iespuertodelacruz.javier.northwind.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.javier.northwind.entities.User;

public class UserRepository implements JPACRUD<User, Integer> {
	
	private EntityManagerFactory emf;
	
	public UserRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<User> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<User> lista = em.createNamedQuery("User.findAll", User.class).
				getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public User findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		em.close();
		return user;
	}
	
	public User findByName(String name) {
		EntityManager em = emf.createEntityManager();
		User user = null;
		String query = "SELECT u FROM User u WHERE u.userName = :name";
		try {
			em.getTransaction().begin();
			
			user = em.createQuery(query, User.class)
					.setParameter("name", name)
					.getSingleResult();
		
			em.getTransaction().commit();
		} catch (Exception e) { 
			em.getTransaction().rollback();
		}
		em.close();
		return user;
	}

	@Override
	public User save(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
