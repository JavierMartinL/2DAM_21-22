/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado.controller;

import gestiontareasavanzado.model.GestorFichero;
import gestiontareasavanzado.model.Tarea;
import gestiontareasavanzado.view.VistaPrincipal;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    // Modelo encargado de la gestion del fichero
    private GestorFichero gestorFichero;
    
    public TareaController(Tarea tarea, VistaPrincipal vista) throws IOException {        
        this.tarea = tarea;
        this.vistaPrincipal = vista;
        gestorFichero = new GestorFichero();
        
        // Cargo la información que esta dentro del fichero y muestro las tareas
        try {
            tarea.cargarTareas(gestorFichero.mostrar());
            mostrarTareas(false);
        } catch (IOException e) {}
        
        // Vista Principal
        this.vistaPrincipal.btnNuevaTarea.addActionListener(this::iniciarTareaModal);
        this.vistaPrincipal.btnHistorial.addActionListener(this::iniciarHistorialModal);
        this.vistaPrincipal.btnFinalizarTarea.addActionListener((evt) -> {
            try {
                this.finalizarTareas(evt);
            } catch (IOException ex) { }
        });
        this.vistaPrincipal.tblInforTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    iniciarModTareaModal(vistaPrincipal.tblInforTarea.getSelectedRow());
                }
            }
        });
        
        // Modal Tarea
        this.vistaPrincipal.btnAceptar.addActionListener((evt) -> {
            try {
                this.crearTarea(evt);
            } catch (IOException ex) { }
        });
        this.vistaPrincipal.btnCancelar.addActionListener(this::cerrarTareaModal);
        // Formato de la fecha en el spinner
        this.vistaPrincipal.spnDia.setEditor(new JSpinner.DateEditor(this.vistaPrincipal.spnDia, "dd/MM/yyyy"));
        
        // Modal Modificacion Tarea
        this.vistaPrincipal.btnModificar.addActionListener((evt) -> {
            try {
                this.modificarTarea(evt);
            } catch (IOException ex) { }
        });
        this.vistaPrincipal.btnEliminar.addActionListener((evt) -> {
            try {
                this.eliminarTarea(evt);
            } catch (IOException ex) { }
        });
        this.vistaPrincipal.spnModDia.setEditor(new JSpinner.DateEditor(this.vistaPrincipal.spnModDia, "dd/MM/yyyy"));
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
        // Limpiar los campos
        vistaPrincipal.txtActividad.setText("");
        vistaPrincipal.txtAsignatura.setText("");
        vistaPrincipal.spnDia.setValue(new Date());
        
        vistaPrincipal.dlgTareaModal.setTitle("Nueva Tarea");
        vistaPrincipal.dlgTareaModal.setModal(true);
        vistaPrincipal.dlgTareaModal.setSize(500, 320);
        vistaPrincipal.dlgTareaModal.setResizable(false);
        vistaPrincipal.dlgTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgTareaModal.setVisible(true);
    }
    
    /**
     * Método que muestra el modal con las tareas vencidas / terminadas
     * @param evt Accion
     */
    private void iniciarHistorialModal(java.awt.event.ActionEvent evt) {
        // Mostar las tareas que NO estan activas
        mostrarTareas(true);
        
        vistaPrincipal.dlgHistorialModal.setTitle("Historial de Tareas");
        vistaPrincipal.dlgHistorialModal.setModal(true);
        vistaPrincipal.dlgHistorialModal.setSize(700, 480);
        vistaPrincipal.dlgHistorialModal.setResizable(false);
        vistaPrincipal.dlgHistorialModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgHistorialModal.setVisible(true);
    }
    
    /**
     * Método que muesta el modal para poder modificar o eliminar una tarea
     * @param index posición de la tarea selecionada
     */
    private void iniciarModTareaModal(int index) {
        Tarea tareaMod = tarea.getTarea(index);
        
        // Oculto la posición de la tarea en el ArrayList
        vistaPrincipal.lblIndex.setVisible(false);
        
        // Cargar los datos de la tarea
        vistaPrincipal.txtModActividad.setText(tareaMod.getActividad());
        vistaPrincipal.txtModAsignatura.setText(tareaMod.getAsignatura());
        vistaPrincipal.spnModDia.setValue(tareaMod.getDia());
        vistaPrincipal.lblIndex.setText("" + index);
        
        vistaPrincipal.dlgModTareaModal.setTitle("Gestion de Tarea");
        vistaPrincipal.dlgModTareaModal.setModal(true);
        vistaPrincipal.dlgModTareaModal.setSize(500, 320);
        vistaPrincipal.dlgModTareaModal.setResizable(false);
        vistaPrincipal.dlgModTareaModal.setLocationRelativeTo(null);
        vistaPrincipal.dlgModTareaModal.setVisible(true);
    }
    
    /**
     * Método que cierra el modal para agregar una nueva tarea
     * @param evt Accion
     */
    private void cerrarTareaModal(java.awt.event.ActionEvent evt) {
        // Mostar las tareas que estan activas
        mostrarTareas(false);
        // Cerrar el modal
        vistaPrincipal.dlgTareaModal.dispose();
    }
    
    /**
     * Método que cierra el modal para modificar o eliminar una tarea
     * @throws IOException 
     */
    private void cerrarModTareaModal() throws IOException {
        // Guardamos los cambios en el fichero
        gestorFichero.guardar(this.tarea.getAll());
        // Mostar las tareas que estan activas
        mostrarTareas(false);
        // Cerrar el modal
        vistaPrincipal.dlgModTareaModal.dispose();
    }
    
    /**
     * Método que recoje los datos de la nueva actividad y llama al modelo Tarea
     * @param evt 
     */
    private void crearTarea(java.awt.event.ActionEvent evt) throws IOException {
        // Recoger los valores introducidos
        String actividad = vistaPrincipal.txtActividad.getText();
        String asignatura = vistaPrincipal.txtAsignatura.getText();
        Date dia = (Date) vistaPrincipal.spnDia.getValue();
        
        // Crear una nueva tarea
        new Tarea(actividad, asignatura, dia, false);
        
        // Guardar en el fichero
        gestorFichero.guardar(this.tarea.getAll());
        
        // Cerrar el modal
        cerrarTareaModal(evt);
    }
    
    /**
     * Método que muestra en las tablas las tareas
     * @param finalizada tarea vencida/terminada(true) | tarea activa (false)
     */
    private void mostrarTareas(boolean finalizada) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel tableModel;
        
        // Segun el boolean modifico la tabla principal o la del historial
        if (!finalizada) {
            tableModel = (DefaultTableModel) vistaPrincipal.tblInforTarea.getModel();
        } else {
            tableModel = (DefaultTableModel) vistaPrincipal.tblInforHistorial.getModel();
        }
        
        tableModel.setRowCount(0);
        
        Object[] datosFila = new Object[3];
        
        // Recorrer las tareas y mostrarlas en la tabla
        for (Tarea tarea : tarea.mostrar(finalizada)) {
            String descripcion = "- " + tarea.getActividad() + " de " + tarea.getAsignatura();
            if (tarea.isTerminar()) {
                datosFila[0] = tachar(descripcion);
                datosFila[1] = tachar(formatoFecha.format(tarea.getDia()));
                datosFila[2] = tarea.isTerminar();
            } else {
                datosFila[0] = descripcion;
                datosFila[1] = formatoFecha.format(tarea.getDia());
                datosFila[2] = tarea.isTerminar();
            }
            tableModel.addRow(datosFila);
        }
    }
    
    /**
     * Método que finaliza una seleccion de tareas
     * @param evt Accion
     */
    private void finalizarTareas(java.awt.event.ActionEvent evt) throws IOException {
        // Cantidad de tareas en la tabla
        int size = vistaPrincipal.tblInforTarea.getRowCount();
        ArrayList<Integer> indexs = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            // Si tenemos una tarea marcada la añadimos al indice
            if ((boolean) vistaPrincipal.tblInforTarea.getModel().getValueAt(i, 2)) {
                indexs.add(i);
            }
        }
        
        // Finalizamos las tareas
        tarea.finalizar(indexs);
        // Guardamos los cambios en el fichero
        gestorFichero.guardar(this.tarea.getAll());
        // Mostramos los nuevos cambios
        mostrarTareas(false);
    }
    
    /**
     * Método que modifica una tarea
     * @param evt Accion
     * @throws IOException 
     */
    private void modificarTarea(java.awt.event.ActionEvent evt) throws IOException {
        int index = Integer.parseInt(vistaPrincipal.lblIndex.getText());
               
        String actividad = vistaPrincipal.txtModActividad.getText();
        String asignatura = vistaPrincipal.txtModAsignatura.getText();
        Date dia = (Date) vistaPrincipal.spnModDia.getValue();
        
        // Modificar la tarea
        tarea.modificar(index, actividad, asignatura, dia);
        
        // Cerrar el Modal
        cerrarModTareaModal();
    }
    
    /**
     * Método para eliminar una tarea
     * @param evt Accion
     * @throws IOException 
     */
    private void eliminarTarea(java.awt.event.ActionEvent evt) throws IOException {
        int index = Integer.parseInt(vistaPrincipal.lblIndex.getText());
        
        // Eliminar la Tarea
        tarea.eliminar(index);
        
        // Cerrar el Modal
        cerrarModTareaModal();
    }
    
    /**
     * Método para tachar los datos de la tabla
     * @param texto que vamos a tachar
     * @return texto tachado
     */
    private String tachar(String texto) {
        return "<html><strike>" + texto + "</strike></html>";
    }
}
