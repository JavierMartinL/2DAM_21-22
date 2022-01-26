package es.iespuertodelacruz.javier.tarea21enero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.javier.tarea21enero.entity.Asiento;
import es.iespuertodelacruz.javier.tarea21enero.repository.AsientoRepository;

@Service
public class AsientoService implements GenericService<Asiento, Integer> {

	@Autowired
	AsientoRepository asientoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Asiento> findAll() {
		return asientoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Asiento> findAll(Pageable pageable) {
		return asientoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Asiento> findById(Integer id) {
		return asientoRepository.findById(id);
	}
	
	@Transactional(readOnly=true)
	public List<Asiento> findByAsunto(String asunto) {
		return asientoRepository.findByAsunto(asunto);
	}

	@Override
	@Transactional
	public Asiento save(Asiento objeto) {
		return asientoRepository.save(objeto);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		asientoRepository.deleteById(id);
	}

}
