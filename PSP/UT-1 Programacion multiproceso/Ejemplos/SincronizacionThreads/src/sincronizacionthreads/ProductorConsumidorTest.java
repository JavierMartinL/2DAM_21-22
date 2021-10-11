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
public class ProductorConsumidorTest {
    
    // Cambiar de proyecto todo lo que esta en este paquete
    
    public static void main(String[] args) {
        Contenedor c = new Contenedor();
        Productor produce = new Productor(c);
        Consumidor consume = new Consumidor(c);
        
        produce.start();
        consume.start();
    }
    
}
