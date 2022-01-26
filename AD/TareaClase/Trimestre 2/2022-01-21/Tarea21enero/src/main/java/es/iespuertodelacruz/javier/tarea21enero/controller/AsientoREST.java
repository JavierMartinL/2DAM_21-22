package es.iespuertodelacruz.javier.tarea21enero.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.javier.tarea21enero.dto.AsientoDTO;
import es.iespuertodelacruz.javier.tarea21enero.dto.AsientoPutDTO;
import es.iespuertodelacruz.javier.tarea21enero.entity.Asiento;
import es.iespuertodelacruz.javier.tarea21enero.service.AsientoService;

@RestController
@RequestMapping("/api/asientos")
public class AsientoREST {

	@Autowired
	private AsientoService asientoService;
	
	@GetMapping
	public List<AsientoDTO> getAll(@RequestParam(required=false, name="asuntoincluye") String asuntoincluye) {
		ArrayList<AsientoDTO> asientos = new ArrayList<AsientoDTO>();
		
		if (asuntoincluye != null && !asuntoincluye.trim().equals("")) {
			asientoService.findByAsunto("%" + asuntoincluye + "%")
			.forEach(a -> asientos.add(new AsientoDTO((Asiento)a)));
		} else {
			asientoService.findAll()
			.forEach(a -> asientos.add(new AsientoDTO((Asiento)a)));
		}
		
		return asientos;
		
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody AsientoPutDTO asientoPut) {
		try {
			Asiento asiento = new Asiento();
			
			asiento.setAsunto(asientoPut.getAsunto().toUpperCase());
			asiento.setCuantia(asientoPut.getCuantia());
			asiento.setFecha(BigInteger.valueOf(asientoPut.getFecha().getTime()));
			
			Asiento save = asientoService.save(asiento);
			return ResponseEntity.status(HttpStatus.CREATED).body(new AsientoDTO(save));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el Asiento");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(
			@PathVariable Integer id,
			@RequestBody AsientoDTO asientoDTO
			) {
		Optional<Asiento> optAsiento = asientoService.findById(id);
		if (optAsiento.isPresent()) {
			try {
				Asiento asiento = new Asiento();
				
				asiento.setIdasiento(id);
				asiento.setAsunto(asientoDTO.getAsunto().toUpperCase());
				asiento.setCuantia(asientoDTO.getCuantia());
				asiento.setFecha(BigInteger.valueOf(asientoDTO.getFecha().getTime()));
				
				Asiento update = asientoService.save(asiento);
				
				return ResponseEntity.ok(new AsientoDTO(update));
				
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar el Asiento");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id introducido no corresponde a ningun Asiento");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Optional<Asiento> optAsiento = asientoService.findById(id);
		
		if (optAsiento.isPresent()) {
			try {
				asientoService.deleteById(id);
				return ResponseEntity.ok("Asiento borrado");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el Asiento");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id introducido no corresponde a ningun Asiento");
		}
		
	}
	
}
