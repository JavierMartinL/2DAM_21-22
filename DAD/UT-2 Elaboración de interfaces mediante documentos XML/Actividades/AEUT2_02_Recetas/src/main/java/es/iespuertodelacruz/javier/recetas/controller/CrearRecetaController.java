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
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class CrearRecetaController implements Initializable {

    private GestorDDBB gestorDDBB;
    private RecetaDAO recetaDAO;
    private Usuario usuario;
    private Receta receta;
    private boolean actualizar;
    
    @FXML
    private Label lblTitulo;
    @FXML
    private TextField txtTitulo;
    @FXML
    private Label lblErrorTitulo;
    @FXML
    private ComboBox<String> cmbTipo;
    @FXML
    private Label lblErrorTipo;
    @FXML
    private TextField txtIngredientes;
    @FXML
    private Label lblErrorIngredientes;
    @FXML
    private TextArea txaPasos;
    @FXML
    private Label lblErrorPasos;
    @FXML
    private Spinner<Integer> spnComensales;
    @FXML
    private Spinner<Integer> spnTiempo;
    @FXML
    private TextField txtCalorias;
    @FXML
    private Label lblErrorCalorias;
    @FXML
    private Button btnCrearReceta;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDDBB = new GestorDDBB();
        recetaDAO = new RecetaDAO(gestorDDBB);
        
        actualizar = false;
        
        // Crear combobox para los tipos
        List<String> tipos = new ArrayList<>();
        tipos.add("entrantes"); 
        tipos.add("primero");
        tipos.add("segundo");
        tipos.add("postres");
        
        cmbTipo.setItems(FXCollections.observableList(tipos));
        
        limpiarErrores();
    }    

    /**
     * Método que controla el evento del boton guardar y almacena/actualiza 
     * la receta en la DDBB
     * @param event 
     */
    @FXML
    private void crearReceta(MouseEvent event) {
        limpiarErrores();
        Receta nuevaReceta = validarCampos();
        if (nuevaReceta != null) {
            if (!actualizar) {
                recetaDAO.save(nuevaReceta);
                cerrarModal();
            } else {
                nuevaReceta.setId(receta.getId());
                recetaDAO.update(nuevaReceta);
                cerrarModal();
            }
        }
    }
    
    /**
     * Método para cargar los datos de una receta
     */
    private void cargarDatos() {
        lblTitulo.setText("Modificar Receta con id " + receta.getId());
        txtTitulo.setText(receta.getNombre());
        txtIngredientes.setText(receta.getIngredientes());
        txtCalorias.setText(String.valueOf(receta.getCalorias()));
        txaPasos.setText(receta.getPasos());
        cmbTipo.setValue(receta.getTipo()); 
    }
    
    /**
     * Metodo que comprueba que todo los campos introducidos por el usuario son
     * validos
     * @return Un nueva receta con los datos intrducidos 
     */
    private Receta validarCampos() {
        Receta recet = null;
        boolean ok = true;
        
        // Recoger los valores
        String titulo = txtTitulo.getText().trim();
        String ingredientes = txtIngredientes.getText().trim();
        String strCalorias = txtCalorias.getText().trim();
        String pasos = txaPasos.getText().trim();
        String tipo = cmbTipo.getSelectionModel().getSelectedItem();
        
        int calorias = 0;
        int tiempo = 0;
        int comensales = 0;
        
        if (spnTiempo.getValue() != null) {
            tiempo = spnTiempo.getValue();
        }
        
        if (spnComensales.getValue() != null) {
            comensales = spnComensales.getValue();
        }
       
        // comprobar el titulo
        if (titulo == null || titulo.equals("")) {
            ok = false;
            lblErrorTitulo.setVisible(true);
        }
        
        // comprobar los ingredientes
        if (ingredientes == null || ingredientes.equals("")){
            ok = false;
            lblErrorIngredientes.setVisible(true);
        }
        
        // comprobar los pasos
        if (pasos == null || pasos.equals("")) {
            ok = false;
            lblErrorPasos.setVisible(true);
        }
        
        // comprobar tipo
        if (tipo == null || tipo.equals("")) {
            ok = false;
            lblErrorTipo.setVisible(true);
        }
        
        if (strCalorias != null && !strCalorias.equals("")) {
            try {
                calorias = Integer.parseInt(strCalorias);
            } catch (Exception ex) {
                lblErrorCalorias.setText("Introduce un número");;
                lblErrorCalorias.setVisible(true);
            }
        } else {
            lblErrorCalorias.setText("El campo calorias no puede esta vacío");
            lblErrorCalorias.setVisible(true);
        }
        
        if (comensales < 1) {
            comensales = 0;
        }
        
        if (tiempo < 1) {
            tiempo = 0;
        }
        
        
        // si todo esta correcto creo el nuevo usuario
        if (ok) {
            recet = new Receta();
            recet.setCalorias(calorias);
            recet.setComensales(comensales);
            recet.setIngredientes(ingredientes);
            recet.setNombre(titulo);
            recet.setPasos(pasos);
            recet.setTiempo(tiempo);
            recet.setTipo(tipo);
            recet.setUsuario(usuario);
            recet.setImagen("imagen.jpg");
        }
        
        return recet;
    }
    
    /**
     * Método que cierra el modal
     */
    private void cerrarModal() {
        Stage stage = (Stage) btnCrearReceta.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Método que oculta todo los errores
     */
    private void limpiarErrores() {
        lblErrorCalorias.setVisible(false);
        lblErrorIngredientes.setVisible(false);
        lblErrorPasos.setVisible(false);
        lblErrorTipo.setVisible(false);
        lblErrorTitulo.setVisible(false);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
        actualizar = true;
        cargarDatos();
    }
    
}
