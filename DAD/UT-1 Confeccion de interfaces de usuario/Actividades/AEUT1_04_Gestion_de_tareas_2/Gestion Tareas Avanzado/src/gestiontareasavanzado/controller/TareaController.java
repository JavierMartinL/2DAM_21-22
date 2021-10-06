/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado.controller;

import gestiontareasavanzado.model.Tarea;
import gestiontareasavanzado.view.VistaPrincipal;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class TareaController {
    
    // Vista Principal
    private VistaPrincipal vistaPrincipal;
    // Modelo de Tarea
    private Tarea tarea;
    
    public TareaController(Tarea tarea, VistaPrincipal vista) {        
        this.tarea = tarea;
        this.vistaPrincipal = vista;
        
        // Vista Principal
        this.vistaPrincipal.btnNuevaTarea.addActionListener(this::iniciarTareaModal);
        this.vistaPrincipal.btnHistorial.addActionListener(this::iniciarHistorialModal);
        
        // Modal Tarea
        this.vistaPrincipal.btnAceptar.addActionListener(this::crearTarea);
        this.vistaPrincipal.btnCancelar.addActionListener(this::cerrarTareaModal);
        this.vistaPrincipal.spnDia.setEditor(new JSpinner.DateEditor(this.vistaPrincipal.spnDia, "dd/MM/yyyy"));
    }
    
    /**
     * Método que muestra la vista principal
     */
    public void iniciar() {
        vistaPrincipal.setTitle("Gestión de Tareas");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setVisible(true);        
    }
    
    /**
     * Método que muestra el modal para agregar una nueva tarea
     * @param evt Accion
     */
    private void iniciarTareaModal(java.awt.event.ActionEvent evt) {
        // Mostar las tareas que estan activas
        mostrarTareas(true);
        
        vistaPrincipal.dlgTareaModal.setTitle("Agregar Tarea");
        vistaPrincipal.dlgTareaModal.setSize(600, 300);
        vistaPrincipal.dlgTareaModal.setResizable(false);
        vistaPrincipal.dlgTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgTareaModal.setVisible(true);
    }
    
    /**
     * Método que muestra el modal con las tareas vencidas / terminadas
     * @param evt Accion
     */
    private void iniciarHistorialModal(java.awt.event.ActionEvent evt) {
        vistaPrincipal.dlgHistorialModal.setTitle("");
        vistaPrincipal.dlgHistorialModal.setSize(100, 100);
        vistaPrincipal.dlgHistorialModal.setResizable(false);
        vistaPrincipal.dlgHistorialModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgHistorialModal.setVisible(true);
    }
    
    
    /**
     * Método que cierra el modal para agregar una nueva tarea
     * @param evt Accion
     */
    private void cerrarTareaModal(java.awt.event.ActionEvent evt) {
        vistaPrincipal.dlgTareaModal.dispose();
    }
    
    /**
     * Método que recoje los datos de la nueva actividad y llama al modelo Tarea
     * @param evt 
     */
    private void crearTarea(java.awt.event.ActionEvent evt) {
        String actividad = vistaPrincipal.txtActividad.getText();
        String asignatura = vistaPrincipal.txtAsignatura.getText();
        Date dia = (Date) vistaPrincipal.spnDia.getValue();
        
        Tarea tarea = new Tarea(actividad, asignatura, dia, false);        
    }
    
    private void mostrarTareas(boolean activa) {
        DefaultTableModel tableModel = (DefaultTableModel) vistaPrincipal.tblInforTarea.getModel();
        tableModel.setRowCount(0);
        
        //tarea.
    }
}
