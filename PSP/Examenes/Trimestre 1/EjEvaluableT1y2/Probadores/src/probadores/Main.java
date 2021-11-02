/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probadores;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controlador controlador = new Controlador();
        
        Clientes clientes = new Clientes(controlador);
        Probadores probadores = new Probadores(controlador);
        
        clientes.start();
        probadores.start();
        
        
    }
    
}
