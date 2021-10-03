/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.editortextotextarea.controller;

import es.iespuertodelacruz.javier.editortextotextarea.model.GestorFicheros;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class FXMLDocumentController implements Initializable {

    private GestorFicheros gestorFicheros;
    private FileChooser fileChooser;
    
    @FXML
    private TextArea txaEditor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorFicheros = new GestorFicheros();
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Ficheros de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Ficheros de markdown", "*.md"),
                new FileChooser.ExtensionFilter("-", "*.*")
        );
    }

    @FXML
    private void nuevo(ActionEvent event) {
        if (controlarCambios()) {
            gestorFicheros.setFichero(null);
            txaEditor.clear();
            mostrarTitulo();
        }
    }

    @FXML
    private void abrir(ActionEvent event) {
        if (controlarCambios()) {
            fileChooser.setTitle("Abrir");
            File fichero = fileChooser.showOpenDialog(null);
            if (fichero != null) {
                txaEditor.clear();
                txaEditor.setText(gestorFicheros.abrir(fichero));
                mostrarTitulo();
            }
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        if (gestorFicheros.getFichero() == null) {
            guardarComo(event);
        } else {
            gestorFicheros.guardar(txaEditor.getText());
        }
    }

    @FXML
    private void guardarComo(ActionEvent event) {
        fileChooser.setTitle("Guardar como");
        File fichero = fileChooser.showSaveDialog(null);
       
        if (fichero != null) {
            gestorFicheros.guardar(fichero, txaEditor.getText());
            mostrarTitulo();
        }
        
    }

    @FXML
    private void salir(ActionEvent event) {
        if (controlarCambios()) {
            System.exit(0);
        }
    }
    
    private void mostrarTitulo() {
        String title = "Editor texto (textArea)";
        Stage stage = (Stage) txaEditor.getScene().getWindow();
        if (gestorFicheros.getFichero() != null) {
            stage.setTitle(gestorFicheros.getFichero().getName() + ": " + title);
        } else {
            stage.setTitle(title);
        }
    }
    
    private boolean controlarCambios() {        
        // Comprobar si existe un fichero abierto
        if (gestorFicheros.getFichero() != null) {
            // Si tenemos un fichero comprobamos si hay cambios
            if (gestorFicheros.comprobarCambios(txaEditor.getText())) {
                return alertaCambios(null);
            } else {
                return true;
            }
        } else {
            // Comprobar si no está vacío el textArea
            if (!txaEditor.getText().equals("")) {
                return alertaCambios(null);
            } else {
                return true;
            }
        }
    }

    private boolean alertaCambios(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Editor texto (textArea)");
        alerta.setHeaderText("¿Quieres guardar los cambios?");

        ButtonType btnGuardar = new ButtonType("Guardar");
        ButtonType btnNoGuardar = new ButtonType("No guardar");
        ButtonType btnCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        alerta.getButtonTypes().setAll(btnGuardar, btnNoGuardar, btnCancelar);

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.get() == btnGuardar){
            guardar(event);
            return true;
        } else if (resultado.get() == btnNoGuardar) {
            return true;
        } else {
            return false;
        }
    }
}
