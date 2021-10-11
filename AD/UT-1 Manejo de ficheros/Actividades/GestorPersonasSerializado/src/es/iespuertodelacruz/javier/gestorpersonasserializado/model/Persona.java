/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasserializado.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Persona implements Serializable{
    
    private String nombre;
    private String apellido;
    private Dni dni;
    private int edad;

    static ArrayList<Persona> personas = new ArrayList<>();
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = new Dni(dni.substring(0,dni.length() - 1), dni.toUpperCase().charAt(dni.length()-1));
        this.edad = edad;
    }
    
    public String guardarPersona(Persona persona) {
        String error = "";
        if(persona.getDni().isValido()) {
            boolean existe = false;
            for (Persona personaGuardada : personas) {
                String dniGuardado = personaGuardada.getDni().toString();
                String dni = persona.getDni().toString();
                if (dniGuardado.equals(dni)) {
                    existe = true;
                }
            }
            if (!existe) {
                personas.add(persona);
            }
        }
        return error;
    }
    
    public ArrayList<Persona> getAll() {
        return personas;
    }
    
    public void setAll(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad=" + edad + '}';
    }
    
}
