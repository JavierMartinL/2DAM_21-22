package es.iespuertodelacruz.javier.tarea21enero.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.iespuertodelacruz.javier.tarea21enero.entity.Asiento;

public class AsientoDTO {

	private int idasiento;
	private String asunto;
	private double cuantia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD", timezone = "GMT")
	private Date fecha;
	
	public AsientoDTO() { }
	
	public AsientoDTO(Asiento asiento) { 
		this.idasiento = asiento.getIdasiento();
		this.asunto = asiento.getAsunto().toUpperCase();
		this.cuantia = asiento.getCuantia();
		this.fecha = new Date(asiento.getFecha().longValue());
	}
	
	public int getIdasiento() {
		return idasiento;
	}

	public void setIdasiento(int idasiento) {
		this.idasiento = idasiento;
	}

	public String getAsunto() {
		return asunto;
	}
	
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	public double getCuantia() {
		return cuantia;
	}
	
	public void setCuantia(double cuantia) {
		this.cuantia = cuantia;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
