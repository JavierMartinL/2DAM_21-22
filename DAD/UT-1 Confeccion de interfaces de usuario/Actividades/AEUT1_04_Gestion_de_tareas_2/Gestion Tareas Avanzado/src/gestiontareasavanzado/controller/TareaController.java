/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado.controller;

import gestiontareasavanzado.model.Tarea;
import gestiontareasavanzado.view.VistaPrincipal;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class TareaController {
    
    private VistaPrincipal vistaPrincipal;
    private Tarea tarea;
    
    public TareaController(Tarea tarea, VistaPrincipal vista) {        
        this.tarea = tarea;
        this.vistaPrincipal = vista;        
    }
    
    public void iniciar() {
        vistaPrincipal.setTitle("Gestión de Tareas");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setVisible(true);
    }
    
}
