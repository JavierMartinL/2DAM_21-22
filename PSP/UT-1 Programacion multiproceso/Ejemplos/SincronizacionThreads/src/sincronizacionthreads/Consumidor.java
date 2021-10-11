package sincronizacionthreads;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Consumidor extends Thread {
    private  Contenedor contenedor;
    
    public Consumidor (Contenedor c) {
        contenedor = c;
    }
    
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = contenedor.get();
            System.out.println("Consumidor. get: " + value);
        }
    }
}
