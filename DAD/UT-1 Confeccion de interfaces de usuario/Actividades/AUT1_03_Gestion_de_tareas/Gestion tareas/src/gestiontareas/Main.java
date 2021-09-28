/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareas;

import gestiontareas.controller.Controller;
import gestiontareas.model.Model;
import gestiontareas.view.View;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model modelo = new Model();
        View vista = new View();
        Controller controlador = new Controller(modelo, vista);
        controlador.iniciar();        
    }
    
}
