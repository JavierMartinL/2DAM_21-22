/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.javierexamenparte2.controller;

import es.iespuertodelacruz.javier.javierexamenparte2.model.Almacen;
import es.iespuertodelacruz.javier.javierexamenparte2.model.Movimiento;
import es.iespuertodelacruz.javier.javierexamenparte2.utils.ManejoFichero;
import es.iespuertodelacruz.javier.javierexamenparte2.xml.AlmacenXML;
import es.iespuertodelacruz.javier.javierexamenparte2.xml.MovimientoXML;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class FXMLDocumentController implements Initializable {
    
    private Almacen almacen;
    private ManejoFichero mf;
    private MovimientoXML movimientoXML;
    private AlmacenXML almacenXML;
    
    @FXML
    private TextField txtAsunto;
    @FXML
    private TextField txtCuantia;
    @FXML
    private TextField txtTipoMov;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnMostrar;
    @FXML
    private TextField txtCantMostrar;
    @FXML
    private TextArea txaDatos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mf = new ManejoFichero("/tmp/cuenta.xml");
        almacen = new Almacen();
        almacenXML = new AlmacenXML();
        movimientoXML = new MovimientoXML();
        
        String datos;
        try {
            datos = mf.leerTodo();
            
            if (!datos.equals("")) {
                almacen.setMovientos(almacenXML.stringXMLToObj(datos).getMovientos());
            } else {
                mf.agregarTexto(almacenXML.objToStringXML(almacen));
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void agregarMovimiento(MouseEvent event) {
        
        String asunto = txtAsunto.getText();
        String tipoMovimiento = txtTipoMov.getText();
        Integer cuantia = null;
        
        try {
            cuantia =  Integer.parseInt(txtCuantia.getText());
        } catch (Exception ex) { }
        
        if (
                (asunto != null && !asunto.trim().equals("")) && 
                (tipoMovimiento != null && !tipoMovimiento.trim().equals("")) &&
                (cuantia != null)
            ){
            Movimiento movimiento = new Movimiento(cuantia, asunto, tipoMovimiento, new Date());
            almacen.getMovientos().add(movimiento);
            mf.borrarYAgregar(almacenXML.objToStringXML(almacen));
            
            txtAsunto.setText("");
            txtTipoMov.setText("");
            txtCuantia.setText("");
        }
        
    }

    @FXML
    private void mostrarMovimiento(MouseEvent event) throws IOException {
        
        txaDatos.setText("");
        Integer cantidad = null;
        
        try {
            cantidad = Integer.parseInt(txtCantMostrar.getText());
        } catch (Exception e) {
        }
        
        String datos = mf.leerTodo();
        int saldoCuenta = 0;
            
        if (!datos.equals("")) {
            almacen.setMovientos(almacenXML.stringXMLToObj(datos).getMovientos());
            
            for (Movimiento moviento : almacen.getMovientos()) {
                saldoCuenta += moviento.getCuantia();
            }
            
            if (cantidad == null || cantidad <= 0) { 
                for (Movimiento moviento : almacen.getMovientos()) {
                    String mov = movimientoXML.objToStringXML(moviento);
                    txaDatos.appendText(mov + "\n");
                }
            } else {
                for (int i = almacen.getMovientos().size() - 1, j = 0; j < cantidad ; i--, j++) {
                    Movimiento movimiento = almacen.getMovientos().get(i);
                    String mov = movimientoXML.objToStringXML(movimiento);
                    txaDatos.appendText(mov + "\n");
                    if (i - 1 < 0) break;
                }
            }
        }
        
        txaDatos.appendText("Saldo de la cuenta = " + saldoCuenta);
        
    }
    
}
