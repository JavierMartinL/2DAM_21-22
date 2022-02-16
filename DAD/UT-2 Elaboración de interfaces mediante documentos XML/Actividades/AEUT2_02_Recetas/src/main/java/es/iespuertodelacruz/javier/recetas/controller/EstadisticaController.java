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
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class EstadisticaController implements Initializable {

    private GestorDDBB gestorDDBB;
    private RecetaDAO recetaDAO;
    
    private HashMap<String, Integer> tiposReceta;
    private List<Receta> recetas;
    
    @FXML
    private BarChart<?, ?> brcTipo;
    @FXML
    private PieChart pchCalorias;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDDBB = new GestorDDBB();
        recetaDAO = new RecetaDAO(gestorDDBB);
        
        recogerTipos();
        recogerCalorias();
    }    
    
    /**
     * Método que recoge los tipos de Recetas con la cantidad y genera un grafico
     * de barra con los datos
     */
    private void recogerTipos() {
        tiposReceta = recetaDAO.findDistinctTipo();
        
        for (String tipo : tiposReceta.keySet()) {
            XYChart.Series addTipo = new XYChart.Series<>();
            addTipo.getData().add(new XYChart.Data(tipo, tiposReceta.get(tipo)));
            brcTipo.getData().add(addTipo);
        }
    }
    
    private void recogerCalorias() {
        ObservableList<PieChart.Data> pierCharData = FXCollections.observableArrayList();
        recetas = recetaDAO.findAll();
        
        for (Receta receta : recetas) {
            pierCharData.add(new PieChart.Data(receta.getNombre() + " - " + receta.getCalorias() + " calorias", receta.getCalorias()));
        }
        
        pchCalorias.setData(pierCharData);
        pchCalorias.setTitle("Calorias por cada receta");
    }
    
}
