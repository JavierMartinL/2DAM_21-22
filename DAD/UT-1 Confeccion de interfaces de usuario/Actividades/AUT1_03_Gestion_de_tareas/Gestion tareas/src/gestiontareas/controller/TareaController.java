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
public class TareaController{
    
    private VistaPrincipal vistaPrincipal;
    private Tarea tarea;
    
    
    public TareaController(Tarea tarea, VistaPrincipal vista) {
        this.tarea = tarea;
        // Generar tareas por defecto
        this.tarea.crearTareasBase();
        this.vistaPrincipal = vista;
        
        // Ventana Principal
        this.vistaPrincipal.btnAgregar.addActionListener(this::iniciarAddTareaModal);
        this.vistaPrincipal.btnHistorial.addActionListener(this::iniciarHistorialModal);
        this.vistaPrincipal.btnModificar.addActionListener(this::iniciarUpdateTareaModal);
        
        // Modal Add Tarea
        this.vistaPrincipal.btnGuardar.addActionListener(this::agregarTarea);
        this.vistaPrincipal.btnCancelar.addActionListener(this::cerrarAddTareaModal);
        this.vistaPrincipal.spnDia.setEditor(new JSpinner.DateEditor(vistaPrincipal.spnDia, "dd/MM/yyyy"));
        
        // Modal Update Tarea
        this.vistaPrincipal.btnEditar.addActionListener(this::modificarTarea);
        this.vistaPrincipal.btnCancelarUpd.addActionListener(this::cerrarUpdateTareaModal);
        this.vistaPrincipal.btnEliminar.addActionListener(this::eliminarTarea);
        this.vistaPrincipal.spnDiaUpd.setEditor(new JSpinner.DateEditor(vistaPrincipal.spnDiaUpd, "dd/MM/yyyy"));
    }
    
    public void iniciar() {
        vistaPrincipal.setTitle("Gestión de Tareas");
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
        
        // Mostrar las actividades que siguen activas
        vistaPrincipal.txaInforTareas.setText(tarea.mostrar(false));
    }
    
    private void iniciarAddTareaModal(java.awt.event.ActionEvent evt) {       
        vistaPrincipal.dlgAddTareaModal.setModal(true);
        vistaPrincipal.dlgAddTareaModal.setTitle("Agregar nueva tarea");
        vistaPrincipal.dlgAddTareaModal.setResizable(false);
        vistaPrincipal.dlgAddTareaModal.setSize(300, 385);
        vistaPrincipal.dlgAddTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgAddTareaModal.setVisible(true);
    }
    
    private void iniciarHistorialModal(java.awt.event.ActionEvent evt) {
        // Mostrar las actividades que estan vencidas
        vistaPrincipal.txaInfoTareasVencidas.setText(tarea.mostrar(true));
        
        vistaPrincipal.dlgHistorial.setModal(true);
        vistaPrincipal.dlgHistorial.setTitle("Historial de tareas");
        vistaPrincipal.dlgHistorial.setResizable(false);
        vistaPrincipal.dlgHistorial.setSize(494, 429);
        vistaPrincipal.dlgHistorial.setLocationRelativeTo(null);
        vistaPrincipal.dlgHistorial.setVisible(true);        
    }
    
    private void iniciarUpdateTareaModal(java.awt.event.ActionEvent evt) {
        // Limpiar el JComboBox
        DefaultComboBoxModel jComboBox1Model = new DefaultComboBoxModel();
        vistaPrincipal.cmbTareas.setModel(jComboBox1Model);
        vistaPrincipal.cmbTareas.addItem("---");
        
        // Agregar todas las actividades
        for(Tarea tarea : tarea.getTareas()) {
            vistaPrincipal.cmbTareas.addItem(tarea.toString());
        }
        
        // Activar el evento al utilizar el JComboBox
        vistaPrincipal.cmbTareas.addActionListener(this::cargarTarea);
        
        vistaPrincipal.dlgUpdateTareaModal.setModal(true);
        vistaPrincipal.dlgUpdateTareaModal.setTitle("Modificar Tarea");
        vistaPrincipal.dlgUpdateTareaModal.setResizable(false);
        vistaPrincipal.dlgUpdateTareaModal.setSize(345, 450);
        vistaPrincipal.dlgUpdateTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgUpdateTareaModal.setVisible(true);
    }
    
    private void agregarTarea(java.awt.event.ActionEvent evt) {
        // Recoger los datos
        String actividad = vistaPrincipal.txtActividad.getText();
        String asignatura = vistaPrincipal.txtAsignatura.getText();
        Date dia = (Date) vistaPrincipal.spnDia.getValue();
        
        // Generar una nueva tarea
        new Tarea(actividad, asignatura, dia);
        
        // Cerrar el Modal
        cerrarAddTareaModal(evt);
    }
    
    private void cerrarAddTareaModal(java.awt.event.ActionEvent evt) {
        // Mostrar los nuevos cambios
        vistaPrincipal.txaInforTareas.setText(tarea.mostrar(false));
        
        // Limpiar los textField
        vistaPrincipal.txtActividad.setText("");
        vistaPrincipal.txtAsignatura.setText("");
        vistaPrincipal.spnDia.setValue(new Date());
        
        // Cerrar el Modal
        vistaPrincipal.dlgAddTareaModal.dispose();
    }
    
    private void cargarTarea(java.awt.event.ActionEvent evt) {
        // Comprobar si existe una tarea seleccionada en el JComboBox
        if (vistaPrincipal.cmbTareas.getSelectedIndex() == 0) {
            // Desactivar los textField
            controlarUpdateTarea(false);
            
            // Limpiar los textField
            vistaPrincipal.txtActividadUpd.setText("");
            vistaPrincipal.txtAsignaturaUpd.setText("");
            vistaPrincipal.spnDiaUpd.setValue(new Date());
            vistaPrincipal.ckbTerminar.setSelected(false);
        } else {
            // Recoger los datos de la tarea
            Tarea seleccion = tarea.getTareas().get(vistaPrincipal.cmbTareas.getSelectedIndex() - 1);
            
            // Activar los textField
            controlarUpdateTarea(true);
            
            // Cargar los datos de la tarea en los textField
            vistaPrincipal.txtActividadUpd.setText(seleccion.getActividad());
            vistaPrincipal.txtAsignaturaUpd.setText(seleccion.getAsignatura());
            vistaPrincipal.spnDiaUpd.setValue(seleccion.getDia());
            vistaPrincipal.ckbTerminar.setSelected(seleccion.isTerminar());            
        }
    }
    
    private void modificarTarea(java.awt.event.ActionEvent evt) {
        // Actividad Seleccionada
        Tarea seleccion = tarea.getTareas().get(vistaPrincipal.cmbTareas.getSelectedIndex() - 1);
        
        // Actualizar los datos
        seleccion.setActividad(vistaPrincipal.txtActividadUpd.getText());
        seleccion.setAsignatura(vistaPrincipal.txtAsignaturaUpd.getText());
        seleccion.setDia((Date) vistaPrincipal.spnDiaUpd.getValue());
        seleccion.setTerminar(vistaPrincipal.ckbTerminar.isSelected());
        
        // Cerrar el Modal
        cerrarUpdateTareaModal(evt);
    }
    
    private void cerrarUpdateTareaModal(java.awt.event.ActionEvent evt) {
        // Mostrar los nuevos cambios
        vistaPrincipal.txaInforTareas.setText(tarea.mostrar(false));
        
        // Cerrar el Modal
        vistaPrincipal.dlgUpdateTareaModal.dispose();
    }
    
    private void eliminarTarea(java.awt.event.ActionEvent evt) {
        // Eliminar una tarea
        tarea.eliminar(vistaPrincipal.cmbTareas.getSelectedIndex() - 1);
        
        // Cerrar el Modal
        cerrarUpdateTareaModal(evt);
    }
    
    private void controlarUpdateTarea(boolean activar) {
        vistaPrincipal.lblActividadUpd.setEnabled(activar);
        vistaPrincipal.txtActividadUpd.setEnabled(activar);
        vistaPrincipal.lblAsignaturaUpd.setEnabled(activar);
        vistaPrincipal.txtAsignaturaUpd.setEnabled(activar);
        vistaPrincipal.lblDiaUpd.setEnabled(activar);
        vistaPrincipal.spnDiaUpd.setEnabled(activar);
        vistaPrincipal.ckbTerminar.setEnabled(activar);
        vistaPrincipal.btnEditar.setEnabled(activar);
        vistaPrincipal.btnEliminar.setEnabled(activar);
    }
    
}