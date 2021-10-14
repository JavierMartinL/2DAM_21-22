/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Alumno extends Thread{
    
    String nombre;
    Saludar saludo;
    boolean respuestaProfesor;

    public Alumno(String nombre, Saludar saludo, boolean respuestaProfesor) {
        this.nombre = nombre;
        this.saludo = saludo;
        this.respuestaProfesor = respuestaProfesor;
    }
        
    public void run(){
        System.out.println(" ( " + nombre + " llega a clase ) ");
        if(respuestaProfesor) {
            saludo.responderAlumno();
        } else {
            saludo.saludarProfe(nombre);
        }
    } 
}
