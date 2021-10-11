/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonas;

import es.iespuertodelacruz.javier.gestorpersonas.controller.MenuController;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MenuController personasController = new MenuController();
        personasController.iniciar();
        
    }
    
}
