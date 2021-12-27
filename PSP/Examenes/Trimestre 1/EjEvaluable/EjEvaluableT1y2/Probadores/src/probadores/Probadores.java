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
public class Probadores extends Thread {
    
    private Controlador controlador;
    
    public Probadores(Controlador controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void run() {
        
        for (int i = 1; i <= 20; i++) {
            controlador.salir("Persona" + i);
            System.out.println("La Persona " + i + " salio del probador");
            try {
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { }
        }
        
    }
    
}
