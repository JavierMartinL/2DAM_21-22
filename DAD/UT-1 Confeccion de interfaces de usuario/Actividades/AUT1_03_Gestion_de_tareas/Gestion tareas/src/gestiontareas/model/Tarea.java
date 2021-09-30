/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareas.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Tarea {
    
    private static ArrayList<Tarea> tareas = new ArrayList<Tarea>();
    
    private String actividad;
    private String asignatura;
    private Date dia;
    private boolean terminar;
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Tarea() { }
    
    public Tarea(String actividad, String asignatura, Date dia, boolean terminar) {
        this.actividad = actividad;
        this.asignatura = asignatura;
        this.dia = eliminarTiempo(dia);
        this.terminar = terminar;
        if (!this.actividad.equals("") && !this.asignatura.equals("")) {
            tareas.add(this);
        }
    }
    
    /**
     * Leer todas las actividades y devolver segun la seleccionada
     * @param vencidas boolean (true -> la tarea esta vencida | false -> la tarea sigue activa)
     * @return String con las actividades
     */
    public String mostrar(boolean vencidas) {
        Collections.sort(tareas, (Tarea t1, Tarea t2) -> t1.getDia().compareTo(t2.getDia()));
        Date hoy = eliminarTiempo(new Date());
        String informacion = "";
        for (Tarea tarea : tareas) {
            if (vencidas) {
                if (hoy.after(tarea.dia) || tarea.terminar) {
                    informacion += "- " + tarea + "\n";                
                }
            } else {
                if ((hoy.before(tarea.dia) || hoy.equals(tarea.dia)) && !tarea.terminar) {
                    informacion += "- " + tarea + "\n";                
                }
            }            
        }
        return informacion;
    }
    
    /**
     * Eliminar el tiempo de las fechas
     * @param fecha Date que queremos modificar
     * @return Date sin tiempo
     */
    private Date eliminarTiempo(Date fecha) {
        Calendar horario = Calendar.getInstance();
        horario.setTime(fecha);
        horario.set(Calendar.HOUR_OF_DAY, 0);
        horario.set(Calendar.MINUTE, 0);
        horario.set(Calendar.SECOND, 0);
        horario.set(Calendar.MILLISECOND, 0);
        return horario.getTime();
    }
    
    /**
     * Eliminar una Tarea del ArrayList
     * @param index posición de la tarea dentro del ArrayList
     */
    public void eliminar(int index) {
        tareas.remove(index);
        System.out.println(tareas.size());
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        if (!actividad.equals(""))
            this.actividad = actividad;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        if (!asignatura.equals(""))
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

    public static ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public static void setTareas(ArrayList<Tarea> tareas) {
        Tarea.tareas = tareas;
    }

    @Override
    public String toString() {        
        return actividad + " de " + asignatura + " [" + formatoFecha.format(dia) + ']' + ((terminar) ? " - Terminada" : "");
    }
    
    public void crearTareasBase() {
        new Tarea("Actividad01", "SSG", new Date(121, 8, 22), false);
        new Tarea("Actividad02", "EMR", new Date(121, 8, 23), false);
        new Tarea("Actividad03", "EMR", new Date(121, 8, 24), false);
        new Tarea("Actividad01", "AED", new Date(121, 9, 23), false);
        new Tarea("AUT01_01", "DAD", new Date(121, 9, 24), false);
    }
    
}
