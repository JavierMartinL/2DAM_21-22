package es.iespuertodelacruz.javier.examen2.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.iespuertodelacruz.javier.examen2.entity.Empleado;

public class EmpleadoDTO {

	private int id;
	private String apellidos;
	private String calle;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaContrato;
	private String municipio;
	private String nombre;
	private int numero;
	
	public EmpleadoDTO() { }
	
	public EmpleadoDTO(Empleado empleado) { 
		this.id = empleado.getId();
		this.apellidos = empleado.getApellidos();
		this.calle = empleado.getCalle();
		this.municipio = empleado.getMunicipio();
		this.nombre = empleado.getNombre();
		this.numero = empleado.getNumero();
		if (empleado.getFechaContrato() != null) {
			this.fechaContrato = new Date(empleado.getFechaContrato().longValue());
		} else {
			this.fechaContrato = null;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
