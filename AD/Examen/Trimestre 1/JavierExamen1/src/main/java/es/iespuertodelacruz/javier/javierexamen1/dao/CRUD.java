package es.iespuertodelacruz.javier.javierexamen1.dao;

import java.util.List;

public interface CRUD <T, E> {
	
	List<T> findAll();
	
	T findById(E id);
	
	T save(T obj);
	
	boolean update(T obj);
	
	boolean delete(E id);
	
}
