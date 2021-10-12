/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.monedasxml;

import es.iespuertodelacruz.javier.monedasxml.viewController.ViewController;
import java.io.IOException;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
        ViewController vistaControlador = new ViewController();
        vistaControlador.iniciar();
    }
       
}