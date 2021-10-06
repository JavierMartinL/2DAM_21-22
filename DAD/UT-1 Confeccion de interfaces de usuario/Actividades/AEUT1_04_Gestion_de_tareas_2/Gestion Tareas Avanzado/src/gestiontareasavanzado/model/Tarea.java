/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Tarea {
    
    private String actividad;
    private String asignatura;
    private Date dia;
    private boolean terminar;
    
    static ArrayList<Tarea> tareas = new ArrayList<>();

    public Tarea() {
    }

    public Tarea(String actividad, String asignatura, Date dia, boolean terminar) {
        this.actividad = actividad;
        this.asignatura = asignatura;
        this.dia = dia;
        this.terminar = terminar;
        
        if (!actividad.equals("") && !asignatura.equals("")) {
            tareas.add(this);
        }
        
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public boolean isTerminar() {
        return terminar;
    }

    public void setTerminar(boolean terminar) {
        this.terminar = terminar;
    }
    
}
