/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.controller;

import es.iespuertodelacruz.javier.recetas.dao.UsuarioDAO;
import es.iespuertodelacruz.javier.recetas.model.Usuario;
import es.iespuertodelacruz.javier.recetas.utils.GestorDDBB;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestionUsuariosController implements Initializable {

    private GestorDDBB gestorDDBB;
    private UsuarioDAO usuarioDAO;
    private List<Usuario> usuarios;

    @FXML
    private TableView<Usuario> tbvListaUsuarios;
    @FXML
    private TableColumn<Usuario, Integer> clmId;
    @FXML
    private TableColumn<Usuario, String> clmNombre;
    @FXML
    private TableColumn<Usuario, String> clmPassword;
    @FXML
    private TableColumn<Usuario, String> clmRol;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Label lblErrorSeleccion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDDBB = new GestorDDBB();
        usuarioDAO = new UsuarioDAO(gestorDDBB);

        clmId.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("id"));
        clmNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        clmPassword.setCellValueFactory(new PropertyValueFactory<Usuario, String>("password"));
        clmPassword.setVisible(false);
        clmRol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("rol"));

        lblErrorSeleccion.setVisible(false);
        
        cargarUsuarios();
    }

    @FXML
    private void crearUsuario(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearUsuario.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
        cargarUsuarios();
    }

    @FXML
    private void modificarUsuario(MouseEvent event) {
        Usuario usuario = null;
        int index = tbvListaUsuarios.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            lblErrorSeleccion.setVisible(false);
            usuario = usuarios.get(index);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearUsuario.fxml"));
                Parent root = loader.load();
                
                CrearUsuarioController crearUsuarioController = loader.getController();
                crearUsuarioController.setUsuario(usuario);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            cargarUsuarios();
        } else {
            lblErrorSeleccion.setText("Para modificar un usuario debes seleccionarlo en la tabla");
            lblErrorSeleccion.setVisible(true);
        }
    }

    @FXML
    private void eliminarUsuario(MouseEvent event) {
        Usuario usuario = null;
        int index = tbvListaUsuarios.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            lblErrorSeleccion.setVisible(false);
            usuario = usuarios.get(index);

            usuarioDAO.delete(usuario.getId());
            
            cargarUsuarios();
        } else {
            lblErrorSeleccion.setText("Para eliminar un usuario debes seleccionarlo en la tabla");
            lblErrorSeleccion.setVisible(true);
        }
    }

    /**
     * Método que recoge los usuarios de la DDBB y lo muestra en la tableview
     */
    private void cargarUsuarios() {
        usuarios = usuarioDAO.findAll();
        tbvListaUsuarios.setItems(null);
        tbvListaUsuarios.setItems(FXCollections.observableList(usuarios));
    }

}
