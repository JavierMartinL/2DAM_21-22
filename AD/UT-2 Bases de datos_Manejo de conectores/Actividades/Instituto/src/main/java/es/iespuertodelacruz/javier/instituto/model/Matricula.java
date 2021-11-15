package es.iespuertodelacruz.javier.instituto.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matricula {
	
	private int idMatricula;
	private Alumno alumno;

	@JsonProperty("año")
	private int year;
	private ArrayList<Asignatura> asignaturas;
	
	public Matricula() { }
	
	public Matricula(int idMatricula, Alumno alumno, int year) {
		this(idMatricula, alumno, year, null);
	}
	
	public Matricula(int idMatricula, Alumno alumno, int year, ArrayList<Asignatura> asignaturas) {
		this.idMatricula = idMatricula;
		this.alumno = alumno;
		this.year = year;
		this.asignaturas = asignaturas;
	}

	public int getIdMatricula() {
		return idMatricula;
	}
	
	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	
	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "Matricula [idmatricula=" + idMatricula + ", alumno=" + alumno + ", year=" + year + ", asignaturas="
				+ asignaturas + "]";
	}
	
}
