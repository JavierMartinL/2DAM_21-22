/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorBuffer controlador = new ControladorBuffer();
        Productor productor = new Productor(controlador);
        Consumidor consumidor = new Consumidor(controlador);
        
        productor.start();
        consumidor.start();
        
    }
    
}
