/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado;

import gestiontareasavanzado.controller.TareaController;
import gestiontareasavanzado.model.Tarea;
import gestiontareasavanzado.view.VistaPrincipal;
import java.io.IOException;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Creo un objeto de Tarea (Modelo)
        Tarea tarea = new Tarea();
        // Creo una vista nueva del panel principal
        VistaPrincipal vista = new VistaPrincipal();
        
        // Creo el controlador y le paso la tarea (modelo) y la vista
        TareaController controlador = new TareaController(tarea, vista);
        // Inicio la vista
        controlador.iniciar();
    }
    
}
