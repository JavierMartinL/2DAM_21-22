/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.controller;

import es.iespuertodelacruz.javier.recetas.dao.RecetaDAO;
import es.iespuertodelacruz.javier.recetas.model.Receta;
import es.iespuertodelacruz.javier.recetas.utils.GestorDDBB;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class HomeController implements Initializable {

    private GestorDDBB gestorDDBB;
    private RecetaDAO recetaDAO;
    private List<Receta> recetas;
    @FXML
    private Button btnCrearReceta;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDDBB = new GestorDDBB();
        recetaDAO = new RecetaDAO(gestorDDBB);
        
        recetas = recetaDAO.findAll();
    }    

    @FXML
    private void crearNuevaReceta(MouseEvent event) {
    }
    
}
