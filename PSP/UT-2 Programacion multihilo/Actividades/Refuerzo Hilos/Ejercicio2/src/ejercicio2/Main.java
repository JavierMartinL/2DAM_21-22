/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controlador controlador = new Controlador();
        
        Thread hilo1 = new Thread(controlador);
        Thread hilo2 = new Thread(controlador);
        Thread hilo3 = new Thread(controlador);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
    }
    
}
