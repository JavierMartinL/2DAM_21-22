package es.iespuertodelacruz.javier.tarea21enero.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class AsientoPutDTO {

	private String asunto;
	private double cuantia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD", timezone = "GMT")
	private Date fecha;
	
	public AsientoPutDTO() { }
	
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
