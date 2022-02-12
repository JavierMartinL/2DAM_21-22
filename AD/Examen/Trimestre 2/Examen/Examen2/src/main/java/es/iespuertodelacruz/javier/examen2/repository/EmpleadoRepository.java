package es.iespuertodelacruz.javier.examen2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.javier.examen2.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
