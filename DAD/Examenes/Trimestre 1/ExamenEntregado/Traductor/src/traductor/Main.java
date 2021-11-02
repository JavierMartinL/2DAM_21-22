/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductor;

import traductor.controller.TraducirController;
import traductor.model.Traductor;
import traductor.view.TraducirView;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Inicializar la vista y el modelo
        TraducirView traducirView = new TraducirView();
        Traductor traductor = new Traductor();
        
        // Inicializar el controlador pasando la vista y el modelo
        TraducirController traducirController = new TraducirController(traducirView, traductor);
        // Mostrar la vista al usuario
        traducirController.iniciar();
    }
    
}
