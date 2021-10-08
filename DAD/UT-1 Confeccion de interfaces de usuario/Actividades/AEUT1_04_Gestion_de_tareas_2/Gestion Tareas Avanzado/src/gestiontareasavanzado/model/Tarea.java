/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Tarea implements Serializable {
    
    private String actividad;
    private String asignatura;
    private Date dia;
    private boolean terminar;
    
    static ArrayList<Tarea> tareas = new ArrayList<>();

    public Tarea() { }

    public Tarea(String actividad, String asignatura, Date dia, boolean terminar) {
        this.actividad = actividad;
        this.asignatura = asignatura;
        this.dia = eliminarTiempo(dia);
        this.terminar = terminar;
        
        if (!actividad.equals("") && !asignatura.equals("")) {
            tareas.add(this);
        }
        
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
     * Leer todas las actividades y devolver segun la seleccionada
     * @param terminadas boolean (true -> la tarea esta vencida | false -> la tarea sigue activa)
     * @return String con las actividades
     */
    public ArrayList<Tarea> mostrar(boolean terminadas) {
        // Ordenar el ArrayList principal
        Collections.sort(tareas, (Tarea t1, Tarea t2) -> t1.getDia().compareTo(t2.getDia()));
        Date hoy = eliminarTiempo(new Date());
        
        // ArrayList que vamos a devolver
        ArrayList<Tarea> mostrarTarea = new ArrayList<>();
        
        // Controlamos las tareas
        for (Tarea tarea : tareas) {
            
            if (terminadas) {
                if (hoy.after(tarea.dia) || tarea.terminar) {
                    mostrarTarea.add(tarea);
                }
            } else {
                if ((hoy.before(tarea.dia) || hoy.equals(tarea.dia)) && !tarea.terminar) {
                    mostrarTarea.add(tarea);
                }
            }            
        }
        
        return mostrarTarea;
    }
    
    /**
     * Método que finaliza las tareas
     * @param indexs Posiciones de las tareas en el ArrayList
     */
    public void finalizar(ArrayList<Integer> indexs) {
        ArrayList<Tarea> tareasActivas = mostrar(false);
        
        for (Integer index : indexs) {
            Tarea actTarea = tareasActivas.get(index);
            actTarea.setTerminar(true);
        }
    }
    
    public void modificar(int index, String actividad, String asignatura, Date dia) {
        if (!actividad.equals("") && !asignatura.equals("")) {
            ArrayList<Tarea> tareasActivas = mostrar(false);
            
            Tarea actTarea = tareasActivas.get(index);
            
            actTarea.setActividad(actividad);
            actTarea.setAsignatura(asignatura);
            actTarea.setDia(dia);
        }        
    }
    
    public void eliminar(int index) {
        ArrayList<Tarea> tareasActivas = mostrar(false);
        Tarea tareaAct = tareasActivas.get(index);
        
        if (tareas.contains(tareaAct)) {
            tareas.remove(tareas.indexOf(tareaAct));
        };
    }
    
    public Tarea getTarea(int index) {
        return mostrar(false).get(index);
    }
    
    /**
     * Devolver todas las tareas
     * @return lista de tareas
     */
    public ArrayList<Tarea> getAll() {
        Collections.sort(tareas, (Tarea t1, Tarea t2) -> t1.getDia().compareTo(t2.getDia()));
        return tareas;
    }
    
    /**
     * Cargar todas las tareas en el ArrayList
     * @param tareasGuardadas lista de tareas
     */
    public void cargarTareas(ArrayList<Tarea> tareasGuardadas) {
        tareas = tareasGuardadas;
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

    @Override
    public String toString() {
        return "Tarea{" + "actividad=" + actividad + ", asignatura=" + asignatura + ", dia=" + dia + ", terminar=" + terminar + '}';
    }
    
}
