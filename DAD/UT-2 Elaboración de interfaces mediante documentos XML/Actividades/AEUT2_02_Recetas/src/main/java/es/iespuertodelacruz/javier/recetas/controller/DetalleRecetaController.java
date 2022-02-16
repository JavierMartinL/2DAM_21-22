/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.controller;

import es.iespuertodelacruz.javier.recetas.model.Receta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class DetalleRecetaController implements Initializable {

    private Receta receta;
    
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblAutor;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblIngredientes;
    @FXML
    private Label lblPasos;
    @FXML
    private Label lblComensales;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblCalorias;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Método carga en el modal los datos de la receta
     */
    private void cargarDatos() {
        if (receta != null) {
            lblAutor.setText(receta.getUsuario().getNombre());
            lblCalorias.setText(String.valueOf(receta.getCalorias()));
            lblComensales.setText(String.valueOf(receta.getComensales()));
            lblIngredientes.setText(receta.getIngredientes());
            lblPasos.setText(receta.getPasos());
            lblTiempo.setText(String.valueOf(receta.getTiempo()));
            lblTipo.setText(receta.getTipo());
            lblTitulo.setText(receta.getNombre());
        }
    }
    
    public void setReceta(Receta receta) {
        this.receta = receta;
        cargarDatos();
    }
    
}
