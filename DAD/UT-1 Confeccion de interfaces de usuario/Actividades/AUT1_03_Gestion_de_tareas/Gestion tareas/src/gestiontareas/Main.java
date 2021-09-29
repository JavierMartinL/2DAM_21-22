/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareas;

import gestiontareas.controller.Controller;
import gestiontareas.model.Tarea;
import gestiontareas.view.VistaPrincipal;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tarea tarea = new Tarea();
        VistaPrincipal vista = new VistaPrincipal();
        Controller controlador = new Controller(tarea, vista);
        controlador.iniciar();        
    }
    
}
