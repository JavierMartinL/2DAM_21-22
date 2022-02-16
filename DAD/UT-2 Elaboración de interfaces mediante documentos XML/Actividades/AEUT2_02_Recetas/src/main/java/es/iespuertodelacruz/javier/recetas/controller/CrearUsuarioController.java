/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.controller;

import es.iespuertodelacruz.javier.recetas.dao.UsuarioDAO;
import es.iespuertodelacruz.javier.recetas.model.Usuario;
import es.iespuertodelacruz.javier.recetas.utils.GestorDDBB;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class CrearUsuarioController implements Initializable {

    private GestorDDBB gestorDDBB;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private boolean actualizar;
    
    @FXML
    private TextField txtNombre;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ComboBox<String> cmbRol;
    @FXML
    private Button btnCrearUsuario;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblErrorNombre;
    @FXML
    private Label lblErrorPassword;
    @FXML
    private Label lblErrorRol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDDBB = new GestorDDBB();
        usuarioDAO = new UsuarioDAO(gestorDDBB);
        
        actualizar = false;
        
        // Crear combobox para los roles
        List<String> roles = new ArrayList<>();
        roles.add("profesor");
        roles.add("alumno");
        
        cmbRol.setItems(FXCollections.observableList(roles));
        
        limpiarErrores();
    }    

    /**
     * Método que controla el evento del boton guardar y almacena/actualiza 
     * el usuario en la DDBB
     * @param event 
     */
    @FXML
    private void crearUsuario(MouseEvent event) {
        limpiarErrores();
        Usuario user = validarCampos();
        if (user != null) {
            if (!actualizar) {
                usuarioDAO.save(user);
                cerrarModal();
            } else {
                user.setId(usuario.getId());
                usuarioDAO.update(user);
                cerrarModal();
            }
        }
    }

    /**
     * Método para cargar los datos de un usuario
     */
    private void cargarDatos() {
        lblTitulo.setText("Modificar Usuario con id " + usuario.getId());
        txtNombre.setText(usuario.getNombre());
        txtPassword.setText(usuario.getPassword());
        cmbRol.setValue(usuario.getRol());
    }
    
    /**
     * Metodo que comprueba que todo los campos introducidos por el usuario son
     * validos
     * @return Un nuevo usuario con los datos intrducidos 
     */
    private Usuario validarCampos() {
        Usuario user = null;
        boolean ok = true;
        
        // Recoger los valores
        String nombre = txtNombre.getText().trim();
        String password = txtPassword.getText().trim();
        String rol = cmbRol.getSelectionModel().getSelectedItem();
       
        // comprobar el nombre
        if (nombre == null || nombre.equals("")) {
            ok = false;
            lblErrorNombre.setVisible(true);
        }
        
        // comprobar la contraseña
        if (password == null || password.equals("")){
            ok = false;
            lblErrorPassword.setVisible(true);
        }
        
        // comprobar el rol
        if (rol == null || rol.equals("")) {
            ok = false;
            lblErrorRol.setVisible(true);
        }
        
        // si todo esta correcto creo el nuevo usuario
        if (ok) {
            user = new Usuario();
            user.setNombre(nombre);
            user.setPassword(password);
            user.setRol(rol);
        }
        
        return user;
    }
    
    /**
     * Método que cierra el modal
     */
    private void cerrarModal() {
        Stage stage = (Stage) btnCrearUsuario.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Método que oculta todo los errores
     */
    private void limpiarErrores() {
        lblErrorNombre.setVisible(false);
        lblErrorPassword.setVisible(false);
        lblErrorRol.setVisible(false);
    }
    
    /**
     * Setter de Usuario
     * @param usuario datos del usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        actualizar = true;
        cargarDatos();
    }
    
}
