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
public class Pedido {
    
    private String plato = "";
    volatile int countComida = 0;
    
    public String getPlato() {
        return plato;
    }
    
    public void setPlato(String plato) {
        this.plato = plato;
    }
    
}
