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
public class Cocinero implements Runnable {

    Pedido ordenPedido;

    public Cocinero(Pedido ordenPedido) {
        this.ordenPedido = ordenPedido;
    }
    
    public void hacerPedido() {
        synchronized (ordenPedido) {
            while (ordenPedido.countComida == 0) {                
                try {
                    System.out.println("Cocinero está esperando un pedido a fecha: " + new Date());
                    ordenPedido.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            ordenPedido.setPlato("Arroz a la Cubana " + ordenPedido.countComida);
            ordenPedido.countComida = ordenPedido.countComida - 1;
            Thread.sleep(4000);
            System.out.println("Cocinero tiene el pedido y comienza a hacer el "
                    + "pedido de " + ordenPedido.getPlato() + " a fecha: " + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        while (true) {            
            hacerPedido();
        }
    }
    
}
