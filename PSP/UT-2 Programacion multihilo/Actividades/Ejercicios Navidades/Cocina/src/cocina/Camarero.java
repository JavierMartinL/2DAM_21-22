/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocina;

import java.util.Date;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Camarero implements Runnable {

    Pedido ordenarPedido;

    public Camarero(Pedido ordenarPedido) {
        this.ordenarPedido = ordenarPedido;
    }
    
    public void crearComanda() {
        synchronized (ordenarPedido) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            ordenarPedido.countComida += 1;
            ordenarPedido.setPlato("Arroz a la Cubana " + ordenarPedido.countComida);
            System.out.println(
                    "Camarero anota comanda y lo notifica al cocienero "
                    + ordenarPedido.getPlato() + " a fecha  " + new Date() 
                    + " y notifica el cocinero.");
            ordenarPedido.notifyAll();
        }
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int espera = ((int) Math.random() * 1000) + 1000;
                Thread.sleep(espera);
                crearComanda();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
