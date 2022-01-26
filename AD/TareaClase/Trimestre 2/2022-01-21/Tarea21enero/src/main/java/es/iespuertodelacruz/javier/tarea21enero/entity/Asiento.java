package es.iespuertodelacruz.javier.tarea21enero.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the asientos database table.
 * 
 */
@Entity
@Table(name="asientos")
@NamedQuery(name="Asiento.findAll", query="SELECT a FROM Asiento a")
public class Asiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idasiento;

	private String asunto;

	private double cuantia;

	private BigInteger fecha;

	public Asiento() {
	}

	public int getIdasiento() {
		return this.idasiento;
	}

	public void setIdasiento(int idasiento) {
		this.idasiento = idasiento;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public double getCuantia() {
		return this.cuantia;
	}

	public void setCuantia(double cuantia) {
		this.cuantia = cuantia;
	}

	public BigInteger getFecha() {
		return this.fecha;
	}

	public void setFecha(BigInteger fecha) {
		this.fecha = fecha;
	}

}