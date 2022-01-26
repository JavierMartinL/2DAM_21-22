/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocina;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        Camarero camarero = new Camarero(pedido);
        Thread hiloCamarero = new Thread(camarero, "HiloCamarero");
        hiloCamarero.start();
        
        Cocinero cocinero = new Cocinero(pedido);
        Thread hiloCocinero = new Thread(cocinero, "HiloCocinero");
        hiloCocinero.start();
    }
    
}
