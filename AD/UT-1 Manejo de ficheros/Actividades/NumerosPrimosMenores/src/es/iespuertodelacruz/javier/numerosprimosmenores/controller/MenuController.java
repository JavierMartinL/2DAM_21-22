/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.numerosprimosmenores.controller;

import es.iespuertodelacruz.javier.numerosprimosmenores.model.GestorFichero;
import es.iespuertodelacruz.javier.numerosprimosmenores.model.NumerosPrimos;
import es.iespuertodelacruz.javier.numerosprimosmenores.view.Menu;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class MenuController {

    private Menu menu;
    private GestorFichero gestorFicero;
    
    public MenuController() {
        this.menu = new Menu();
        this.gestorFicero = new GestorFichero();
    }
    
    public void mostrarMenu() {
        NumerosPrimos numerosPrimos;
        int optLimite = menu.limitePrimos();
        
        if (optLimite == 1) {
            int maxPrimos = menu.maxNumerosPrimos();
            numerosPrimos = new NumerosPrimos(maxPrimos);
        } else {
            numerosPrimos = new NumerosPrimos();
        }
        
        int optAlmacenamiento = menu.tipoAlmacenamiento();
        if (optAlmacenamiento == 1) {
            gestorFicero.escribirUnoAUno(numerosPrimos.generarPrimos());
        } else {
            gestorFicero.escribirTodo(numerosPrimos.generarPrimos());
        }
    }
    
}
