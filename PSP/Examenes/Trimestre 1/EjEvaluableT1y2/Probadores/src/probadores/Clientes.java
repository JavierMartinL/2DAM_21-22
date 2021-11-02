/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probadores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Clientes extends Thread {
    
    private Controlador controlador;
    
    public Clientes(Controlador controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void run() {
        
        for (int i = 1; i <= 20; i++) {
            controlador.acceder("Persona" + i);
            System.out.println("Persona " + i + " accedio");
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) { }
        }
        
    }
}
