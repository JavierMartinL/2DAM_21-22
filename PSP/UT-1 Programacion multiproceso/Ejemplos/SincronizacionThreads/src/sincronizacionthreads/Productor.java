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
public class Productor extends Thread{
    private Contenedor contenedor;
    
    public Productor (Contenedor c) {
        contenedor = c;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            contenedor.put(i);
            System.out.println("Productor. put: " + i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}
