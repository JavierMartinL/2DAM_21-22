/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.dao;

import java.util.List;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public interface ICrud<T, E> {
    
    List<T> findAll();
    T findById(E id);
    T save(T object);
    boolean update(T object);
    boolean delete(E id);
    
}
