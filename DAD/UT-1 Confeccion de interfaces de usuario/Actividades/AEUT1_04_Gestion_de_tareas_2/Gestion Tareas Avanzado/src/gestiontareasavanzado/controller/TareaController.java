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
        
        // Vista Principal
        this.vistaPrincipal.btnNuevaTarea.addActionListener(this::iniciarTareaModal);
        this.vistaPrincipal.btnHistorial.addActionListener(this::iniciarModal);
        
        // Modal Tarea
        this.vistaPrincipal.btnAceptar.addActionListener(this::crearTarea);
        this.vistaPrincipal.btnCancelar.addActionListener(this::cerrarTareaModal);
        this.vistaPrincipal.spnDia.setEditor(new JSpinner.DateEditor(this.vistaPrincipal.spnDia, "dd/MM/yyyy"));
    }
    
    public void iniciar() {
        vistaPrincipal.setTitle("Gestión de Tareas");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setVisible(true);        
    }
    
    private void iniciarTareaModal(java.awt.event.ActionEvent evt) {
        vistaPrincipal.dlgTareaModal.setTitle("Agregar Tarea");
        vistaPrincipal.dlgTareaModal.setSize(600, 300);
        vistaPrincipal.dlgTareaModal.setResizable(false);
        vistaPrincipal.dlgTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgTareaModal.setVisible(true);
    }
    
    private void cerrarTareaModal(java.awt.event.ActionEvent evt) {
        vistaPrincipal.dlgTareaModal.dispose();
    }
    
    private void iniciarModal(java.awt.event.ActionEvent evt) {
        
    }
    
    private void crearTarea(java.awt.event.ActionEvent evt) {
        String actividad = vistaPrincipal.txtActividad.getText();
        String asignatura = vistaPrincipal.txtAsignatura.getText();
        Date dia = (Date) vistaPrincipal.spnDia.getValue();
        
        System.out.println("Actividad: " + actividad + "\nAsignatura: " + asignatura + "\nDia: " + dia);
    }
}
