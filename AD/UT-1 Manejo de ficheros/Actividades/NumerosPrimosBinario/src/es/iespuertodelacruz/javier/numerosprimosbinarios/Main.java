/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.numerosprimosbinarios;

import es.iespuertodelacruz.javier.numerosprimosbinarios.modelo.GestorFicherosBinarios;
import es.iespuertodelacruz.javier.numerosprimosbinarios.modelo.NumerosPrimos;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NumerosPrimos n = new NumerosPrimos();
        GestorFicherosBinarios gfb = new GestorFicherosBinarios();
        
        gfb.guargar(n.generarPrimos());
        gfb.leer();
    }
    
}
