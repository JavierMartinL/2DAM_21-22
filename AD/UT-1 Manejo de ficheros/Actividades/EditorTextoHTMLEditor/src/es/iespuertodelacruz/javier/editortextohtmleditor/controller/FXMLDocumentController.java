/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.editortextohtmleditor.controller;

import es.iespuertodelacruz.javier.editortextohtmleditor.model.GestorFicheros;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.HTMLEditor;
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
    private HTMLEditor htmlEditor;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorFicheros = new GestorFicheros();
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Ficheros de html", "*.html"),
                new FileChooser.ExtensionFilter("Ficheros de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Ficheros de markdown", "*.md"),
                new FileChooser.ExtensionFilter("-", "*.*")
        );
    }    

    @FXML
    private void nuevo(ActionEvent event) {
        gestorFicheros.setFicheroActual(null);
        htmlEditor.setHtmlText("");
        mostrarTitulo();
    }

    @FXML
    private void abrir(ActionEvent event) {
        fileChooser.setTitle("Abrir");
        
        try {
            Path path = fileChooser.showOpenDialog(null).toPath();
            htmlEditor.setHtmlText("");
            htmlEditor.setHtmlText(gestorFicheros.abrir(path));
            mostrarTitulo();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        
    }

    @FXML
    private void guardar(ActionEvent event) {
        if (gestorFicheros.getFicheroActual() == null) {
            guardarComo(event);
        } else {
            gestorFicheros.guardar(htmlEditor.getHtmlText());
        }
    }

    @FXML
    private void guardarComo(ActionEvent event) {
        fileChooser.setTitle("Guardar como");
        
        try {
            Path path = fileChooser.showSaveDialog(null).toPath();
            gestorFicheros.guardar(path, htmlEditor.getHtmlText());
            mostrarTitulo();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }
    
    private void mostrarTitulo() {
        String title = "Editor texto (HTMLEditor)";
        Stage stage = (Stage) htmlEditor.getScene().getWindow();
        if (gestorFicheros.getFicheroActual() != null) {
            stage.setTitle(gestorFicheros.getFicheroActual().getName() + ": " + title);
        } else {
            stage.setTitle(title);
        }
    }
}
