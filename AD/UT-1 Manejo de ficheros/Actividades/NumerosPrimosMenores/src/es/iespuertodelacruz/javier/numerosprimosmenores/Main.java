/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.numerosprimosmenores;

import es.iespuertodelacruz.javier.numerosprimosmenores.controller.MenuController;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MenuController menuControllar = new MenuController();
        
        menuControllar.mostrarMenu();
    }
    
}
