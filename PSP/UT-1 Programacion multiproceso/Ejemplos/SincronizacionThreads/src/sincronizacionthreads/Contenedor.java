/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sincronizacionthreads;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Contenedor {
    
    private int dato;
    private boolean hayDato = false;
    
    public synchronized int get() {
        while (hayDato == false) {
            try {
                // espera a que el productor coloque un valor
                wait();
            } catch (InterruptedException e) { }                        
        }
        hayDato = false;
        notifyAll();
        return dato;
    }
    
    public synchronized void put(int valor) {
        while (hayDato == true) {
            try {
                // espera a que se consuma el dato
                wait();
            } catch (InterruptedException e) { }
        }
        dato = valor;
        hayDato = true;
        // notificar que ya hay dato
        notifyAll();
    }
}
