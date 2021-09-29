/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareas.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Tarea {
    
    static ArrayList<Tarea> tareas = new ArrayList<Tarea>();
    
    private String actividad;
    private String asignatura;
    private Date dia;
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Tarea() {
        new Tarea("Actividad01", "SSG", new Date(2022, 9, 22));
        new Tarea("Actividad02", "EMR", new Date(2022, 9, 23));
        new Tarea("Actividad03", "EMR", new Date(2022, 9, 24));
        new Tarea("Actividad01", "AED", new Date(2022, 9, 23));
        new Tarea("AUT01_01", "DAD", new Date(2022, 9, 24));
    }
    
    public Tarea(String actividad, String asignatura, Date dia) {
        this.actividad = actividad;
        this.asignatura = asignatura;
        this.dia = eliminarTiempo(dia);
        tareas.add(this);
    }
    
    public String mostrar(boolean vencidas) {
        Collections.sort(tareas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea t1, Tarea t2) {
                return t1.getDia().compareTo(t2.getDia());
            }            
        });
        Date hoy = eliminarTiempo(new Date());
        String informacion = "";
        for (Tarea tarea : tareas) {
            if (vencidas) {
                if (hoy.after(tarea.dia)) {
                    informacion += "- " + tarea + "\n";                
                }
            } else {
                if (hoy.before(tarea.dia) || hoy.equals(tarea.dia)) {
                    informacion += "- " + tarea + "\n";                
                }
            }            
        }
        return informacion;
    }
    
    private Date eliminarTiempo(Date fecha) {
        Calendar horario = Calendar.getInstance();
        horario.setTime(fecha);
        horario.set(Calendar.HOUR_OF_DAY, 0);
        horario.set(Calendar.MINUTE, 0);
        horario.set(Calendar.SECOND, 0);
        horario.set(Calendar.MILLISECOND, 0);
        return horario.getTime();
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

    @Override
    public String toString() {        
        return actividad + " de " + asignatura + " [" + formatoFecha.format(dia) + ']';
    }
    
}
