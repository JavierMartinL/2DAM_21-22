package es.iespuertodelacruz.javier.tarea21enero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iespuertodelacruz.javier.tarea21enero.entity.Asiento;

public interface AsientoRepository extends JpaRepository<Asiento, Integer> {
	
	@Query("SELECT a FROM Asiento a WHERE a.asunto LIKE :asunto")
	List<Asiento> findByAsunto(@Param("asunto") String strAsunto);

}
