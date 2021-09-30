/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareas.controller;

import gestiontareas.model.Tarea;
import gestiontareas.view.VistaPrincipal;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
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
        // Generar tareas por defecto
        this.tarea.crearTareasBase();
        this.vistaPrincipal = vista;
        
        // Ventana Principal
        this.vistaPrincipal.btnAgregar.addActionListener(this::iniciarTareaModal);
        this.vistaPrincipal.btnHistorial.addActionListener(this::iniciarHistorialModal);
        
        // Modal Tarea
        this.vistaPrincipal.btnAceptar.addActionListener(this::agregarTarea);
        this.vistaPrincipal.btnCancelar.addActionListener(this::cerrarTareaModal);
        this.vistaPrincipal.btnEliminar.addActionListener(this::eliminarTarea);
        this.vistaPrincipal.spnDia.setEditor(new JSpinner.DateEditor(vistaPrincipal.spnDia, "dd/MM/yyyy"));
    }
    
    public void iniciar() {
        vistaPrincipal.setTitle("Gestión de Tareas");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setVisible(true);
        
        // Mostrar las actividades que siguen activas
        vistaPrincipal.txaInforTareas.setText(tarea.mostrar(false));
    }
    
    private void iniciarTareaModal(java.awt.event.ActionEvent evt) {
        // Limpiar el JComboBox
        DefaultComboBoxModel jComboBox1Model = new DefaultComboBoxModel();
        vistaPrincipal.cmbTareas.setModel(jComboBox1Model);
        vistaPrincipal.cmbTareas.addItem("---");
        
        // Agregar todas las actividades
        for (Tarea actividad : tarea.getTareas()) {
            vistaPrincipal.cmbTareas.addItem(actividad.toString());
        }
        // Activar el evento al utilizar el JComboBox
        vistaPrincipal.cmbTareas.addActionListener(this::cargarTarea);
        // Mostrar el boton de eliminar
        vistaPrincipal.btnEliminar.setVisible(false);
        
        vistaPrincipal.dlgTareaModal.setModal(true);
        vistaPrincipal.dlgTareaModal.setTitle("Agregar nueva tarea");
        vistaPrincipal.dlgTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgTareaModal.setResizable(false);
        vistaPrincipal.dlgTareaModal.setSize(510,300);
        vistaPrincipal.dlgTareaModal.setVisible(true);
    }
    
    private void iniciarHistorialModal(java.awt.event.ActionEvent evt) {
        // Mostrar las actividades que estan vencidas
        vistaPrincipal.txaInfoTareasVencidas.setText(tarea.mostrar(true));
        
        vistaPrincipal.dlgHistorial.setModal(true);
        vistaPrincipal.dlgHistorial.setTitle("Historial de tareas");
        vistaPrincipal.dlgHistorial.setLocationRelativeTo(null);
        vistaPrincipal.dlgHistorial.setResizable(false);
        vistaPrincipal.dlgHistorial.setSize(494,429);
        vistaPrincipal.dlgHistorial.setVisible(true);        
    }
    
    private void agregarTarea(java.awt.event.ActionEvent evt) {
        // Recoger los datos
        String actividad = vistaPrincipal.txtActividad.getText();
        String asignatura = vistaPrincipal.txtAsignatura.getText();
        Date dia = (Date) vistaPrincipal.spnDia.getValue();
        boolean terminar = vistaPrincipal.ckbTerminar.isSelected();
        
        // Comprobar si existe una tarea seleccionada en el JComboBox
        if (vistaPrincipal.cmbTareas.getSelectedIndex() == 0) {
            // Generar una nueva tarea
            new Tarea(actividad, asignatura, dia, terminar);
        } else {
            // Modificar una tarea
            Tarea seleccion = tarea.getTareas().get(vistaPrincipal.cmbTareas.getSelectedIndex() - 1);
            seleccion.setActividad(actividad);
            seleccion.setAsignatura(asignatura);
            seleccion.setDia(dia);
            seleccion.setTerminar(terminar);
        }
        cerrarTareaModal(evt);
    }
    
    private void eliminarTarea(java.awt.event.ActionEvent evt) {
        // Eliminar una tarea
        tarea.eliminar(vistaPrincipal.cmbTareas.getSelectedIndex() - 1);
        cerrarTareaModal(evt);
    }
    
    private void cerrarTareaModal(java.awt.event.ActionEvent evt) {
        vistaPrincipal.txaInforTareas.setText(tarea.mostrar(false));
        vistaPrincipal.txtActividad.setText("");
        vistaPrincipal.txtAsignatura.setText("");
        vistaPrincipal.spnDia.setValue(new Date());
        vistaPrincipal.dlgTareaModal.dispose();
    }
    
    private void cargarTarea(java.awt.event.ActionEvent evt) {
        // Comprobar si existe una tarea seleccionada en el JComboBox
        if (vistaPrincipal.cmbTareas.getSelectedIndex() == 0) {
            // Limpiar los textField
            vistaPrincipal.txtActividad.setText("");
            vistaPrincipal.txtAsignatura.setText("");
            vistaPrincipal.ckbTerminar.setSelected(false);
            vistaPrincipal.spnDia.setValue(new Date());
            vistaPrincipal.btnEliminar.setVisible(false);
        } else {
            // Añadir los datos de la tarea a los textField
            Tarea seleccion = tarea.getTareas().get(vistaPrincipal.cmbTareas.getSelectedIndex() - 1);
            vistaPrincipal.txtActividad.setText(seleccion.getActividad());
            vistaPrincipal.txtAsignatura.setText(seleccion.getAsignatura());
            vistaPrincipal.spnDia.setValue(seleccion.getDia());
            vistaPrincipal.ckbTerminar.setSelected(seleccion.isTerminar());
            vistaPrincipal.btnEliminar.setVisible(true);
        }
    }
    
}
