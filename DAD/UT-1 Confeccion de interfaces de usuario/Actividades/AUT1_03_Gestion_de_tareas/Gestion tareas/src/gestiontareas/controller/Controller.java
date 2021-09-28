/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareas.controller;

import gestiontareas.model.Model;
import gestiontareas.view.View;
import gestiontareas.view.addTarea;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Controller{
    
    private View vista;
    private addTarea tarea;
    private Model modelo;
    
    public Controller(Model modelo, View vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnAgregar.addActionListener(this::add);
        this.vista.btnHistorial.addActionListener(this::h);
    }
    
    public void iniciar() {
        vista.setTitle("Gestión de Tareas");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    private void add(java.awt.event.ActionEvent evt) {
        System.out.println("Voy a agregar una nueva tarea");
        tarea = new addTarea(vista, true);
        tarea.setLocationRelativeTo(null);
        tarea.setVisible(true);
    }
    
    private void h(java.awt.event.ActionEvent evt) {
        System.out.println("Voy a mostrar el historial de tareas");
    }
    
}
