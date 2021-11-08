/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Impar extends Thread{
    
    Contador c;
    int cantidad;
    
    public Impar(Contador c, int cantidad) {
        this.c = c;
        this.cantidad = cantidad;
    }
    
    public void run() {
    
        while (c.numero < cantidad) {
            try {
                c.esperarImpar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Impar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
