/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado;

import gestiontareasavanzado.controller.TareaController;
import gestiontareasavanzado.model.Tarea;
import gestiontareasavanzado.view.VistaPrincipal;

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
        TareaController controlador = new TareaController(tarea, vista);
        controlador.iniciar();
    }
    
}
