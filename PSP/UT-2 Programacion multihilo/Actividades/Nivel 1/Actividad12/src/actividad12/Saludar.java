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
public class Saludar {
    
    synchronized void saludarProfe(String alumno) {
        try {
            wait();
            System.out.println(alumno + " \"Buenos dias Profesor\"");
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    
    synchronized void responderAlumno() {
        System.out.println("\"Buenos dias\"");
        notifyAll();
    }
}
