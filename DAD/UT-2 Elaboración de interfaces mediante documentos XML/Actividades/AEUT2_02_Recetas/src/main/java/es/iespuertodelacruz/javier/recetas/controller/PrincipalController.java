package es.iespuertodelacruz.javier.recetas.controller;

import es.iespuertodelacruz.javier.recetas.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {
    
    private Stage stage;
    private Usuario usuario;
    
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnMaximizar;
    @FXML
    private Button btnMinimizar;
    @FXML
    private Pane pnPanel;
    @FXML
    private Label btnHome;
    @FXML
    private Label btnEstadisticas;
    @FXML
    private Label btnUsuarios;
    @FXML
    private Label btnInformacion;
    @FXML
    private Label btnBuscador;
    @FXML
    private Label btnNotas;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vistaHome(null);
    }
    
    /**
     * Método que controla el evento del menu Home
     * @param event 
     */
    @FXML
    private void vistaHome(MouseEvent event) {
        try {
            pnPanel.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
            
            Node node = (Node)loader.load();
            
            HomeController hc = loader.getController();
            hc.setUsuario(usuario);
            
            pnPanel.getChildren().add(node);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método que controla el evento del menu Estadisticas
     * @param event 
     */
    @FXML
    private void vistaEstadisticas(MouseEvent event) {
        cargarVista("/view/Estadistica.fxml");
    }

    /**
     * Método que controla el evento del menu Gestion de Usuarios
     * @param event 
     */
    @FXML
    private void vistaGestionUsuarios(MouseEvent event) {
        cargarVista("/view/GestionUsuarios.fxml");
    }

    /**
     * Método que cierra la ventana
     * @param event 
     */
    @FXML
    private void cerrar(MouseEvent event) {
        stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    /**
     * Método que maximiza la ventana
     * @param event 
     */
    @FXML
    private void maximizar(MouseEvent event) {
        stage = (Stage) btnMaximizar.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    /**
     * Método que minimiza la ventana
     * @param event 
     */
    @FXML
    private void minimizar(MouseEvent event) {
        stage = (Stage) btnMinimizar.getScene().getWindow();
        stage.setIconified(true);
    }
    
    /**
     * Setter de Usuario
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        controlarMenu();
        vistaHome(null);
    }

    /**
     * Método que controla que apartados del menu mostrar segun el rol de acceso
     */
    private void controlarMenu() {
        if (usuario.getRol().equals("alumno")){
            btnUsuarios.setVisible(false);
            btnNotas.setVisible(false);
        }
    }
    
    /**
     * Método encargador de cambiar el contenido que se muestra dentro del panel
     * @param rutaVista ruta de la vista que queremos mostrar
     */
    private void cargarVista(String rutaVista) {
        try {
            pnPanel.getChildren().clear();
            Node node = (Node)FXMLLoader.load(getClass().getResource(rutaVista));
            pnPanel.getChildren().add(node);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
