/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareas.controller;

import gestiontareas.model.Tarea;
import gestiontareas.view.VistaPrincipal;
import java.util.Date;
import javax.swing.JSpinner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Controller{
    
    private VistaPrincipal vistaPrincipal;
    private Tarea tarea;
    
    public Controller(Tarea tarea, VistaPrincipal vista) {
        this.tarea = tarea;
        this.vistaPrincipal = vista;
        
        // Ventana Principal
        this.vistaPrincipal.btnAgregar.addActionListener(this::iniciarTareaModal);
        this.vistaPrincipal.btnHistorial.addActionListener(this::h);
        
        // Modal
        this.vistaPrincipal.btnAceptar.addActionListener(this::addTarea);
        this.vistaPrincipal.btnCancelar.addActionListener(this::cerrarAddTareaModal);
        this.vistaPrincipal.spnDia.setEditor(new JSpinner.DateEditor(vistaPrincipal.spnDia, "dd/MM/yyyy"));
    }
    
    public void iniciar() {
        vistaPrincipal.setTitle("Gestión de Tareas");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setVisible(true);
    }
    
    private void iniciarTareaModal(java.awt.event.ActionEvent evt) {
        vistaPrincipal.dlgAddTareaModal.setModal(true);
        vistaPrincipal.dlgAddTareaModal.setTitle("Agregar nueva tarea");
        vistaPrincipal.dlgAddTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgAddTareaModal.setResizable(false);
        vistaPrincipal.dlgAddTareaModal.setSize(490,250);
        vistaPrincipal.dlgAddTareaModal.setVisible(true);
    }
    
    private void addTarea(java.awt.event.ActionEvent evt) {
        System.out.println("Agregar nueva tarea");
        String actividad = vistaPrincipal.txtActividad.getText();
        String asignatura = vistaPrincipal.txtAsignatura.getText();
        Date dia = (Date) vistaPrincipal.spnDia.getValue();
        new Tarea(actividad, asignatura, dia);
        vistaPrincipal.txaInformacion.setText(tarea.mostrar());
        cerrarAddTareaModal(evt);
    }
    
    private void cerrarAddTareaModal(java.awt.event.ActionEvent evt) {
        vistaPrincipal.txtActividad.setText("");
        vistaPrincipal.txtAsignatura.setText("");
        vistaPrincipal.spnDia.setValue(new Date());
        vistaPrincipal.dlgAddTareaModal.dispose();
    }
    
    private void h(java.awt.event.ActionEvent evt) {
        System.out.println("Voy a mostrar el historial de tareas");
    }
    
}
