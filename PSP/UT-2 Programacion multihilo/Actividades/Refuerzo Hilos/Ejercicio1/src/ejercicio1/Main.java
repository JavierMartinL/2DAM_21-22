/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contador contador = new Contador();
        
        Thread hilo1 = new Thread(contador);
        Thread hilo2 = new Thread(contador);
        
        hilo1.start();
        hilo2.start();
    }
    
}
