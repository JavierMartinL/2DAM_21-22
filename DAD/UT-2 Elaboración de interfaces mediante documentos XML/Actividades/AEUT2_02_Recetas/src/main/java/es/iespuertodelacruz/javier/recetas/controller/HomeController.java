/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.controller;

import es.iespuertodelacruz.javier.recetas.dao.RecetaDAO;
import es.iespuertodelacruz.javier.recetas.model.Receta;
import es.iespuertodelacruz.javier.recetas.model.Usuario;
import es.iespuertodelacruz.javier.recetas.utils.GestorDDBB;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class HomeController implements Initializable {

    private GestorDDBB gestorDDBB;
    private RecetaDAO recetaDAO;
    private Usuario usuario;
    private List<Receta> recetas;

    @FXML
    private TableView<Receta> tbvListaRecetas;
    @FXML
    private TableColumn<Receta, Integer> clmId;
    @FXML
    private TableColumn<Receta, String> clmTitulo;
    @FXML
    private TableColumn<Receta, String> clmAutor;
    @FXML
    private TableColumn<Receta, String> clmTipo;
    @FXML
    private Label lblErrorSeleccion;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFiltro;
    @FXML
    private Button btnBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDDBB = new GestorDDBB();
        recetaDAO = new RecetaDAO(gestorDDBB);

        lblErrorSeleccion.setVisible(false);

        clmId.setCellValueFactory(new PropertyValueFactory<Receta, Integer>("id"));
        clmTitulo.setCellValueFactory(new PropertyValueFactory<Receta, String>("nombre"));
        clmAutor.setCellValueFactory(new PropertyValueFactory<Receta, String>("usuario"));
        clmTipo.setCellValueFactory(new PropertyValueFactory<Receta, String>("tipo"));

        cargarRecetas(null);
    }

    /**
     * Método que controla el boton para crear una receta
     *
     * @param event
     */
    @FXML
    private void crearReceta(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearReceta.fxml"));
            Parent root = loader.load();

            CrearRecetaController crearRecetaController = loader.getController();
            crearRecetaController.setUsuario(usuario);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        cargarRecetas(null);
    }

    /**
     * Método que controla el boton para modificar una receta
     *
     * @param event
     */
    @FXML
    private void modificarReceta(MouseEvent event) {
        Receta receta = null;
        int index = tbvListaRecetas.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            lblErrorSeleccion.setVisible(false);
            receta = recetas.get(index);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearReceta.fxml"));
                Parent root = loader.load();

                CrearRecetaController crearRecetaController = loader.getController();
                crearRecetaController.setUsuario(usuario);
                crearRecetaController.setReceta(receta);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            cargarRecetas(null);
        } else {
            lblErrorSeleccion.setText("Para eliminar una receta debes seleccionarlo en la tabla");
            lblErrorSeleccion.setVisible(true);
        }
    }

    /**
     * Método que controla el boton para eliminar una receta
     *
     * @param event
     */
    @FXML
    private void eliminarReceta(MouseEvent event) {
        Receta receta = null;
        int index = tbvListaRecetas.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            lblErrorSeleccion.setVisible(false);
            receta = recetas.get(index);

            recetaDAO.delete(receta.getId());
            cargarRecetas(null);
        } else {
            lblErrorSeleccion.setText("Para eliminar una receta debes seleccionarlo en la tabla");
            lblErrorSeleccion.setVisible(true);
        }
    }

    /**
     * Método que recoge las recetas y las muestra dentro de la lista
     */
    private void cargarRecetas(String nombre) {

        if (nombre == null) {
            recetas = recetaDAO.findAll();
        } else {
            recetas = recetaDAO.findByNombre(nombre);
        }
        tbvListaRecetas.setItems(null);
        tbvListaRecetas.setItems(FXCollections.observableList(recetas));
    }

    /**
     * Setter de Usuario
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que filtra las recetas por el nombre
     *
     * @param event
     */
    @FXML
    private void buscarReceta(MouseEvent event) {
        String nombre = txtFiltro.getText().trim();

        if (nombre != null && !nombre.equals("")) {
            cargarRecetas(nombre);
        } else {
            cargarRecetas(null);
        }
    }

    /**
     * Método que controla del doble click dentro de la lista para poder mostrar
     * todos los datos de una receta
     * @param event 
     */
    @FXML
    private void mostrarReceta(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                Receta receta = null;
                int index = tbvListaRecetas.getSelectionModel().getSelectedIndex();
                if (index >= 0) {
                    receta = recetas.get(index);
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DetalleReceta.fxml"));
                        Parent root = loader.load();

                        DetalleRecetaController detalleRecetaController = loader.getController();
                        detalleRecetaController.setReceta(receta);

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

}
