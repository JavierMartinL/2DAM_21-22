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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class LoginController implements Initializable {

    private GestorDDBB gestorDDBB;
    private UsuarioDAO usuarioDAO;
    private Stage stage; 
    
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblErrorUsuario;
    @FXML
    private Label lblErrorPassword;
    @FXML
    private Label lblErrorCredenciales;
    @FXML
    private Button btnCerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDDBB = new GestorDDBB();
        usuarioDAO = new UsuarioDAO(gestorDDBB);
        
        // ocultar todos los errores
        limpiarErrores();
    }
    
    /**
     * Metodo que controla el evento de click en el botón Login
     * @param event 
     */
    @FXML
    private void login(MouseEvent event) {
        // Recoger los campos usuario y contraseña
        String nombre = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();
        
        // ocultar los errores mostrados anteriormente
        limpiarErrores();
        
        // Validar que los campos son correctos
        if (validarCampos(nombre, password)) {
            // comprobar que las credenciales existen en la DDBB
            comprobarLogin(nombre, password);
        }
    }
    
    /**
     * Método que comprueba que los campos introducidos por el usuario son correctos
     * @param usuario nombre del usuario
     * @param password contraseña del usuario
     * @return TRUE si los campos son correctos, FALSE desde que falle alguno
     */
    private boolean validarCampos(String usuario, String password) {
        boolean datosCorrectos = true;
        
        // Comprobar usuario
        if (usuario == null || usuario.equals("")) {
            datosCorrectos = false;
            lblErrorUsuario.setText("El usuario no puede estar vacío");
            lblErrorUsuario.setVisible(true);
        }
        // Comprobar contraseña
        if (password == null || password.equals("")) {
            datosCorrectos = false;
            lblErrorPassword.setText("La contraseña no puede estar vacía");
            lblErrorPassword.setVisible(true);
        }
        
        return datosCorrectos;
    }
    
    /**
     * Método que comprueba que los datos introducidos por el usuario estan almacenados
     * dentro de la DDBB y son correctos
     * @param nombre del usuario
     * @param password del usuario
     */
    private void comprobarLogin(String nombre, String password) {
        // Buscar el usuario en la DDBB
        Usuario usuario = usuarioDAO.findByNombre(nombre);
        
        if (usuario != null) { 
            // Si existe el usuario con ese nombre
            if (password.equals(usuario.getPassword())) { 
                // Si la contraseña es correcta muestro la ventana Principal
                mostrarVentanaPrincipal(usuario);
            } else {
                // Si la contraseña es incorrecta muestro un error
                lblErrorCredenciales.setText("La contraseña introducida no es correcta");
                lblErrorCredenciales.setVisible(true);
            }
        } else {
            // Si el usuario no existe muestro un error
            lblErrorCredenciales.setText("El usuario introducido no es correcto");
            lblErrorCredenciales.setVisible(true);
        }
    }
    
    /**
     * Método que se encarga de mostrar la ventana Principal y cerrar el login
     */
    private void mostrarVentanaPrincipal(Usuario usuario) {
        try {
            // Cargar vista
            FXMLLoader loader = new FXMLLoader();
            Parent parent = loader.load(getClass().getResource("/view/Principal.fxml").openStream());
            
            // Recoger el controlador y enviarle el usuario
            PrincipalController principalController = loader.getController();
            principalController.setUsuario(usuario);
            
            // Cargar la nueva ventada Principal
            Scene scene = new Scene(parent);
            stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            
            // Cerrar la vista del login
            Stage stageLogin = (Stage) this.btnLogin.getScene().getWindow();
            stageLogin.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Método encargado de ocultar los mensaje dea error que aparecen
     */
    private void limpiarErrores() {
        lblErrorUsuario.setVisible(false);
        lblErrorPassword.setVisible(false);
        lblErrorCredenciales.setVisible(false);
    }

    /**
     * Método que cierra la ventana de login
     * @param event 
     */
    @FXML
    private void cerrar(MouseEvent event) {
        stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

}
