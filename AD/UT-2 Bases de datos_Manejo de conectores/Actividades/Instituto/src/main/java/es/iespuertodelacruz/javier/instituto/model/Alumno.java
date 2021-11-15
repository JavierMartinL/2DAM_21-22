package es.iespuertodelacruz.javier.instituto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Alumno {

	private String dni;
	private String nombre;
	private String apellidos;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+1")
	Date fechaNacimiento;
	@JsonIgnore
	ArrayList<Matricula> matriculas;
	
	public Alumno() { }
	
	public Alumno(String dni, String nombre, String apellidos, Date fechaNacimiento) {
		this(dni, nombre, apellidos, fechaNacimiento, null);
	}
	
	public Alumno(String dni, String nombre, String apellidos, Date fechaNacimiento, ArrayList<Matricula> matriculas) {
		this.dni = validarDni(dni);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.matriculas = matriculas;
	}

	public String validarDni(String dni) {
		String resultado = null;
		String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";

		if (dni.length() == 9) {
			String letra = dni.substring(8, 9);
			String numero = dni.substring(0, 8);

			int num = Integer.parseInt(numero);

			int resto = num % 23;

			String letraCalculada = cadena.substring(resto, resto + 1);

			if (letra.equalsIgnoreCase(letraCalculada)) {
				resultado = dni.toUpperCase();
			}
		}
		return resultado;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = validarDni(dni);
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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", matriculas=" + matriculas + "]";
	}
}
