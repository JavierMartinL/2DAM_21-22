/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortextotextarea.controller;

import editortextotextarea.model.GestorFicheros;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class FXMLDocumentController implements Initializable {

    private GestorFicheros gf;
    
    @FXML
    private TextArea txaEditor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gf = new GestorFicheros();
    }

    @FXML
    private void nuevo(ActionEvent event) {
    }

    @FXML
    private void abrir(ActionEvent event) {
    }

    @FXML
    private void guardar(ActionEvent event) {
    }

    @FXML
    private void guardarComo(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

}
