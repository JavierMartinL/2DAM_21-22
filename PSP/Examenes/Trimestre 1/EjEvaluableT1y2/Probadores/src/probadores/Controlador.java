/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probadores;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Controlador {
    
    private ArrayList<String> probadores = new ArrayList<>(5);
    
    
    synchronized void acceder(String persona) {
        
        if (probadores.size() < 5) {
            probadores.add(persona);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
    }
    
    synchronized void salir(String persona) {
        
        if (probadores.size() >= 0) {
            probadores.remove(persona);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
    }
    
}
