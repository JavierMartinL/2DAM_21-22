package es.iespuertodelacruz.javier.recetas.controller;

import es.iespuertodelacruz.javier.recetas.model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class PrincipalController implements Initializable {
    
    private Usuario usuario; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
