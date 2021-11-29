package es.iespuertodelacruz.javier.javierexamen1.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Empleado {

	private Integer id;
	private String nombre;
	private String apellidos;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+1")
	private Date fecha_contrato;
	
	private Integer numero;
	private String calle;
	private String municipio;
	private Empleado jefe;
	
	public Empleado() { }

	public Empleado(Integer id, String nombre, String apellidos, Date fecha_contrato, Integer numero, String calle,
			String municipio, Empleado jefe) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_contrato = fecha_contrato;
		this.numero = numero;
		this.calle = calle;
		this.municipio = municipio;
		this.jefe = jefe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_contrato() {
		return fecha_contrato;
	}

	public void setFecha_contrato(Date fecha_contrato) {
		this.fecha_contrato = fecha_contrato;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Empleado getJefe() {
		return jefe;
	}

	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_contrato="
				+ fecha_contrato + ", numero=" + numero + ", calle=" + calle + ", municipio=" + municipio + ", jefe="
				+ jefe + "]";
	}
	
}
