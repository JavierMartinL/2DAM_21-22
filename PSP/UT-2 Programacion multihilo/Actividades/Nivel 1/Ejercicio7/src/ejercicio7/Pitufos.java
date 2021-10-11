/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Pitufos extends Thread{
    
    private String nombre;

    public Pitufos(String nombre) {
        this.nombre = nombre;
    }
    
    public void run() {
        boolean panComido = false;
        int contador = 0;
        while (!panComido) {
            try {            
                Thread.sleep((long) Math.floor(Math.random() * (5000 - 500) + 500));
            } catch (InterruptedException ex) { }
            contador++;
            System.out.println(nombre + " se come el " + contador + "º pan con queso");
            
            if (contador == 3) {
                panComido = true;
            }
        }
        System.out.println("Termino: " + nombre);
    } 
    
}
