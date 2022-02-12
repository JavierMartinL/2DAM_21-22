package es.iespuertodelacruz.javier.examen2.controller;

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
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.javier.examen2.dto.EmpleadoDTO;
import es.iespuertodelacruz.javier.examen2.entity.Empleado;
import es.iespuertodelacruz.javier.examen2.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRest {

	@Autowired EmpleadoService empleadoService;
	
	@GetMapping
	public List<EmpleadoDTO> getAll() {
		ArrayList<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		empleadoService.findAll().forEach(e -> empleados.add(new EmpleadoDTO(e)));
		return empleados;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		Optional<Empleado> optEmpleado = empleadoService.findById(id);
		if (optEmpleado.isPresent())
			return ResponseEntity.ok().body(new EmpleadoDTO(optEmpleado.get()));
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody EmpleadoDTO empleadoDTO) {
		try {
			Optional<Empleado> optEmpleado = empleadoService.findById(empleadoDTO.getId());
			if (!optEmpleado.isPresent()) {
				Empleado empleado = new Empleado();
				empleado.setId(empleadoDTO.getId());
				empleado.setApellidos(empleadoDTO.getApellidos());
				empleado.setCalle(empleadoDTO.getCalle());
				empleado.setMunicipio(empleadoDTO.getMunicipio());
				empleado.setNombre(empleadoDTO.getNombre());
				empleado.setNumero(empleadoDTO.getNumero());
				
				if (empleadoDTO.getFechaContrato() != null)
					empleado.setFechaContrato(BigInteger.valueOf(empleadoDTO.getFechaContrato().getTime()));
				
				Empleado save = empleadoService.save(empleado);
				return ResponseEntity.status(HttpStatus.CREATED).body(new EmpleadoDTO(save));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Existe un Empleado con este ID");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el Empleado");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(
			@PathVariable int id,
			@RequestBody EmpleadoDTO empleadoDTO
			) {
		Optional<Empleado> optEmpleado = empleadoService.findById(id);
		if (optEmpleado.isPresent()) {
			Empleado empleado = new Empleado();
			empleado.setId(id);
			empleado.setApellidos(empleadoDTO.getApellidos());
			empleado.setCalle(empleadoDTO.getCalle());
			empleado.setMunicipio(empleadoDTO.getMunicipio());
			empleado.setNombre(empleadoDTO.getNombre());
			empleado.setNumero(empleadoDTO.getNumero());
			
			if (empleadoDTO.getFechaContrato() != null)
				empleado.setFechaContrato(BigInteger.valueOf(empleadoDTO.getFechaContrato().getTime()));
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falta la fecha de contrato");
			
			try {
				Empleado save = empleadoService.save(empleado);
				return ResponseEntity.ok(new EmpleadoDTO(save));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al modificar el Empleado");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		Optional<Empleado> optEmpleado = empleadoService.findById(id);
		if (optEmpleado.isPresent()) {
			try {
				empleadoService.deleteById(id);
				return ResponseEntity.ok("Empleado borrado");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el Empleado");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
}
