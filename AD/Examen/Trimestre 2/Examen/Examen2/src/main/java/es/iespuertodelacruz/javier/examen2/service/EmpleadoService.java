package es.iespuertodelacruz.javier.examen2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.javier.examen2.entity.Empleado;
import es.iespuertodelacruz.javier.examen2.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements GenericService<Empleado, Integer> {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Empleado> findAll(Pageable pageable) {
		return empleadoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Empleado> findById(Integer id) {
		return empleadoRepository.findById(id);
	}

	@Override
	@Transactional
	public Empleado save(Empleado objeto) {
		return empleadoRepository.save(objeto);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		empleadoRepository.deleteById(id);
	}

}
