package es.iespuertodelacruz.javier.northwind.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.javier.northwind.entities.Employee;

public class EmployeeRepository implements JPACRUD<Employee, Integer> {

	private EntityManagerFactory emf;
	
	public EmployeeRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}
	@Override
	public List<Employee> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Employee> lista = em.createNamedQuery("Employee.findAll", Employee.class)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Employee findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, id);
		em.getTransaction().commit();
		em.close();
		return employee;
	}

	@Override
	public Employee save(Employee obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
