/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indicemasacorporal;

import indicemasacorporal.modelo.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author dama
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtNombre;
    @FXML
    private ToggleGroup genero;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtAltura;
    @FXML
    private TextField txtPeso;
    @FXML
    private Button btnCalular;
    @FXML
    private TextArea txaResultado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calcular(ActionEvent event) {
        
        try {
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            
            Persona persona = new Persona(nombre, apellidos, edad, altura, peso);
            
            txaResultado.insertText(txaResultado.getText().length(), persona.informacion() + "\n\n");
        } catch (Exception e) {
            
        }
        
    }
    
}
